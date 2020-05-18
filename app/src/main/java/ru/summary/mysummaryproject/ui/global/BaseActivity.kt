package ru.summary.mysummaryproject.ui.global

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import ru.summary.mysummaryproject.R

abstract class BaseActivity : AppCompatActivity() {

    @JvmField
    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null

    abstract val layoutId: Int
    protected abstract fun initializeDagger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeDagger()
        initializeToolbar()
    }


    private fun initializeToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = ""
        }
    }

    fun setTitle(titleKey: String) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            val title = findViewById<TextView>(R.id.txt_toolbar_title)
            title?.text = titleKey
        }
    }
}