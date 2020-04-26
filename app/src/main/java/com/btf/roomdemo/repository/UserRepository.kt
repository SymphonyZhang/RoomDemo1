package com.btf.roomdemo.repository

import androidx.lifecycle.LiveData
import com.btf.roomdemo.App
import com.btf.roomdemo.dao.UserDao
import com.btf.roomdemo.database.UserDatabase
import com.btf.roomdemo.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @Author yx.zhang
 * @Date 2020/4/26-9:16
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class UserRepository {
    var allUser:LiveData<List<User>>

    private val userDao: UserDao

    init {
        val userDatabase = UserDatabase.getInstance(App.instance())
        userDao = userDatabase.userDao()
        allUser = userDao.getAll()
    }

    fun insert(vararg users: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insertUsers(*users)
        }

    }

    fun update(vararg users: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.updateUsers(*users)
        }

    }

    fun delete(vararg users: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteUsers(*users)
        }

    }

    fun deleteAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteAllUsers()
        }

    }
}