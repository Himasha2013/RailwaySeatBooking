package com.express.railway.railwayseatbooking.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.express.railway.railwayseatbooking.Model.Reservation;

import java.util.List;

@Dao
public interface ReservationDao {

    @Query("SELECT * FROM Reservation")
    List<Reservation> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Reservation> reservationArrayList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Reservation reservation);

    @Query("SELECT COUNT() FROM Reservation")
    int getNumberOfRows();

    @Query("DELETE FROM Reservation")
    void clearAll();

    @Delete
    void delete(Reservation reservation);
}
