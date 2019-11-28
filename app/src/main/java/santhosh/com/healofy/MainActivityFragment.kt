package santhosh.com.healofy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import santhosh.com.healofy.adapters.HealofyPostAdapter
import santhosh.com.healofy.models.HealofyPostsModel

class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var postAdapter: HealofyPostAdapter = HealofyPostAdapter(activity?.applicationContext, createHealofyPosts(), activity?.supportFragmentManager)
        fragment_main_recyclerView?.adapter = postAdapter
    }

    private fun createHealofyPosts(): ArrayList<HealofyPostsModel> {
        var postList = ArrayList<HealofyPostsModel>()
        for (index in 1..15) {
            postList.add(HealofyPostsModel("User $index", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit."))
        }
        return postList
    }
}
