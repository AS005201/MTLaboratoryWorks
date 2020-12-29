package com.jenya.lab23.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.jenya.lab23.pojo.MovieDetails;

import java.util.List;

@Dao
public interface DAO {

    @Query("SELECT * FROM moviedetails")
    List<MovieDetails> getAll();

    @Query("SELECT * FROM moviedetails WHERE id = :id")
    MovieDetails getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieDetails item);

}