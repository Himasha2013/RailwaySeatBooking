package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.express.railway.railwayseatbooking.R;

public class AddBookingActivity extends AppCompatActivity {

    private Spinner timeRangesDropDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);

        initTimeRangesDropDown();

    }

    private void initTimeRangesDropDown() {
        timeRangesDropDown = findViewById(R.id.time_dropdown);
        String[] time_ranges = new String[]{"1", "2", "three"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, time_ranges);
        timeRangesDropDown.setAdapter(adapter);
    }
}
