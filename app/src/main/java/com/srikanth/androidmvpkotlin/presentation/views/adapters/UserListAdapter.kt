package com.srikanth.androidmvpkotlin.presentation.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.UserViewModel
import com.srikanth.androidmvpkotlin.utils.inflate
import com.srikanth.androidmvpkotlin.utils.loadUrl
import kotlinx.android.synthetic.main.list_item_user.view.*


class UserListAdapter(private val users: MutableList<UserViewModel>,
                      private val listener: (UserViewModel, View) -> Unit) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(users[position], listener)

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent.inflate(R.layout.list_item_user))

    fun addUsers(newUsers: List<UserViewModel>) {
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    fun clearUsers() {
        users.clear()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: UserViewModel, listener: (UserViewModel, View) -> Unit) = with(itemView) {
            name.text = user.displayName
            reputation.text = "${user.reputation} points"
            userAvatar.loadUrl(user.profileImage)
            setOnClickListener { listener(user, userAvatar) }
        }
    }
}