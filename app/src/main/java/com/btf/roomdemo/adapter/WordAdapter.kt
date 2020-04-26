package com.btf.roomdemo.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.btf.roomdemo.R
import com.btf.roomdemo.entity.Word
import com.btf.roomdemo.viewmodel.WordViewModel

/**
 * @Author yx.zhang
 * @Date 2020/4/26-10:46
 * @Email yx.zhang@byteflyer.com
 * @Description
 */
class WordAdapter(useCardView:Boolean,wordViewModel:WordViewModel) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    var wordViewModel = wordViewModel
    var allWords: List<Word> = arrayListOf()
    var useCardView = useCardView
    fun updateList(mAllWords:List<Word>){
        this.allWords = mAllWords
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context).inflate(if(useCardView) R.layout.cell_card2 else R.layout.cell_normal2, parent, false))
    }

    override fun getItemCount(): Int = if (allWords.isEmpty()) 0 else allWords.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = allWords[position]
        with(holder){
            tvNum.text = (position+1).toString()
            tvEn.text = word.word
            tvCn.text = word.chineseMeaning
            sCnInvisible.setOnCheckedChangeListener(null)
            if(word.chineseInvisible){
                tvCn.visibility = View.GONE
                sCnInvisible.isChecked = true
            }else{
                tvCn.visibility = View.VISIBLE
                sCnInvisible.isChecked = false
            }
            itemView.setOnClickListener{
                val uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=${tvEn.text}")
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                itemView.context.startActivity(intent)

            }

            sCnInvisible.setOnCheckedChangeListener{ buttonView, isChecked ->
                if(isChecked){
                    tvCn.visibility = View.GONE
                    word.chineseInvisible = true
                    wordViewModel.updateWords(word)
                }else{
                    tvCn.visibility = View.VISIBLE
                    word.chineseInvisible = false
                    wordViewModel.updateWords(word)
                }
            }
        }
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNum: TextView = itemView.findViewById(R.id.tv_num)
        val tvEn: TextView = itemView.findViewById(R.id.tv_en)
        val tvCn: TextView = itemView.findViewById(R.id.tv_cn)
        val sCnInvisible:Switch = itemView.findViewById(R.id.s_cn_invisible)

    }
}