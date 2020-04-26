package com.btf.roomdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.btf.roomdemo.entity.Word
import io.reactivex.Flowable

/**
 * @Author yx.zhang
 * @Date 2020/4/23-10:58
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
@Dao
interface WordDao {

    @Insert
    fun insertWords(vararg word: Word)

    @Update
    fun updateWords(vararg word: Word)

    @Delete
    fun deleteWords(vararg word: Word)

    @Query("DELETE FROM WORD")
    fun deleteAllWords()

    @Query("SELECT * FROM WORD ORDER BY ID ASC")
    //fun getAllWords():List<Word>
    fun getAllWordsLive():LiveData<List<Word>>

    /*@Insert
    fun insertWordx(vararg word:Word): Single<Long>

    @Update
    fun updateWordx(vararg  word: Word):Single<Int>

    @Delete
    fun deleteWordx(vararg word: Word):Single<Int>

    @Query("DELETE FROM WORD")
    fun deleteAllWordx()*/

    @Query("SELECT * FROM WORD ORDER BY ID ASC")
    fun getAllWordxLive(): Flowable<List<Word>>
}