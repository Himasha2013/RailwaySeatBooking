package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.R;

public class AddReservationActivity extends AppCompatActivity {

    private Bundle extras;
    private int journeyId, trainNo, firstClassPrice, secondClassPrice ;
    private String journey, trainName, time;
    TextView txtTrainName, txtJourney, txtTime, txtTotalBill, txtFirstClassPrice, txtSecondClassPrice;
    EditText txtDate, txtPassengerName, txtNoOfFirstClassSeats, txtNoOfSecondClassSeats;
    Button btnAddReservation;

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
//        txtNoOfFirstClassSeats = findViewById(R.id.txtReservationNoOfFirstClassSeats);
//        txtNoOfSecondClassSeats = findViewById(R.id.txtReservationNoOfSecondClassSeats);
//        txtTotalBill = findViewById(R.id.txtReservationTotalBill);
//        txtFirstClassPrice = findViewById(R.id.txtReservationFirstClassPrice);
//        txtSecondClassPrice = findViewById(R.id.txtReservationSecondClassPrice);
        btnAddReservation = findViewById(R.id.btnAddReservation);

        if (extras != null) {
            journeyId = extras.getInt("JOURNEY_ID");
            journey = extras.getString("JOURNEY");
            trainNo = extras.getInt("TRAIN_NO");
            trainName = extras.getString("TRAIN_NAME");
            time = extras.getString("TIME");
//            firstClassPrice = extras.getInt("FIRST_CLASS_PRICE");
//            secondClassPrice = extras.getInt("SECOND_CLASS_PRICE");
        }

        txtTrainName.setText("Train Name: " + trainName);
        txtJourney.setText(journey);
        txtTime.setText(time);
//        txtFirstClassPrice.setText(firstClassPrice);
//        txtSecondClassPrice.setText(secondClassPrice);

        btnAddReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                int noOfFirstClass = txtNoOfFirstClassSeats.toString().isEmpty() ? 0 : Integer.parseInt(txtNoOfFirstClassSeats.toString());
//                int noOfSecondClass = txtNoOfSecondClassSeats.toString().isEmpty() ? 0 : Integer.parseInt(txtNoOfSecondClassSeats.toString());
//
//                int firstClassPrice = txtFirstClassPrice.toString().isEmpty() ? 0 : Integer.parseInt(txtFirstClassPrice.toString());
//                int secondClassPrice = txtSecondClassPrice.toString().isEmpty() ? 0 : Integer.parseInt(txtSecondClassPrice.toString());
//
//                txtTotalBill.setText(calculateTotalBill(firstClassPrice,noOfFirstClass,secondClassPrice,noOfSecondClass));
//
//                Toast.makeText(getApplicationContext(),"Reservation Added Successfully! \n Total Bill: " + txtTotalBill.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private int calculateTotalBill(int firstClassPrice, int noOfFirstClassSeats, int secondClassPrice, int noOfSecondClassSeats){

        return firstClassPrice*noOfFirstClassSeats + secondClassPrice*noOfSecondClassSeats;
    }
}
