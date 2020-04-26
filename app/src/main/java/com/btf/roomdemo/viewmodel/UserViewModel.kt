package com.btf.roomdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.btf.roomdemo.entity.User
import com.btf.roomdemo.repository.UserRepository

/**
 * @Author yx.zhang
 * @Date 2020/4/26-9:15
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class UserViewModel : ViewModel() {
    private val userRepository: UserRepository = UserRepository()

    val allUsers: LiveData<List<User>>
        get() = userRepository.allUser

    fun  insertUser(vararg users: User){
        userRepository.insert(*users)
    }

    fun  updateUsers(vararg users: User){
        userRepository.update(*users)
    }

    fun  deletetUser(vararg users: User){
        userRepository.delete(*users)
    }

    fun  deleteAllUser(){
        userRepository.deleteAllUsers()
    }
}