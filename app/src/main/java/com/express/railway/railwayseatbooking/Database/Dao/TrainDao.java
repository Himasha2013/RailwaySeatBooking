package com.express.railway.railwayseatbooking.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.express.railway.railwayseatbooking.Model.Train;

import java.util.List;

@Dao
public interface TrainDao {


    @Query("SELECT * FROM Train")
    List<Train> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Train> trainsArrayList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Train train);

    @Query("SELECT COUNT() FROM Train")
    int getNumberOfRows();

    @Query("DELETE FROM Train")
    void clearAll();

    @Delete
    void delete(Train train);


}
