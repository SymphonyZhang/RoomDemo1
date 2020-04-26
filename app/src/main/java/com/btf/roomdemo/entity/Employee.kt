package com.btf.roomdemo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author yx.zhang
 * @Date 2020/4/26-17:20
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Entity
class Employee (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var name:String = "",
    var age:Int = 0,
    var address:String = "",
    var salary:Double
)