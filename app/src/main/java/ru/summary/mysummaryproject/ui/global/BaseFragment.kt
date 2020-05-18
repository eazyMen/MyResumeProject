package ru.summary.mysummaryproject.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import moxy.MvpAppCompatFragment
import ru.summary.mysummaryproject.R

abstract class BaseFragment : MvpAppCompatFragment(), ActionBarView {

    @JvmField
    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null

    abstract var layoutId: Int

    protected abstract fun initializeDagger()

    private var unbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeDagger()
        super.onCreate(savedInstanceState)
        unbinder = ButterKnife.bind(activity!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun setTitle(title: String) {
        val titleTextView = activity?.findViewById<TextView>(R.id.txt_toolbar_title)
        if (title.isNotEmpty()) {
            titleTextView?.text = title
        }
    }

    override fun onStop() {
        unbinder?.unbind()
        super.onStop()
    }

}