package santhosh.com.healofy.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import santhosh.com.healofy.R
import santhosh.com.healofy.models.HealofyPostsModel

class HealofyCommentsAdapter(mContext: Context, healofyComments: ArrayList<HealofyPostsModel>) : RecyclerView.Adapter<HealofyCommentsAdapter.HealofyCommentsViewHolder>() {
    var mHealofyComments = healofyComments
    var context = mContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealofyCommentsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.comments_row, parent, false)
        return HealofyCommentsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mHealofyComments.size
    }

    override fun onBindViewHolder(holder: HealofyCommentsViewHolder, position: Int) {
        var comments = mHealofyComments.get(position)

        holder.tvPostedBy?.text = comments.name
        holder.tvComments?.text = comments.postTitle
    }

    class HealofyCommentsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvPostedBy = itemView?.findViewById<TextView>(R.id.comment_row_tv_posted_by)
        var tvComments = itemView?.findViewById<TextView>(R.id.comment_row_tv_comment_text)
    }
}