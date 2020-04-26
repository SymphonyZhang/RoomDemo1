package com.btf.roomdemo.repository

import androidx.lifecycle.LiveData
import com.btf.roomdemo.App
import com.btf.roomdemo.dao.WordDao
import com.btf.roomdemo.database.WordDatabase
import com.btf.roomdemo.entity.Word
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @Author yx.zhang
 * @Date 2020/4/23-17:50
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class WordRepository {
    var allWordsLive:LiveData<List<Word>>
    private val wordDao: WordDao

    init {
        val wordDatabase = WordDatabase.getInstance(App.instance())
        wordDao = wordDatabase.getWordDao()
        allWordsLive = wordDao.getAllWordsLive()
    }

    fun insertWords(vararg words: Word) {
        CoroutineScope(Dispatchers.IO).launch {
            wordDao.insertWords(*words)
        }

    }

    fun updateWords(vararg words: Word) {
        CoroutineScope(Dispatchers.IO).launch {
            wordDao.updateWords(*words)
        }

    }

    fun deleteWords(vararg words: Word) {
        CoroutineScope(Dispatchers.IO).launch {
            wordDao.deleteWords(*words)
        }

    }

    fun deleteAllWords() {
        CoroutineScope(Dispatchers.IO).launch {
            wordDao.deleteAllWords()
        }

    }


    fun <T> Single<T>.subscribeDbResult(onSuccess:(data:T) -> Unit,onFailed:(e:Throwable) ->Unit) {
        subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :SingleObserver<T>{
                    override fun onSuccess(t: T) {
                        onSuccess(t)
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                        onFailed(e)
                    }

                })
    }
}