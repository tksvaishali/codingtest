package com.example.codingtest.codingapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.codingtest.codingapplication.R;
import com.example.codingtest.codingapplication.adapter.PageAdapter;

/**
 * FirstScenarioActivity is the activity which will demonstrate First scenario
 */
public class FirstScenarioActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView viewTextView1, viewTextView2, viewTextView3, viewTextView4, displayTextView;
    private Button redButton, blueButton, greenButton;
    private LinearLayout buttonLinearLayout;
    private ViewPager mViewPager;
    private PageAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscenario);
        initUI();
    }

    /**
     * This method will initialise the UI
     */
    private void initUI() {
        viewTextView1 = findViewById(R.id.itemTextView1);
        viewTextView2 = findViewById(R.id.itemTextView2);
        viewTextView3 = findViewById(R.id.itemTextView3);
        viewTextView4 = findViewById(R.id.itemTextView4);
        displayTextView = findViewById(R.id.displayTextView);
        buttonLinearLayout = findViewById(R.id.buttonBackgroundLinearLayout);

        mViewPager = findViewById(R.id.viewPager);

        redButton = findViewById(R.id.redBtn);
        blueButton = findViewById(R.id.blueBtn);
        greenButton = findViewById(R.id.greenBtn);

        viewTextView1.setOnClickListener(this);
        viewTextView2.setOnClickListener(this);
        viewTextView3.setOnClickListener(this);
        viewTextView4.setOnClickListener(this);

        redButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);

        mAdapter = new PageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.itemTextView1:
                setDisplayText(viewTextView1.getText().toString());
                break;
            case R.id.itemTextView2:
                setDisplayText(viewTextView2.getText().toString());
                break;
            case R.id.itemTextView3:
                setDisplayText(viewTextView3.getText().toString());
                break;
            case R.id.itemTextView4:
                setDisplayText(viewTextView4.getText().toString());
                break;
            case R.id.redBtn:
                changeBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.greenBtn:
                changeBackgroundColor(getResources().getColor(R.color.green));
                break;
            case R.id.blueBtn:
                changeBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }
    }

    /**
     * This method will change background color of layout
     *
     * @param color Color to set
     */
    private void changeBackgroundColor(int color) {
        buttonLinearLayout.setBackgroundColor(color);
    }

    /**
     * This method will display text in Textview
     *
     * @param displayText String to display
     */
    private void setDisplayText(String displayText) {
        displayTextView.setText(displayText);
    }
}
