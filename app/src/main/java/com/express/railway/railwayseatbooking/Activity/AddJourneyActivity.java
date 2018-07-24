package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.Model.Train;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddJourneyActivity extends AppCompatActivity {


    private DataBaseManager dataBaseManager;
    private RadioGroup radioGroup;
    private Spinner trainDropDown;
    private Spinner daysDropDown;
    private Spinner date_dropdown;
    private EditText  txtOrigin;
    private EditText txtDestination;
    private EditText txtDate;
    private EditText  txtTime;
    private Button addJourneyBtn;
    HashMap<Integer,String> spinnerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);

        //Initialize database mgr
        dataBaseManager = new DataBaseManager(this);

        ArrayList<Train> trains  = dataBaseManager.getTrainData();

        //System.out.println(trains.size());


        trainDropDown = findViewById(R.id.train_dropdown);
        daysDropDown = findViewById(R.id.date_dropdown);
        txtOrigin = findViewById(R.id.txtOrigin);
        txtDestination = findViewById(R.id.txtDestination);
        txtTime = findViewById(R.id.txtTime);
        radioGroup = findViewById(R.id.rbgStatus);
        addJourneyBtn = findViewById(R.id.addJourneyBtn);
        spinnerMap = new HashMap<>();

        initTrainDropDown();

        addJourneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!trainDropDown.getSelectedItem().toString().isEmpty() &&
                    !daysDropDown.getSelectedItem().toString().isEmpty() &&
                    !txtOrigin.getText().toString().isEmpty() &&
                    !txtDestination.getText().toString().isEmpty() &&
                    !txtTime.getText().toString().isEmpty()
                    ){
                    String selected_train = trainDropDown.getSelectedItem().toString();
                    String selected_date = daysDropDown.getSelectedItem().toString();

                    int train_id = 0;

                    // Get train id
                    for (Map.Entry<Integer, String> entry : spinnerMap.entrySet()) {
                        if (entry.getValue().equals(selected_train)) {
                            train_id = entry.getKey();
                        }
                    }

                    //String train = spinnerMap.get(trainDropDown.getSelectedItem());

                    //int trainNo = Integer.parseInt(spinnerMap.get(trainDropDown.getSelectedItem()));

                    boolean status = radioGroup.getCheckedRadioButtonId() == R.id.rbActive ? true : false;

                    Journey journey = new Journey(
                            train_id,txtOrigin.getText().toString(),
                            txtDestination.getText().toString(),
                            selected_date,
                            txtTime.getText().toString(),
                            status);

                    //Insert in to the db
                    dataBaseManager.SaveJourneyToDatabase(journey);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill all required fields", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void initTrainDropDown() {

        String[] trainNames = new String[dataBaseManager.getTrainData().size()];

        String[] daysList = {
                "Monday","Tuesday","Wednesday","Thursday","Friday"
        };

        for (int i = 0; i < dataBaseManager.getTrainData().size(); i++) {
            spinnerMap.put(dataBaseManager.getTrainData().get(i).getTrainNo(), dataBaseManager.getTrainData().get(i).getTrainName());
            trainNames[i] = dataBaseManager.getTrainData().get(i).getTrainName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item, trainNames);
        ArrayAdapter<String> adapter_days =new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item, daysList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_days.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trainDropDown.setAdapter(adapter);
        daysDropDown.setAdapter(adapter_days);
    }
}
