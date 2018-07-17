package com.express.railway.railwayseatbooking.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.express.railway.railwayseatbooking.Database.Dao.JourneyDao;
import com.express.railway.railwayseatbooking.Database.Dao.TrainDao;
import com.express.railway.railwayseatbooking.Model.Journey;
import com.express.railway.railwayseatbooking.Model.Reservation;
import com.express.railway.railwayseatbooking.Model.Seat;
import com.express.railway.railwayseatbooking.Model.Train;

@Database(entities = {Journey.class, Reservation.class, Seat.class, Train.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    //Add all Dao here
    public abstract JourneyDao journeyDao();
    public abstract TrainDao trainDao();

}

