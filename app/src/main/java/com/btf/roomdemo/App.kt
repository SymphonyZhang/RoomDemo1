package com.btf.roomdemo

import android.app.Application

/**
 * @Author yx.zhang
 * @Date 2020/4/23-14:17
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class App : Application() {
    companion object {
        private var INSTANCE: App? = null
        fun instance() = INSTANCE!!
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

    }
}