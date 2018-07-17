package com.express.railway.railwayseatbooking.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.express.railway.railwayseatbooking.Model.Journey;

import java.util.List;

@Dao
public interface JourneyDao {


    @Query("SELECT * FROM Journey")
    List<Journey> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Journey> flowersArrayList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Journey flower);

    @Query("SELECT COUNT() FROM Journey")
    int getNumberOfRows();

    @Query("DELETE FROM Journey")
    void clearAll();

    @Delete
    void delete(Journey flower);


}
