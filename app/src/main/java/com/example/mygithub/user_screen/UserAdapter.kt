package com.example.mygithub.user_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mygithub.R
import com.example.mygithub.objects.UserInfo
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class UserAdapter(private val users: List<UserInfo>, private val onClickListener: OnItemClicked) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface OnItemClicked {
        fun onItemClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.recyclerItemView.context
        val user = users.get(position)
        holder.userLogin.text = user.userLogin
        holder.userId.text = context.getString(R.string.user_id_text, user.userId)
        Picasso.get().load(user.userAvatar).transform(CropCircleTransformation()).into(holder.userAvatar)

        holder.recyclerItemView.setOnClickListener {
            onClickListener.onItemClicked(position)
        }
    }

    class ViewHolder(val recyclerItemView: View) : RecyclerView.ViewHolder(recyclerItemView) {
        val userAvatar = recyclerItemView.findViewById<ImageView>(R.id.user_avatar)
        val userLogin = recyclerItemView.findViewById<TextView>(R.id.user_login)
        val userId = recyclerItemView.findViewById<TextView>(R.id.user_id)
    }
}

