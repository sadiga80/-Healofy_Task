package santhosh.com.healofy.fragments

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_comments.*
import santhosh.com.healofy.R
import santhosh.com.healofy.adapters.HealofyCommentsAdapter
import santhosh.com.healofy.models.HealofyPostsModel


class CommentsFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.activity_comments, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var postAdapter: HealofyCommentsAdapter = HealofyCommentsAdapter(activity?.applicationContext as Context, createHealofyComments())
        activity_comments_recyclerView?.adapter = postAdapter
    }

    private fun createHealofyComments(): ArrayList<HealofyPostsModel> {
        var commentsList = ArrayList<HealofyPostsModel>()
        for (index in 1..15) {
            commentsList.add(HealofyPostsModel("User $index", "Comment $index"))
        }
        return commentsList
    }
}