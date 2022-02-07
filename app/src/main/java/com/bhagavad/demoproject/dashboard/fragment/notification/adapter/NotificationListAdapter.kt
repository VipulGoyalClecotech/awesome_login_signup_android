package com.bhagavad.demoproject.dashboard.fragment.notification.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.BR
import com.bhagavad.demoproject.dashboard.fragment.notification.NotificationListFragmentNavigator
import com.bhagavad.demoproject.dashboard.fragment.notification.NotificationListFragmentViewModel
import com.bhagavad.demoproject.dashboard.fragment.notification.bean.NotificationListResponse
import com.bhagavad.demoproject.databinding.ItemNotificationListBinding



class NotificationListAdapter(context: Context,
                              list:ArrayList<NotificationListResponse.Data>,
                              viewModel: NotificationListFragmentViewModel,
                              navigator: NotificationListFragmentNavigator
                             ) :
    RecyclerView.Adapter<NotificationListAdapter.ViewHolder>() {
    lateinit var mContext: Context
    lateinit var mNavigator: NotificationListFragmentNavigator
    lateinit var mViewModel: NotificationListFragmentViewModel
    lateinit var mList:ArrayList<NotificationListResponse.Data>


    init {
        mNavigator = navigator
        mContext = context
        mViewModel = viewModel
        mList = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataBindingUtil.inflate<ItemNotificationListBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_notification_list , parent , false);
        return ViewHolder(view.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = mList.get(position)

        holder.binding!!.tvName.setText(data.name)

        holder.binding!!.tvTopic.setText(data.description)
        holder.binding!!.tvSubject.setText(data.course)


        holder.itemView.setOnClickListener(View.OnClickListener {

        })

        holder.setViewModel(position, mViewModel)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding = DataBindingUtil.bind<ItemNotificationListBinding>(itemView)
        fun setViewModel(position: Int, viewModel : NotificationListFragmentViewModel)
        {
            binding!!.position = position
            binding!!.viewModel = viewModel
            binding!!.setVariable(BR.viewModel , viewModel)
            binding!!.executePendingBindings()
        }
    }



}