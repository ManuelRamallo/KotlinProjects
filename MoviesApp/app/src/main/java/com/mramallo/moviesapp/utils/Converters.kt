package com.mramallo.moviesapp.utils

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mramallo.moviesapp.data.entities.MovieEntity
import com.mramallo.moviesapp.domain.model.Movie

class Converters {

    @TypeConverter
    fun listToJson(value: List<MovieEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<MovieEntity>::class.java).toList()

    @TypeConverter
    fun intToList(value: String?): List<Int> {
        val listType = object: TypeToken<ArrayList<Int>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToInt(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun numberToInt(value: String?): Int {
        val listType = object: TypeToken<Number>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun intToNumber(number: Number): String {
        return Gson().toJson(number)
    }



}