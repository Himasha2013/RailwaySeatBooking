package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.express.railway.railwayseatbooking.R;

public class AddTrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_train);

        RadioGroup radioGroup = findViewById(R.id.rbgIsBookingAvailable);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            EditText  txtNoOfFirstClassSeats = findViewById(R.id.txtNoOfFirstClassSeats);
            EditText  txtNoOfSecondClassSeats = findViewById(R.id.txtNoOfSecondClassSeats);
            EditText txtFirstClassPrice =  findViewById(R.id.txtFirstClassPrice);
            EditText txtSecondClassPrice =  findViewById(R.id.txtSecondClassPrice);

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(checkedId == R.id.rbYes)
               {
                   txtNoOfFirstClassSeats.setVisibility(View.VISIBLE);
                   txtNoOfSecondClassSeats.setVisibility(View.VISIBLE);
                   txtFirstClassPrice.setVisibility(View.VISIBLE);
                   txtSecondClassPrice.setVisibility(View.VISIBLE);
               }
               else
               {
                   txtNoOfFirstClassSeats.setVisibility(View.INVISIBLE);
                   txtNoOfSecondClassSeats.setVisibility(View.INVISIBLE);
                   txtFirstClassPrice.setVisibility(View.INVISIBLE);
                   txtSecondClassPrice.setVisibility(View.INVISIBLE);
               }
            }
        });

    }
}
