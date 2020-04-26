package com.btf.roomdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.btf.roomdemo.entity.User

/**
 * @Author yx.zhang
 * @Date 2020/4/23-10:23
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Dao
interface UserDao {

    @Insert
    fun insertUsers(vararg user: User)

    @Delete
    fun deleteUsers(vararg user: User)

    @Update
    fun updateUsers(vararg user: User)

    @Query("SELECT * FROM USER ORDER BY ID ASC")
    fun getAll(): LiveData<List<User>>

    /*@Query("SELECT * FROM USER WHERE id = :id")
    fun getUsersById(id: Long): User

    @Query("SELECT * FROM USER WHERE name = :name")
    fun getUsersByName(name:String): LiveData<List<User>>*/

    @Query("DELETE FROM USER")
    fun deleteAllUsers()


}