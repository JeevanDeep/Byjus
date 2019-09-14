package com.jeevan.byjus.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jeevan.byjus.headlines.home.response.headlines.Source


class TypeConvertors {

    val gson = Gson()

    @TypeConverter
    fun sourceToString(source: Source): String {
        return gson.toJson(source)
    }

    @TypeConverter
    fun stringToSource(string: String): Source {
        val type = object : TypeToken<Source>() {}.type
        return gson.fromJson<Source>(string, type)
    }
}