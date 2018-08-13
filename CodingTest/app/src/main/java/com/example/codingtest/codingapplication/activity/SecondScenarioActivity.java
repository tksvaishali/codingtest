package com.example.codingtest.codingapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.codingtest.codingapplication.R;
import com.example.codingtest.codingapplication.adapter.SpinnerLocationListAdapter;
import com.example.codingtest.codingapplication.domainobject.LocationDetail;
import com.example.codingtest.codingapplication.network.APIConstant;
import com.example.codingtest.codingapplication.network.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * FirstScenarioActivity is the activity which will demonstrate second scenario
 */
public class SecondScenarioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private List<LocationDetail> locationList = null;
    private APIInterface apiInterface;
    private Spinner spinner;
    private SpinnerLocationListAdapter adapter;
    private TextView carDistanceTextView, trainDistanceTextView;
    private LocationDetail selectedLocation = null;
    private Button navigateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscenario);

        initUI();
        navigateButton.setOnClickListener(this);
        locationList = new ArrayList<>();
        callWebservice();
    }

    /**
     * This method will initialise the UI
     */
    private void initUI() {
        spinner = findViewById(R.id.locationSpinner);
        carDistanceTextView = findViewById(R.id.carTextView);
        trainDistanceTextView = findViewById(R.id.trainTextView);
        navigateButton = findViewById(R.id.navigateButton);
    }

    /**
     * This method will invoke the webservice call and display the data
     */
    public void callWebservice() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(APIInterface.class);

        Call<List<LocationDetail>> call = apiInterface.getLocationData();

        call.enqueue(new Callback<List<LocationDetail>>() {
            @Override
            public void onResponse(Call<List<LocationDetail>> call, Response<List<LocationDetail>> response) {
                if (response.isSuccessful()) {
                    locationList = response.body();
                    updateSpinnerList();
                } else {
                    displayErrorDialog();
                }
            }

            @Override
            public void onFailure(Call<List<LocationDetail>> call, Throwable t) {
                displayErrorDialog();
            }
        });
    }

    private void displayErrorDialog() {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(getString(R.string.alert));
        dialogBuilder.setMessage(getString(R.string.error_message));
        dialogBuilder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = dialogBuilder.create();

        dialog.show();
    }

    /**
     * This method will update spinner with the new data
     */
    private void updateSpinnerList() {
        adapter = new SpinnerLocationListAdapter(this, android.R.layout.simple_spinner_dropdown_item, locationList);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        selectedLocation = adapter.getItem(position);
        showLocationDetails();
    }

    /**
     * This method will display the selected location details
     */
    private void showLocationDetails() {
        if (selectedLocation != null) {
            if (selectedLocation.getFromCentral().getCar() != null) {
                carDistanceTextView.setText(getString(R.string.car) + " " + selectedLocation.getFromCentral().getCar());
            } else {
                carDistanceTextView.setText(getString(R.string.car));
            }

            if (selectedLocation.getFromCentral().getTrain() != null) {
                trainDistanceTextView.setText(getString(R.string.train) + " " + selectedLocation.getFromCentral().getTrain());
            } else {
                trainDistanceTextView.setText(getString(R.string.train));
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navigateButton:
                openLocationInMap();
                break;
        }
    }

    private void openLocationInMap() {
        if (selectedLocation != null) {
            float lat = selectedLocation.getLocation().getLatitude();
            float lng = selectedLocation.getLocation().getLongitude();

            String geoUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + selectedLocation.getName() + ")";

            Uri gmmIntentUri = Uri.parse(geoUri);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }
    }
}
