package song.adriano.com.br.upcomingmovies.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

class InfiniteScrollListener (
        private val completion: () -> Unit,
        private val linearLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        //similar to if let in swift
        val itemCount = recyclerView?.adapter?.itemCount ?: 0

        if (linearLayoutManager.findLastVisibleItemPosition() == (itemCount - 1)) {
            completion
        }
    }
}
