package com.btf.roomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.btf.roomdemo.dao.UserDao
import com.btf.roomdemo.entity.User

/**
 * @Author yx.zhang
 * @Date 2020/4/23-10:17
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase = INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                            ?: (Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "userInfo.db").fallbackToDestructiveMigration().build()).also { INSTANCE = it }
                }
    }
}