package com.express.railway.railwayseatbooking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.express.railway.railwayseatbooking.Activity.Adpater.WeekBookingsAdapter;
import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Train;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;

public class WeekBookingsActivity extends AppCompatActivity {

    RecyclerView week_bookings_rv;
    LinearLayoutManager layoutManager;
    ArrayList<Train> trains;

    //DB manager
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        initialize();
    }

    private void initialize(){
        week_bookings_rv = findViewById(R.id.train_list_rv);

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
        ArrayList<Train> trainArrayList = dataBaseManager.getTrainData();

        trains = new ArrayList<>();


        if (trainArrayList != null && trainArrayList.size() > 0) {
            this.trains.addAll(trainArrayList);
        }
        else {
            for (int i = 0; i < names.length; i++) {
                trains.add(new Train(nums[i], names[i], possibleBookings[i]));
            }
        }

        WeekBookingsAdapter adapter = new WeekBookingsAdapter(this, trains);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        RecyclerView.LayoutManager mLayoutManager = linearLayoutManager;

        week_bookings_rv.setLayoutManager(mLayoutManager);
        week_bookings_rv.setItemAnimator(new DefaultItemAnimator());
        week_bookings_rv.setAdapter(adapter);
    }
}
