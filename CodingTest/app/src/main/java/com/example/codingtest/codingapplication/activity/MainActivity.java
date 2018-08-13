package com.example.codingtest.codingapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.codingtest.codingapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scenarioButton1, scenarioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     * This method will initialise the UI
     */
    private void initUI() {
        scenarioButton1 = findViewById(R.id.scenarioBtn1);
        scenarioButton2 = findViewById(R.id.scenarioBtn2);

        scenarioButton1.setOnClickListener(this);
        scenarioButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == scenarioButton1) {
            openFirstScenarioActivity();
        } else if (view == scenarioButton2) {
            openSecondScenarioActivity();
        }
    }

    /**
     * This method will open FirstScenario activity
     */
    private void openFirstScenarioActivity() {
        Intent intent = new Intent(this, FirstScenarioActivity.class);
        startActivity(intent);
    }

    /**
     * This method will open SecondScenario activity
     */
    private void openSecondScenarioActivity() {
        Intent intent = new Intent(this, SecondScenarioActivity.class);
        startActivity(intent);
    }
}
