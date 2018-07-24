package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;

public class AddJourneyActivity extends AppCompatActivity {

    private Spinner trainDropDown;
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);

        //Initialize database mgr
        dataBaseManager = new DataBaseManager(this);

        initTrainDropDown();

    }

    private void initTrainDropDown() {
        trainDropDown = findViewById(R.id.train_dropdown);

        ArrayList<String> trainNamesArrayList = new ArrayList();

        for (int i = 0; i < dataBaseManager.getTrainData().size(); i++) {
            trainNamesArrayList.add(dataBaseManager.getTrainData().get(i).getTrainName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, trainNamesArrayList);
        trainDropDown.setAdapter(adapter);
    }
}
