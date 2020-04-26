package com.btf.roomdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.btf.roomdemo.entity.Word
import com.btf.roomdemo.repository.WordRepository

/**
 * @Author yx.zhang
 * @Date 2020/4/23-17:56
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class WordViewModel:ViewModel() {
    private val wordRepository: WordRepository = WordRepository()

    val allWordsLive:LiveData<List<Word>>
        get() = wordRepository.allWordsLive

    fun insertWords(vararg words: Word) {
        wordRepository.insertWords(*words)
    }

    fun updateWords(vararg words: Word) {
        wordRepository.updateWords(*words)
    }

    fun deleteWords(vararg words: Word) {
        wordRepository.deleteWords(*words)
    }

    fun deleteAllWords() {
        wordRepository.deleteAllWords()
    }
}