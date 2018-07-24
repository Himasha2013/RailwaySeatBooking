package com.express.railway.railwayseatbooking.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.express.railway.railwayseatbooking.Activity.Adpater.WeekBookingsAdapter;
import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;

import static com.express.railway.railwayseatbooking.Activity.WeekActivity.SEL_DAY;

public class WeekBookingsActivity extends AppCompatActivity {

    RecyclerView week_bookings_rv;
    LinearLayoutManager layoutManager;
    ArrayList<Journey> journeys;
    SharedPreferences preferences;

    //DB manager
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        initialize();
    }

    private void initialize(){
        week_bookings_rv = findViewById(R.id.train_list_rv);

        //Initialize database mgr
        dataBaseManager = new DataBaseManager(this);

        // Get data from parent intent
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        String week_name="";

        if(bd != null)
        {
            week_name = (String) bd.get("week_name");
            Toast.makeText(getApplicationContext(),week_name , Toast.LENGTH_LONG).show();
        }

        //Get data from the db
        ArrayList<Journey> journeyArrayList = dataBaseManager.getData();

        journeys = new ArrayList<>();

        //Get data by week name
        if (journeyArrayList != null && journeyArrayList.size() > 0) {
            for (int i=0; journeyArrayList.size()>i ; i++){
                if (journeyArrayList.get(i).getDay().equals(week_name)){
                    this.journeys.add(journeyArrayList.get(i));
                }
            }
        }
        else {
            System.out.println("ERROR FETCHING DATA");
        }

        //journeys.add(new Journey(1,2,"sad", "sasdc", "yashufidhoc", "278347", true));
        WeekBookingsAdapter adapter = new WeekBookingsAdapter(this, journeys);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        RecyclerView.LayoutManager mLayoutManager = linearLayoutManager;

        week_bookings_rv.setLayoutManager(mLayoutManager);
        week_bookings_rv.setItemAnimator(new DefaultItemAnimator());
        week_bookings_rv.setAdapter(adapter);
    }
}
