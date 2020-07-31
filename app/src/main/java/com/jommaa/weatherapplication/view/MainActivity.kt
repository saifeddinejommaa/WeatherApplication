package com.jommaa.weatherapplication.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.R
import com.jommaa.weatherapplication.WeatherApplication
import com.jommaa.weatherapplication.adapters.TownsListAdapter
import com.jommaa.weatherapplication.databinding.ActivityMainBinding
import com.jommaa.weatherapplication.viewmodel.TownsListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity :  BaseActivity() {

    @Inject
    lateinit var viewModel: TownsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )


        (application as WeatherApplication).component.inject(this)

        binding.viewModel = viewModel
        viewModel.setNavigationHandler(this)



        fab.setOnClickListener { view ->
            startActivity(Intent(this,AddNewTownActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.bound()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        /**
         * bindList uses Databinding to initialize the recyclerView using an ObservableList from the MainViewModel
         * this is referenced in activity_main.xml as 'app:adapter={@viewModel}'
         */
        @JvmStatic
        @BindingAdapter("adapter")
        fun bindList(recyclerView: RecyclerView, viewModel: TownsListViewModel) {
            val adapter = TownsListAdapter(viewModel.townsList)
            adapter.onItemClickListener = { viewModel.onTownClicked(it) }
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = adapter
        }
    }


}
