package santhosh.com.healofy.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_comments.*
import santhosh.com.healofy.R
import santhosh.com.healofy.adapters.HealofyCommentsAdapter
import santhosh.com.healofy.models.HealofyPostsModel

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        var postAdapter: HealofyCommentsAdapter = HealofyCommentsAdapter(this@CommentsActivity, createHealofyComments())
        activity_comments_recyclerView?.adapter = postAdapter
    }

    private fun createHealofyComments(): ArrayList<HealofyPostsModel> {
        var commentsList = ArrayList<HealofyPostsModel>()
        for (index in 1..15) {
            commentsList.add(HealofyPostsModel("User $index", "Lorem ipsum dolor sit amet."))
        }
        return commentsList
    }
}
