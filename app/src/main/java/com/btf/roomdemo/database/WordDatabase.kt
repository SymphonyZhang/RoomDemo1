package com.btf.roomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.btf.roomdemo.dao.WordDao
import com.btf.roomdemo.entity.Word

/**
 * @Author yx.zhang
 * @Date 2020/4/23-13:30
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Database(entities = [Word::class],version = 5,exportSchema = false)
abstract class WordDatabase : RoomDatabase(){
    abstract fun getWordDao(): WordDao

    companion object{

        private val MIGRATION_2_3 = object :Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE WORD ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1")
            }

        }
        private val MIGRATION_3_4 = object :Migration(3,4){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL,english_word TEXT NOT NULL,chinese_meaning TEXT NOT NULL)")
                database.execSQL("INSERT INTO word_temp(id,english_word,chinese_meaning) SELECT id,english_word,chinese_meaning FROM WORD")
                database.execSQL("DROP TABLE WORD")
                database.execSQL("ALTER TABLE word_temp RENAME to WORD")
            }
        }

        private val MIGRATION_4_5 = object :Migration(4,5){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE WORD ADD COLUMN chinese_invisible INTEGER NOT NULL DEFAULT 0")
            }

        }

        private var instance: WordDatabase? = null
        fun getInstance(context: Context): WordDatabase {
            if(null == instance){
                synchronized(WordDatabase::class.java) {
                    if(null == instance) {
                        instance = Room.databaseBuilder(context.applicationContext, WordDatabase::class.java, "userInfo.db")
                                .addMigrations(MIGRATION_4_5)
                                .build()
                    }
                }
            }
            return instance as WordDatabase
        }
    }
}