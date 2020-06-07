package ru.summary.mysummaryproject.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.view.*
import ru.rambler.libs.swipe_layout.SwipeLayout
import ru.summary.mysummaryproject.R
import ru.summary.mysummaryproject.domain.models.UsersModel

private typealias OnPlusGoodsClickListener = ((Int) -> Unit)
private typealias OnUserClickListener = ((ImageView, Int, UsersModel) -> Unit)


class ProductAdapter :
    ListAdapter<UsersModel, ProductAdapter.ViewHolder>(diffUtil) {

    private val VIEW_TYPE_LOADING = 1
    private val VIEW_TYPE_ITEM = 0

    var swipePrev: SwipeLayout? = null
    private lateinit var swipedParent: ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return if (viewType == VIEW_TYPE_ITEM)
            ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
            ) else
            LoadViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_load_paging,
                    parent,
                    false
                )
            )
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).id != -1) {
            VIEW_TYPE_ITEM
        } else
            VIEW_TYPE_LOADING
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

        when (holder) {
            is ItemViewHolder -> {
                initSwipeListener(holder)
                holder.bind(getItem(pos), pos, userClickListener)
            }
        }
    }

    open class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer

    class ItemViewHolder(override val containerView: View) :
        ViewHolder(containerView), LayoutContainer {

        private val imgUser = containerView.imgUser

        fun bind(item: UsersModel, pos: Int, userClickListener: OnUserClickListener?) {

            Glide.with(imgUser.context)
                .load(item.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_home_false)
                .into(imgUser)

            containerView.setOnClickListener {
                userClickListener?.invoke(imgUser, pos, item)
            }

        }
    }

    class LoadViewHolder(override val containerView: View) : ViewHolder(containerView),
        LayoutContainer


    // Инициализация свайпа карточки товара
    private fun initSwipeListener(holder: ViewHolder) {
        holder.itemView.swipe.setOnSwipeListener(object : SwipeLayout.OnSwipeListener {
            override fun onLeftStickyEdge(swipeLayout: SwipeLayout?, moveToRight: Boolean) {}

            override fun onRightStickyEdge(swipeLayout: SwipeLayout?, moveToRight: Boolean) {

            }

            override fun onBeginSwipe(swipeLayout: SwipeLayout?, moveToRight: Boolean) {
                swipedParent = holder
                if (swipePrev == null) {
                    swipePrev = swipeLayout
                } else {
                    if (swipePrev != swipeLayout) {
                        swipePrev?.animateReset()
                        swipePrev = swipeLayout
                    }
                }
            }

            override fun onSwipeClampReached(swipeLayout: SwipeLayout?, moveToRight: Boolean) {}
        })
    }


    private var plusBasketClickListener: OnPlusGoodsClickListener? = null
    private var userClickListener: OnUserClickListener? = null

    fun setOnProductClickListener(listener: OnUserClickListener?) {
        userClickListener = listener
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<UsersModel>() {
            override fun areItemsTheSame(
                p0: UsersModel, p1: UsersModel
            ): Boolean {
                return p0.id == p1.id
            }

            override fun areContentsTheSame(
                p0: UsersModel, p1: UsersModel
            ): Boolean {
                return p0.login == p1.login
            }
        }
    }

}