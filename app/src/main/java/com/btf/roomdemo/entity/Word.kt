package com.btf.roomdemo.entity

import android.text.BoringLayout
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author yx.zhang
 * @Date 2020/4/23-10:54
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Entity(tableName = "WORD")
data class Word (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,

    @ColumnInfo(name = "english_word")
    var word:String = "",

    @ColumnInfo(name = "chinese_meaning")
    var chineseMeaning:String = "",
    @ColumnInfo(name = "chinese_invisible")
    var chineseInvisible:Boolean = false
)