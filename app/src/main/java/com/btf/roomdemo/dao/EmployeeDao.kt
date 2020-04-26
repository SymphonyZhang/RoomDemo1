package com.btf.roomdemo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.btf.roomdemo.entity.Employee

/**
 * @Author yx.zhang
 * @Date 2020/4/26-17:28
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Dao
interface EmployeeDao {
    @Query("SELECT * FROM EMPLOYEE")
    fun getAllEmployees():List<Employee>

    @Insert
    fun insertEmployees(vararg employees: Employee)

    @Query("SELECT emp_id,name,dept FROM EMPLOYEE INNER JOIN DEPARTMENT ON EMPLOYEE.id = DEPARTMENT.emp_id")
    fun getDepartmentFromEmployee():List<InnerJoinResult>
}