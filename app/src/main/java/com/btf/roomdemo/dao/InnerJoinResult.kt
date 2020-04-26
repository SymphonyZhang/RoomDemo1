package com.btf.roomdemo.dao

import androidx.room.ColumnInfo

/**
 * @Author yx.zhang
 * @Date 2020/4/26-18:20
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class InnerJoinResult (
    @ColumnInfo(name = "emp_id")
    var empId:Int = 0,
    var name:String = "",
    var dept:String = ""
)