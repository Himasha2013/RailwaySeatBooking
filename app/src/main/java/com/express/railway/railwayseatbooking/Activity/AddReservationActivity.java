package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.R;

public class AddReservationActivity extends AppCompatActivity {

    private Bundle extras;
    private int journeyId, trainNo;
    private String journey, trainName, time;
    TextView txtTrainName, txtJourney, txtTime, totalBill;
    EditText txtDate, txtPassengerName, txtNoOfFirstClassSeats, txtNoOfSecondClassSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reservation);

        extras = getIntent().getExtras();
        txtTrainName = findViewById(R.id.txtReservationTrainName);
        txtJourney = findViewById(R.id.txtReservationJourney);
        txtTime = findViewById(R.id.txtReservationTime);
        txtDate = findViewById(R.id.txtReservationDate);
        txtPassengerName = findViewById(R.id.txtReservationPassengerName);
        txtNoOfFirstClassSeats = findViewById(R.id.txtReservationNoOfFirstClassSeats);
        txtNoOfSecondClassSeats = findViewById(R.id.txtReservationNoOfSecondClassSeats);
        totalBill = findViewById(R.id.txtReservationTotalBill);

        if (extras != null) {
            journeyId = extras.getInt("JOURNEY_ID");
            journey = extras.getString("JOURNEY");
            trainNo = extras.getInt("TRAIN_NO");
            trainName = extras.getString("TRAIN_NAME");
            time = extras.getString("TIME");
        }

        txtTrainName.setText("Train Name: " + trainName);
        txtJourney.setText(journey);
        txtTime.setText(time);
    }

    private int calculateTotalBill(int firstClassPrice, int secondClassPrice){

    }
}
