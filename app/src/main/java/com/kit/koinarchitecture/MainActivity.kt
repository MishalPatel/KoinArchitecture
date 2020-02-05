package com.kit.koinarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kit.koinarchitecture.adapters.ListPostAdapter
import com.kit.koinarchitecture.data.model.Posts
import com.kit.koinarchitecture.databinding.ActivityMainBinding
import com.kit.koinarchitecture.utils.SharedPreferenceManager
import com.kit.koinarchitecture.views.ListPostViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    // Koin with Rxjava
  /*  private lateinit var adapter: ListPostAdapter
    private val listPostViewModel: ListPostViewModel by viewModel()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        adapter = ListPostAdapter()
        binding.rvList.adapter = adapter
        listPostViewModel.fetchRepos()
        observeData()

    }

    private fun observeData() {
        listPostViewModel.getRepos().observe(this, Observer<List<Posts>> {
            if (it != null) {
                binding.setVariable(BR.isError, false)
                binding.setVariable(BR.isLoading, false)
                adapter.addPostData(it)
            }
        })


        listPostViewModel.getLoading().observe(this, Observer<Boolean> {
            if (it != null) {
                binding.setVariable(BR.isError, false)
                binding.setVariable(BR.isLoading, true)
            }
        })

        listPostViewModel.getError().observe(this, Observer<Boolean> {
            if (it != null) {
                binding.setVariable(BR.isError, it)
                binding.setVariable(BR.isLoading, false)
            }
        })
    }*/

    // Koin with Coroutines
  private val postViewModel: ListPostViewModel by viewModel()
    lateinit var mBinding: ActivityMainBinding
    lateinit var adapter: ListPostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = ListPostAdapter()
        mBinding.rvList.layoutManager = LinearLayoutManager(this)
        mBinding.rvList.adapter = adapter
        postViewModel.getListPost()
        postViewModel.listPost.observe(this@MainActivity, Observer {
            adapter.addPostData(it)
        })
        postViewModel.loading.observe(this, Observer {
            if (it) {
                mBinding.pbMain.visibility = View.VISIBLE
            } else {
                mBinding.pbMain.visibility = View.GONE
            }
        })

    }

}
