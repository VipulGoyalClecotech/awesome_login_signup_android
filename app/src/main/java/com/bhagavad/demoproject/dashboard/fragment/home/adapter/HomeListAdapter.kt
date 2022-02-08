package com.bhagavad.demoproject.dashboard.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.BR
import com.bhagavad.demoproject.dashboard.fragment.home.HomeListFragmentNavigator
import com.bhagavad.demoproject.dashboard.fragment.home.HomeListFragmentViewModel
import com.bhagavad.demoproject.dashboard.fragment.home.bean.HomeListResponse
import com.bhagavad.demoproject.databinding.ItemHomeListBinding




class HomeListAdapter(context: Context,
                      list:ArrayList<HomeListResponse.Data>,
                      viewModel: HomeListFragmentViewModel,
                      navigator: HomeListFragmentNavigator
                             ) :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    lateinit var mContext: Context
    lateinit var mNavigator: HomeListFragmentNavigator
    lateinit var mViewModel: HomeListFragmentViewModel
    lateinit var mList:ArrayList<HomeListResponse.Data>


    init {
        mNavigator = navigator
        mContext = context
        mViewModel = viewModel
        mList = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataBindingUtil.inflate<ItemHomeListBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_home_list , parent , false);
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
        var binding = DataBindingUtil.bind<ItemHomeListBinding>(itemView)
        fun setViewModel(position: Int, viewModel : HomeListFragmentViewModel)
        {
            binding!!.position = position
            binding!!.viewModel = viewModel
            binding!!.setVariable(BR.viewModel , viewModel)
            binding!!.executePendingBindings()
        }
    }



}