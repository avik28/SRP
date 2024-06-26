package com.example.srp

import android.os.Bundle
import android.telephony.ims.RegistrationManager.RegistrationCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import fragment2

class MainActivity : AppCompatActivity(){
    lateinit var tabLayout:TabLayout
    lateinit var viewPager2:ViewPager2
    lateinit var adapter:FragmentPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tabLayout)
        viewPager2=findViewById(R.id.viewPager2)
        adapter=FragmentPageAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter
        tabLayout.addOnTabSelectedListener(object:OnTabSelectedListener{
            override fun onTabSelected(p0: TabLayout.Tab?) {
                if(p0!=null)
                    viewPager2.currentItem=p0.position
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

        })
        viewPager2.registerOnPageChangeCallback(object:OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}