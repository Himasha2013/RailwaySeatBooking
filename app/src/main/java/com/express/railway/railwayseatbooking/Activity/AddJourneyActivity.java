package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.R;
import java.util.HashMap;

public class AddJourneyActivity extends AppCompatActivity {


    private DataBaseManager dataBaseManager;
    private RadioGroup radioGroup;
    private Spinner trainDropDown;
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

        initTrainDropDown();

        trainDropDown = findViewById(R.id.train_dropdown);
        txtOrigin = findViewById(R.id.txtOrigin);
        txtDestination = findViewById(R.id.txtDestination);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        radioGroup = findViewById(R.id.rbgStatus);
        addJourneyBtn = findViewById(R.id.addJourneyBtn);
        spinnerMap = new HashMap<>();

        addJourneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int trainNo = Integer.parseInt(spinnerMap.get(trainDropDown.getSelectedItemPosition()));
                boolean status = radioGroup.getCheckedRadioButtonId() == R.id.rbActive ? true : false;

                Journey journey = new Journey(trainNo,txtOrigin.getText().toString(),txtDestination.getText().toString(), txtDate.getText().toString(), txtTime.getText().toString(), status);
                //Insert in to the db
                dataBaseManager.SaveJourneyToDatabase(journey);
            }
        });
    }

    private void initTrainDropDown() {

        String[] trainNames = new String[dataBaseManager.getTrainData().size()];

        for (int i = 0; i < dataBaseManager.getTrainData().size(); i++) {

            spinnerMap.put(dataBaseManager.getTrainData().get(i).getTrainNo(), dataBaseManager.getTrainData().get(i).getTrainName());
            trainNames[i] = dataBaseManager.getTrainData().get(i).getTrainName();
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item, trainNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trainDropDown.setAdapter(adapter);
    }
}
