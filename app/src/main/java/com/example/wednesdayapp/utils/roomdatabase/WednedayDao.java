package com.example.wednesdayapp.utils.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface WednedayDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long InsertDatEntry(WednsedayTable table);

    @Query("Select * from WEDNESDAY_TABLE where TRACK_NAME=:searchTerm")
    List<WednsedayTable> getTableEntries(String searchTerm);

    @Delete
    public void DeleteEntry(WednsedayTable table);
}
