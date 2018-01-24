package com.srikanth.androidmvpkotlin.presentation.views.adapters.delegateadapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.AnswerViewModel
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewTypeDelegateAdapter
import com.srikanth.androidmvpkotlin.utils.inflate
import kotlinx.android.synthetic.main.list_item_answer.view.*


class AnswerDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = AnswerViewHolder(parent.inflate(R.layout.list_item_answer))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as AnswerViewHolder
        holder.bind(item as AnswerViewModel, listener)
    }

    class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(answer: AnswerViewModel, listener: (String) -> Unit) = with(itemView) {
            score.text = "${answer.score} points"
            questionTitle.text = answer.questionTitle
            setOnClickListener() { listener("https://stackoverflow.com/a/${answer.answerId}") }
        }
    }
}