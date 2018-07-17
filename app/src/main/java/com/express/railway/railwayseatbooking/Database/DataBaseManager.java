package com.express.railway.railwayseatbooking.Database;

import android.content.Context;
import android.os.AsyncTask;

import com.express.railway.railwayseatbooking.Database.Dao.JourneyDao;
import com.express.railway.railwayseatbooking.Model.Journey;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DataBaseManager {

    private static JourneyDao journeyDao;

    public DataBaseManager(Context context) {
        journeyDao = DatabaseHolder.getDatabaseInstance(context).journeyDao();
    }

    public void saveDataToDataBase(ArrayList<Journey> arrayList) {
        SaveDataToDatabase saveDataToDatabase = new SaveDataToDatabase( arrayList);
        saveDataToDatabase.execute();
    }

    public void saveItemToDataBase(Journey entry) {
        SaveItemToDatabase saveItemToDatabase = new SaveItemToDatabase( entry);
        saveItemToDatabase.execute();
    }


    public void remove(Journey flower) {
        RemoveItemFromDataBase removeItemFromDataBase = new RemoveItemFromDataBase(flower);
        removeItemFromDataBase.execute();
    }


    public int listSize() {
        return journeyDao.getNumberOfRows();
    }


    public ArrayList<Journey> getData() {
        retrievedDataFromDatabase retrievedDataFromDatabase =
                new retrievedDataFromDatabase();
        try {
            ArrayList<Journey> es = retrievedDataFromDatabase.execute().get();
            return es;
        } catch (InterruptedException | ExecutionException e) {
            return new ArrayList<>();
        }
    }


    public void removeAll() {
        journeyDao.clearAll();
    }

    private static class SaveDataToDatabase extends AsyncTask<Void, Void, Void> {


        private ArrayList<Journey> flowersArrayList;


        SaveDataToDatabase( ArrayList<Journey> entry) {

            this.flowersArrayList = entry;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            journeyDao.saveAll(flowersArrayList);
            return null;

        }
    }

    private static class SaveItemToDatabase extends AsyncTask<Void, Void, Void> {

        private Journey flower;


        SaveItemToDatabase(Journey flower) {
            this.flower = flower;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            journeyDao.save(flower);
            return null;

        }
    }

    private static class RemoveItemFromDataBase extends AsyncTask<Void, Void, Void> {

        private Journey flower;


        RemoveItemFromDataBase(Journey flower) {
            this.flower = flower;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            journeyDao.delete(flower);
            return null;
        }
    }

    private static class retrievedDataFromDatabase extends AsyncTask<Void, Void, ArrayList<Journey>> {

        @Override
        protected ArrayList<Journey> doInBackground(Void... voids) {
            return (ArrayList<Journey>) journeyDao.getAll();
        }

        @Override
        protected void onPostExecute(ArrayList<Journey> es) {
            super.onPostExecute(es);
        }
    }
}
