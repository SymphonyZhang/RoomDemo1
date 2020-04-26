package com.btf.roomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.btf.roomdemo.dao.DepartmentDao
import com.btf.roomdemo.dao.EmployeeDao
import com.btf.roomdemo.entity.Department
import com.btf.roomdemo.entity.Employee

/**
 * @Author yx.zhang
 * @Date 2020/4/26-17:42
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Database(entities = [Department::class,Employee::class],version = 1,exportSchema = false)
abstract class DepartmentDatabase:RoomDatabase() {

    abstract fun departmentDao(): DepartmentDao

    abstract fun employee():EmployeeDao

    companion object{
        private var instance: DepartmentDatabase? = null
        fun getInstance(context: Context): DepartmentDatabase {
            if(null == instance){
                synchronized(DepartmentDatabase::class.java) {
                    if(null == instance) {
                        instance = Room.databaseBuilder(context.applicationContext, DepartmentDatabase::class.java, "department.db")
                            .build()
                    }
                }
            }
            return instance as DepartmentDatabase
        }
    }
}