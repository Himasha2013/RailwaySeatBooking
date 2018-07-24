package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Seat;
import com.express.railway.railwayseatbooking.Model.Train;
import com.express.railway.railwayseatbooking.R;


public class AddTrainActivity extends AppCompatActivity {

    //DB manager
    private DataBaseManager dataBaseManager;
    private EditText txtTrainName;
    private Button addTrainBtn;
    private RadioGroup radioGroup;
    private EditText  txtNoOfFirstClassSeats;
    private EditText  txtNoOfSecondClassSeats;
    private EditText txtFirstClassPrice;
    private EditText txtSecondClassPrice;
    private boolean isBookingAvailable = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_train);

        //Initialize database mgr
       dataBaseManager = new DataBaseManager(this);

        txtTrainName = findViewById(R.id.txtTrainName);
        radioGroup = findViewById(R.id.rbgIsBookingAvailable);
        addTrainBtn = findViewById(R.id.add_train_btn);

        txtNoOfFirstClassSeats = findViewById(R.id.txtNoOfFirstClassSeats);
        txtNoOfSecondClassSeats = findViewById(R.id.txtNoOfSecondClassSeats);
        txtFirstClassPrice =  findViewById(R.id.txtFirstClassPrice);
        txtSecondClassPrice =  findViewById(R.id.txtSecondClassPrice);


//        Toast.makeText(getApplicationContext(),"ARRAAAYY"+
//                dataBaseManager.getSeatData().get(0).getTrainNo(),
//                Toast.LENGTH_LONG).show();

//        for(int i=dataBaseManager.getSeatData().size()-1 ; i>0 ; i--){
//            Toast.makeText(getApplicationContext(),
//                    dataBaseManager.getSeatData().get(i).getNoOfFirstClassSeats(),
//                    Toast.LENGTH_LONG);
//        }

        addTrainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Save train details
                if(isBookingAvailable){
                    Train train = new Train(txtTrainName.getText().toString(), isBookingAvailable);
                    //dataBaseManager.SaveTrainToDatabase(train);

                    Seat seat = new Seat(
                            1,
                            Integer.parseInt(txtNoOfFirstClassSeats.getText().toString()),
                            Integer.parseInt(txtNoOfSecondClassSeats.getText().toString()),
                            Integer.parseInt(txtFirstClassPrice.getText().toString()),
                            Integer.parseInt(txtSecondClassPrice.getText().toString())
                    );
                    //Insert in to the db
                    dataBaseManager.SaveTrainAndSeatToDatabase(train, seat);

                }
                else{
                    Train train = new Train(txtTrainName.getText().toString(), isBookingAvailable);
                    //Insert in to the db
                    dataBaseManager.SaveTrainToDatabase(train);
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(checkedId == R.id.rbYes)
               {
                   isBookingAvailable= true;
                   txtNoOfFirstClassSeats.setVisibility(View.VISIBLE);
                   txtNoOfSecondClassSeats.setVisibility(View.VISIBLE);
                   txtFirstClassPrice.setVisibility(View.VISIBLE);
                   txtSecondClassPrice.setVisibility(View.VISIBLE);
               }
               else
               {
                   isBookingAvailable = false;
                   txtNoOfFirstClassSeats.setVisibility(View.INVISIBLE);
                   txtNoOfSecondClassSeats.setVisibility(View.INVISIBLE);
                   txtFirstClassPrice.setVisibility(View.INVISIBLE);
                   txtSecondClassPrice.setVisibility(View.INVISIBLE);
               }
            }
        });

    }


}
