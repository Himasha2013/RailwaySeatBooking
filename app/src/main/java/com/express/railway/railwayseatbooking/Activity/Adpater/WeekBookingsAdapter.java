package com.express.railway.railwayseatbooking.Activity.Adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.express.railway.railwayseatbooking.Activity.AddJourneyActivity;
import com.express.railway.railwayseatbooking.Activity.AddReservationActivity;
import com.express.railway.railwayseatbooking.Activity.LoginActivity;
import com.express.railway.railwayseatbooking.Activity.MainActivity;
import com.express.railway.railwayseatbooking.Activity.WeekActivity;
import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.Model.Reservation;
import com.express.railway.railwayseatbooking.Model.Train;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;

public class WeekBookingsAdapter extends RecyclerView.Adapter<WeekBookingsAdapter.ViewHolder> implements View.OnClickListener{

    private Context mContext;
    private ArrayList<Journey> mList;
    private DataBaseManager dataBaseManager;
    Button btnReservation;
    TextView txtTrainName, txtJourney, txtTime;

    public WeekBookingsAdapter(Context context, ArrayList<Journey> list) {
        mContext = context;
        mList = list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.train_item, parent, false);

        // Return a new holder instance
        ViewHolder vh = new ViewHolder(contactView);

        dataBaseManager = new DataBaseManager(context);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {

        Journey journey = mList.get(position);

        // Set item views based on your views and data model
        txtTrainName = holder.trainName;
        txtJourney = holder.journey;
        txtTime = holder.time;
        btnReservation = holder.reservation;

        txtJourney.setText("To: "+journey.getOrigin() + "  From: "+journey.getDestination());
        txtTime.setText("Time: "+journey.getTime());

        for(int i=0; i < dataBaseManager.getTrainData().size(); i++){

            if((dataBaseManager.getTrainData().get(i).getTrainNo() == journey.getTrainNo())) {

                txtTrainName.setText(dataBaseManager.getTrainData().get(i).getTrainName());

                if(dataBaseManager.getTrainData().get(i).getIsBookingAvailable()) {
                    btnReservation.setVisibility(View.VISIBLE);
                    btnReservation.setOnClickListener(this);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnReservation.getId()){
            Intent intent = new Intent(view.getContext(), AddReservationActivity.class);
            intent.putExtra("JOURNEY",txtJourney.getText().toString());
            intent.putExtra("TIME",txtTime.getText().toString());
            view.getContext().startActivity(intent);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView trainName, journey, time;
        public Button reservation;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            trainName= itemView.findViewById(R.id.txtTrainName);
            journey = itemView.findViewById(R.id.txtJourney);
            time = itemView.findViewById(R.id.txtTime);
            reservation = itemView.findViewById(R.id.btnReservation);

        }
    }
}