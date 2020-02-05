package com.kit.koinarchitecture.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kit.koinarchitecture.data.model.Posts
import com.kit.koinarchitecture.data.rest.RepoService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListPostViewModel(private val repoService: RepoService) : ViewModel() {
    /*    private var compositeDisposable: CompositeDisposable? = null
        var repos = MutableLiveData<List<Posts>>()
        var repoLoadError = MutableLiveData<Boolean>()
        var loading = MutableLiveData<Boolean>()

        init {
            compositeDisposable = CompositeDisposable()
    //        fetchRepos()
        }

        fun getRepos(): LiveData<List<Posts>> {
            return repos
        }

        fun getLoading(): LiveData<Boolean> {
            return loading
        }

        fun getError(): LiveData<Boolean> {
            return repoLoadError
        }

        fun fetchRepos() {
            loading.value = true
            val repoDisposable = repoService.getRepositories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<List<Posts>>() {
                    override fun onSuccess(t: List<Posts>) {
                        repos.value = t

                        loading.value = false
                        repoLoadError.value = false
                    }

                    override fun onError(e: Throwable) {
                        loading.value = false
                        e.printStackTrace()
                        repoLoadError.value = true
                    }
                })
            compositeDisposable?.add(repoDisposable)
        }

        override fun onCleared() {
            super.onCleared()
            compositeDisposable?.clear()
            compositeDisposable = null
        }*/
    val listPost = MutableLiveData<List<Posts>>()
    val loading = MutableLiveData<Boolean>()
    fun getListPost() {
        loading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = repoService.getRepositories()
            withContext(Dispatchers.Main) {
                loading.value = false
                listPost.value = response
            }
        }
    }

}