package com.jommaa.weatherapplication.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.jommaa.weatherapplication.R
import com.jommaa.weatherapplication.WeatherApplication
import com.jommaa.weatherapplication.adapters.ScreenSlidePagerAdapter
import com.jommaa.weatherapplication.databinding.ActivityMainBinding
import com.jommaa.weatherapplication.databinding.CustomActionBarBinding
import com.jommaa.weatherapplication.view.custom.WeatherActionBar
import com.jommaa.weatherapplication.viewmodel.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MainActivity :  BaseActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

      private lateinit var mPager: ViewPager

      val disposables = CompositeDisposable()


      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView( R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
          (application as WeatherApplication).component.inject(this)
          binding.fragmentManager = supportFragmentManager
          binding.viewModel = viewModel
          setUpCustomActionBar()
          viewModel.setNavigationHandler(this)



       // fab.setOnClickListener { view ->
       //     startActivity(Intent(this,AddNewTownActivity::class.java))
       // }

    }



    override fun onBackPressed() {
        if (mPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            mPager.currentItem = mPager.currentItem - 1
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.bound()


    }

    companion object {
        @JvmStatic
        @BindingAdapter("fm","adapter")
        fun setAdapter(pager: ViewPager, fragmentManager:FragmentManager, viewModel: MainViewModel) {
            if(fragmentManager!=null) {
                val adapter = ScreenSlidePagerAdapter(viewModel.townsList,fragmentManager)
                pager.adapter = adapter
                pager.addOnPageChangeListener(viewModel.onPageChangeListener)
            }

        }
    }

    private fun setUpCustomActionBar(){
       val mCustomView = WeatherActionBar(this)
        val layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT
        )
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(mCustomView,layoutParams)
        supportActionBar?.setElevation(0.toFloat())
        val parent = mCustomView.getParent() as androidx.appcompat.widget.Toolbar
        parent.setContentInsetsAbsolute(0, 0)
        mCustomView.setDataBinding(viewModel)
    }

    private fun setUpCustomActionBar(){
       val mCustomView = WeatherActionBar(this)
        val layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT
        )
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(mCustomView,layoutParams)
        supportActionBar?.setElevation(0.toFloat())
        val parent = mCustomView.getParent() as androidx.appcompat.widget.Toolbar
        parent.setContentInsetsAbsolute(0, 0)
        mCustomView.setDataBinding(viewModel)

     //   val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
       // val binding: CustomActionBarBinding = CustomActionBarBinding.inflate(inflater)
      //  val binding: CustomActionBarBinding?= DataBindingUtil.bind<CustomActionBarBinding>(parent)
       // binding?.let {
        //    it.mainViewModel = viewModel
       // }
       // viewModel.setNavigationHandler(this)
    }

   /*
    companion object {
        @JvmStatic
        @BindingAdapter("fm","adapter")
        fun setAdapter(pager: ViewPager, fragmentManager:FragmentManager, viewModel: MainViewModel) {
            if(fragmentManager!=null) {
                val adapter = ScreenSlidePagerAdapter(viewModel.townsList,fragmentManager)
                pager.adapter = adapter
                pager.addOnPageChangeListener(viewModel.onPageChangeListener)
            }

        }
    }
    */





}
