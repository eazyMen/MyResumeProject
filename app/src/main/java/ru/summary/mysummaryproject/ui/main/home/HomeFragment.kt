package ru.summary.mysummaryproject.ui.main.home

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.jetbrains.anko.support.v4.toast
import ru.summary.mysummaryproject.App
import ru.summary.mysummaryproject.R
import ru.summary.mysummaryproject.domain.models.UsersModel
import ru.summary.mysummaryproject.presentation.presenters.HomePresenter
import ru.summary.mysummaryproject.ui.adapters.ProductAdapter
import ru.summary.mysummaryproject.ui.global.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeView {
    override var layoutId: Int = R.layout.fragment_home

    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private val adapterUsers by lazyOf(ProductAdapter())

    override fun initializeDagger() {
        App.appComponent.provideHomeComponent().build().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(getString(R.string.title_home))
        initRecyclerUsers()
    }

    private fun initRecyclerUsers() {
        recyclerUsers.run {
            this.adapter = adapterUsers
        }
    }

    override fun showUsers(user: ArrayList<UsersModel>) {
        adapterUsers.submitList(user)
    }

    override fun showError(message: String) {
        toast("message")
    }

}