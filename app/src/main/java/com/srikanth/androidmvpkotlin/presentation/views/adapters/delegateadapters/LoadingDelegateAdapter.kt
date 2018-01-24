package com.srikanth.androidmvpkotlin.presentation.views.adapters.delegateadapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewTypeDelegateAdapter
import com.srikanth.androidmvpkotlin.utils.inflate


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = LoadingViewHolder(parent.inflate(R.layout.list_item_loading))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}