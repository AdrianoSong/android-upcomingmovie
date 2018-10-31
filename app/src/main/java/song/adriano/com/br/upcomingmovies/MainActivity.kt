package song.adriano.com.br.upcomingmovies

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import song.adriano.com.br.upcomingmovies.adapter.MovieAdapter
import song.adriano.com.br.upcomingmovies.presenter.MainPresenter
import song.adriano.com.br.upcomingmovies.presenter.MainPresenterListener
import song.adriano.com.br.upcomingmovies.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener, MainPresenterListener {

    private var page = 1
    private val mainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainPresenter.fetchMovies(page)
    }

    private fun setupRecyclerview(moviesVMList: MutableList<MovieViewModel>) {

        recyclerViewMovies.layoutManager = LinearLayoutManager(this)
        recyclerViewMovies.adapter = MovieAdapter(moviesVMList)
    }

    private fun setupSearchView(menu: Menu) {
        val searchItem = menu.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        val searchView = searchItem.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.componentName))

        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        setupSearchView(menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.e("main", "text submited $query")
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e("main", "text changed $newText")
        return true
    }

    override fun onFetchMoviesDone(movieViewModelList: MutableList<MovieViewModel>) {

        runOnUiThread {
            setupRecyclerview(movieViewModelList)
        }
    }
}
