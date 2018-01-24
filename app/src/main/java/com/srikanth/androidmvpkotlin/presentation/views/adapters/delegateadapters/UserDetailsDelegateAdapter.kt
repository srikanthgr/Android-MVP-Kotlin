package com.srikanth.androidmvpkotlin.presentation.views.adapters.delegateadapters

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewTypeDelegateAdapter
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.UserViewModel
import com.srikanth.androidmvpkotlin.utils.inflate
import com.srikanth.androidmvpkotlin.utils.loadUrl
import kotlinx.android.synthetic.main.list_item_user_details.view.*


class UserDetailsDelegateAdapter: ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = UserDetailsViewHolder(parent.inflate(R.layout.list_item_user_details))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as UserDetailsViewHolder
        holder.bind(item as UserViewModel)
    }

    class UserDetailsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(user: UserViewModel) = with(itemView){
            profileImage.loadUrl(user.profileImage)
            name.text = user.displayName
            reputation.text = "${user.reputation} points"
        }
    }
}