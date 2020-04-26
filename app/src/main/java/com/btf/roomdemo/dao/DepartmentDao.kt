package com.btf.roomdemo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.btf.roomdemo.entity.Department

/**
 * @Author yx.zhang
 * @Date 2020/4/26-17:39
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Dao
interface DepartmentDao {

    @Query("SELECT * FROM DEPARTMENT")
    fun getAllDepartments():List<Department>

    @Insert
    fun insertDepartments(vararg departments: Department)
}