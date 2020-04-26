package com.btf.roomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

/**
 * @Author yx.zhang
 * @Date 2020/4/26-17:23
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Entity(foreignKeys = arrayOf(ForeignKey(entity = Employee::class,parentColumns = arrayOf("id"),childColumns = arrayOf("emp_id"),onDelete = CASCADE)))
class Department (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var dept:String = "",
    @ColumnInfo(name = "emp_id")
    var empId:Int = 0
)