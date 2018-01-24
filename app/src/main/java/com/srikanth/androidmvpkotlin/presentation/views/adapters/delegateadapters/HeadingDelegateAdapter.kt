package com.srikanth.androidmvpkotlin.presentation.views.adapters.delegateadapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.Heading
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewTypeDelegateAdapter
import com.srikanth.androidmvpkotlin.utils.inflate
import kotlinx.android.synthetic.main.list_item_heading.view.*


class HeadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as HeadingViewHolder
        holder.bind(item as Heading)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = HeadingViewHolder(parent.inflate(R.layout.list_item_heading))

    class HeadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(heading: Heading) = with(itemView) {
            title.text = heading.title
        }
    }
}