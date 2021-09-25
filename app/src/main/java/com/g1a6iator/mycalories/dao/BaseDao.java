package com.g1a6iator.mycalories.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

interface BaseDao<T> {

    @Insert
    void insert(T t);

    @Update
    void update(T t);

    @Delete
    void delete(T t);
}
