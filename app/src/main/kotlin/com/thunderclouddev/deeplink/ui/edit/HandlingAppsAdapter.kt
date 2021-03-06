package com.thunderclouddev.deeplink.ui.edit

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.view.ViewGroup
import com.thunderclouddev.deeplink.R
import com.thunderclouddev.deeplink.databinding.EditViewHandlingAppIconItemBinding
import com.thunderclouddev.deeplink.ui.BaseRecyclerViewAdapter
import org.jetbrains.anko.layoutInflater

/**
 * @author David Whitman on 27 Feb, 2017.
 */
class HandlingAppsAdapter(private val context: Context, val items: ObservableArrayList<AppViewModel>) : BaseRecyclerViewAdapter<HandlingAppsAdapter.ViewHolder>() {
    init {
        items.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableArrayList<AppViewModel>>() {
            override fun onItemRangeInserted(sender: ObservableArrayList<AppViewModel>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onChanged(sender: ObservableArrayList<AppViewModel>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(sender: ObservableArrayList<AppViewModel>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }

            override fun onItemRangeMoved(sender: ObservableArrayList<AppViewModel>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                notifyItemMoved(fromPosition, itemCount)
            }

            override fun onItemRangeChanged(sender: ObservableArrayList<AppViewModel>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate<EditViewHandlingAppIconItemBinding>(context.layoutInflater, R.layout.edit_view_handling_app_icon_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount() = items.size

    data class ViewHolder(val binding: EditViewHandlingAppIconItemBinding) : BaseRecyclerViewAdapter.ViewHolder<AppViewModel>(binding) {
        override fun performBind(item: AppViewModel) {
            binding.model = item
        }
    }
}