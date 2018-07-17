package com.express.railway.railwayseatbooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.express.railway.railwayseatbooking.Activity.Adpater.WeekBookingsAdapter;
import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Train;

import java.util.ArrayList;

public class WeekBookingsActivity extends AppCompatActivity {

    RecyclerView week_bookings_rv;
    LinearLayoutManager layoutManager;
    ArrayList<Train> flowers;

    //DB manager
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        initialize();
    }

    private void initialize(){
        week_bookings_rv = findViewById(R.id.flower_list_rv);

//        //Set up the layout manager for recyler view
//        layoutManager = new LinearLayoutManager(this);
//        RecyclerView.LayoutManager layoutManager_rv = layoutManager;
//        flowers_rv.setLayoutManager(layoutManager_rv);

        //Initialize database mgr
        dataBaseManager = new DataBaseManager(this);

        //Temp json objs
        Integer[] nums = {1,2,3,4};
        String[] names = {"train_1", "train_1", "train_1", "train_1"};
        boolean[] possibleBookings = {true, false, true, false};
//        int[] images = {
//                R.drawable.train,
//                R.drawable.train,
//                R.drawable.train,
//                R.drawable.train
//        };

        //Get data from the db
        ArrayList<Train> flowersArrayList = dataBaseManager.getTrainData();

        flowers = new ArrayList<>();


        if (flowersArrayList != null && flowersArrayList.size() > 0) {
            this.flowers.addAll(flowersArrayList);
        }
        else {
            for (int i = 0; i < names.length; i++) {
                flowers.add(new Train(nums[i], names[i], possibleBookings[i]));
            }
        }

        WeekBookingsAdapter adapter = new WeekBookingsAdapter(this, flowers);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        RecyclerView.LayoutManager mLayoutManager = linearLayoutManager;

        week_bookings_rv.setLayoutManager(mLayoutManager);
        week_bookings_rv.setItemAnimator(new DefaultItemAnimator());
        week_bookings_rv.setAdapter(adapter);
    }
}
