package ru.summary.mysummaryproject.ui.main.home

import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
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

    private val locationUserImageFromRecyclerView = IntArray(2)

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
        initClickListenersAdapterUsers()
    }

    private fun initRecyclerUsers() {
        recyclerUsers.run {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = adapterUsers
        }
    }

    override fun showUsers(user: ArrayList<UsersModel>) {
        adapterUsers.submitList(user)
    }

    private fun initClickListenersAdapterUsers() {
        adapterUsers.setOnUserClickListener { imageView, i, usersModel ->
            animateImageTransitionFromListProduct(imageView)
        }
    }

    private fun initLocationXYSelectedProductImage(productImage: ImageView) {
        productImage.getLocationInWindow(locationUserImageFromRecyclerView)
    }

    private fun animateImageTransitionFromListProduct(productImage: ImageView) {

        initLocationXYSelectedProductImage(productImage)

        imgTransition.setImageBitmap(productImage.drawable.toBitmap())
        imgTransition.visibility = View.VISIBLE

        setPositionImageTransitionToPositionProductImage()
        // animateToEndLocationImageTransition()
    }

    private fun setPositionImageTransitionToPositionProductImage() {
        val offsetLocationYImageTransition =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, resources.displayMetrics)

        val rectangle = Rect()
        val window: Window = activity!!.window
        window.decorView.getWindowVisibleDisplayFrame(rectangle)
        val statusBarHeight: Int = rectangle.top
        val contentViewTop: Int = window.findViewById<View>(Window.ID_ANDROID_CONTENT).getTop()
        val titleBarHeight = contentViewTop - statusBarHeight

        imgTransition.x = locationUserImageFromRecyclerView[0].toFloat()
        imgTransition.y = locationUserImageFromRecyclerView[1].toFloat() + titleBarHeight
    }


    override fun showError(message: String) {
        toast(message)
    }

}