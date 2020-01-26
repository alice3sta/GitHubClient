package com.example.mygithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class UserAdapter(val users: List<UserInfo>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)
        holder.userLogin.setText(user.userLogin)
        holder.userId.setText(user.userId.toString())
        Picasso.get().load(user.userAvatar).into(holder.userAvatar)
    }

    class ViewHolder(val recyclerItemView: View) : RecyclerView.ViewHolder(recyclerItemView) {
        val userAvatar = recyclerItemView.findViewById<ImageView>(R.id.user_avatar)
        val userLogin = recyclerItemView.findViewById<EditText>(R.id.user_login)
        val userId = recyclerItemView.findViewById<EditText>(R.id.user_id)
    }
}

