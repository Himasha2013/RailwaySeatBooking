package com.express.railway.railwayseatbooking.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.express.railway.railwayseatbooking.Model.Seat;

import java.util.List;

@Dao
public interface SeatDao {


    @Query("SELECT * FROM Seat")
    List<Seat> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Seat> seatsArrayList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Seat seat);

    @Query("SELECT COUNT() FROM Seat")
    int getNumberOfRows();

    @Query("DELETE FROM Seat")
    void clearAll();

    @Delete
    void delete(Seat seat);


}
