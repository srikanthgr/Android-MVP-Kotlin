package com.srikanth.androidmvpkotlin.presentation.views.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.di.modules.DetailsFragmentModule
import com.srikanth.androidmvpkotlin.presentation.views.DetailView
import com.srikanth.androidmvpkotlin.presentation.views.adapters.DetailsAdapter
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.DetailsViewModel
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.UserViewModel
import com.srikanth.androidmvpkotlin.utils.app
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment(), DetailView {

    private val component by lazy { app.component.plus(DetailsFragmentModule()) }

    private val presenter by lazy { component.presenter() }

    private val detailsAdapter by lazy {
        DetailsAdapter({ link ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
        })

    }

    val transitionEnded = false

    companion object {

        fun newInstance(user: UserViewModel): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putParcelable("user", user)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        initAdapter()
        processArguments()
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    private fun processArguments() {
        val user = arguments.getParcelable<UserViewModel>("user")
        detailsAdapter.addItem(user)
        detailsAdapter.notifyDataSetChanged()
        presenter.getDetails(user.userId)

        swipeRefreshLayout.setOnRefreshListener {
            presenter.getDetails(user.userId, true)
        }
    }

    private fun initAdapter() {
        detailsRecyclerView.layoutManager = LinearLayoutManager(app)
        detailsRecyclerView.adapter = detailsAdapter
    }


    override fun showDetails(details: DetailsViewModel) {
        with(detailsAdapter) {
            removeNonUserItems()
            addItemsWithHeading(details.questions, "Top Questions by user")
            addItemsWithHeading(details.answers, "Top answers by user")
            addItemsWithHeading(details.favorites, "Top favorited bu user ")
            if (transitionEnded) {
                notifyDataSetChanged()
            }
        }
    }

    override fun showError(error: String) {
        Toast.makeText(app, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        //detailsAdapter.addLoadingItem()
    }

    override fun hideLoading() {
       //detailsAdapter.removeLoadingItem()
        //swipeRefreshLayout.isRefreshing = false
    }
}