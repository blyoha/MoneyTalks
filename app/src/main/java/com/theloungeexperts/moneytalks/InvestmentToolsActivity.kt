package com.theloungeexperts.moneytalks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class InvestmentToolsActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment_tools)

        fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)
        viewPager2 = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.sections)

        viewPager2.adapter = fragmentAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Stocks"
                }
                1 -> {
                    tab.text = "Currencies"
                }
                2 -> {
                    tab.text = "ETFs"
                }
            }
        }.attach()
    }

}