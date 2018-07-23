package com.express.railway.railwayseatbooking.Activity.Adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.Model.Train;
import com.express.railway.railwayseatbooking.R;

import java.util.ArrayList;

public class WeekBookingsAdapter extends RecyclerView.Adapter<WeekBookingsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Journey> mList;

    public WeekBookingsAdapter(Context context, ArrayList<Journey> list) {
        mContext = context;
        mList = list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.train_item, parent, false);

        // Return a new holder instance
        ViewHolder vh = new ViewHolder(contactView);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Journey journey = mList.get(position);

        // Set item views based on your views and data model
        TextView name = holder.name;
        TextView time = holder.price;
        ImageView image = holder.image;

        name.setText("Origin: "+journey.getOrigin() + "  Destination: "+journey.getDestination());
        time.setText(journey.getTime());
        //image.setImageResource(train.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView image;
        public TextView name, price;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
//
            //image = itemView.findViewById(R.id.FlowerImg);
            name = itemView.findViewById(R.id.txtFlowerName);
            price = itemView.findViewById(R.id.txtPrice);

        }
    }
}