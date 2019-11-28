package santhosh.com.healofy.adapters

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import santhosh.com.healofy.R
import santhosh.com.healofy.activities.CommentsActivity
import santhosh.com.healofy.fragments.CommentsFragment
import santhosh.com.healofy.models.HealofyPostsModel

class HealofyPostAdapter(mContext: Context?, healofyPostList: ArrayList<HealofyPostsModel>, supportFragmentManager: FragmentManager?) : RecyclerView.Adapter<HealofyPostAdapter.HealofyPostViewHolder>(), View.OnClickListener {
    companion object {
        private var TAG: String = this.javaClass.simpleName
    }

    var mHealofyPostList = healofyPostList
    var mContext = mContext
    var supportFragmentManager = supportFragmentManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealofyPostViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return HealofyPostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mHealofyPostList.size
    }

    override fun onBindViewHolder(holder: HealofyPostViewHolder, position: Int) {
        var healofyModel = mHealofyPostList.get(position)

        holder.tvPostedBy?.text = healofyModel.name
        holder.tvPostTitle?.text = healofyModel.postTitle

        holder.llComment?.setOnClickListener(this)
        holder.llLike?.setOnClickListener(this)
    }

    class HealofyPostViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tvPostedBy = itemView?.findViewById<TextView>(R.id.post_posted_by)
        var tvPostTitle = itemView?.findViewById<TextView>(R.id.post_title)
        var llLike = itemView?.findViewById<LinearLayout>(R.id.post_like)
        var llComment = itemView?.findViewById<LinearLayout>(R.id.post_comment)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.post_comment -> {
                var bottomSheetDialogFragment: BottomSheetDialogFragment = CommentsFragment()
                bottomSheetDialogFragment.show(supportFragmentManager, bottomSheetDialogFragment.getTag());
            }
            R.id.post_like -> {
                var commentsIntent = Intent(mContext, CommentsActivity::class.java)
                mContext?.startActivity(commentsIntent)
            }
        }
    }
}