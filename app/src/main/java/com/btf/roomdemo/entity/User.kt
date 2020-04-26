package com.btf.roomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author yx.zhang
 * @Date 2020/4/22-17:38
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    @ColumnInfo(name = "name")
    var name:String = "",
    @ColumnInfo(name = "age")
    var age:Int = 0

)