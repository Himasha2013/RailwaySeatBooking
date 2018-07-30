package com.express.railway.railwayseatbooking.Activity.Adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.express.railway.railwayseatbooking.Activity.AddReservationActivity;
import com.express.railway.railwayseatbooking.Database.DataBaseManager;
import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;

public class WeekBookingsAdapter extends RecyclerView.Adapter<WeekBookingsAdapter.ViewHolder> implements View.OnClickListener{

    private ArrayList<Journey> mList;
    private DataBaseManager dataBaseManager;

    public WeekBookingsAdapter(Context context, ArrayList<Journey> list) {
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
       final TextView txtTrainName = holder.trainName;
       final TextView txtOrigin = holder.origin;
       final TextView txtDestination = holder.destination;
       final TextView txtTime = holder.time;
       final TextView firstClassPrice = holder.firstClassPrice;
       final TextView secondClassPrice = holder.secondClassPrice;
       final Button btnReservation = holder.reservation;
       final int journeyId, trainNo;

        txtOrigin.setText("From: "+journey.getOrigin());
        txtDestination.setText("To: "+journey.getDestination());
        journeyId = journey.getJourneyID();
        trainNo = journey.getTrainNo();
        txtTime.setText("Time: "+journey.getTime());

        for(int i=0; i < dataBaseManager.getTrainData().size(); i++){

            if((dataBaseManager.getTrainData().get(i).getTrainNo() == journey.getTrainNo())) {

                txtTrainName.setText(dataBaseManager.getTrainData().get(i).getTrainName());
//                firstClassPrice.setText(dataBaseManager.getSeatData().get(i).getFirstClassPrice());
//                secondClassPrice.setText(dataBaseManager.getSeatData().get(i).getSecondClassPrice());

                if(dataBaseManager.getTrainData().get(i).getIsBookingAvailable()) {
                    btnReservation.setVisibility(View.VISIBLE);
                    btnReservation.setOnClickListener(this);
                }
            }
        }

        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddReservationActivity.class);
                intent.putExtra("JOURNEY_ID",journeyId);
                intent.putExtra("JOURNEY",txtOrigin.getText() + "  " + txtDestination.getText());
                intent.putExtra("TRAIN_NO",trainNo);
                intent.putExtra("TRAIN_NAME",txtTrainName.getText());
                intent.putExtra("TIME",txtTime.getText());
//                intent.putExtra("FIRST_CLASS_PRICE",firstClassPrice.getText());
//                intent.putExtra("SECOND_CLASS_PRICE",secondClassPrice.getText());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView trainName, origin, destination, time, firstClassPrice, secondClassPrice;
        public Button reservation;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            trainName= itemView.findViewById(R.id.txtTrainName);
            origin = itemView.findViewById(R.id.txtOrigin);
            destination = itemView.findViewById(R.id.txtDestination);
            time = itemView.findViewById(R.id.txtTime);
            reservation = itemView.findViewById(R.id.btnReservation);
//            firstClassPrice = itemView.findViewById(R.id.txtReservationFirstClassPrice);
//            secondClassPrice = itemView.findViewById(R.id.txtReservationFirstClassPrice);

        }
    }
}