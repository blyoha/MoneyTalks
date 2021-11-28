package com.theloungeexperts.moneytalks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.theloungeexperts.moneytalks.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private val feedCardAdapter = FeedCardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        val navigationController = findNavController(R.id.feed)

//        bottomNavigationView.setupWithNavController(navigationController)

        initFeed()
    }

    private fun initFeed() {
        binding.apply {
            feedCards.layoutManager = LinearLayoutManager(this@FeedActivity)
            feedCards.adapter = feedCardAdapter

            val feedCard1 = FeedCard(
                "Markets",
                "Red Investor",
                "10 minutes",
                "U.K. Looks to Compete on Financial Regulation",
                "London wants to regain the mantle of the world’s busiest " +
                        "financial center from New York by overhauling how banks and " +
                        "other financial firms are regulated after Brexit."
            )

            val feedCard2 = FeedCard(
                "Credit markets",
                "Blue Investor",
                "1 hour",
                "Covid-19 Variant Upends Investor Bets on Rate Increases",
                "Investors piled into government bonds and quickly recalibrated " +
                        "their expectations for interest-rate increases in response to the " +
                        "new Covid-19 variant first identified in South Africa."
            )

            val feedCard3 = FeedCard(
                "World",
                "Green Investor",
                "44 minutes",
                "Turkey’s Central Bank Says Financial System Is Strong Despite Lira Crisis",
                "ISTANBUL—Turkey’s central bank said Friday the country’s " +
                        "banking sector remained strong and had enough liquid assets to " +
                        "withstand the currency crisis, taking some pressure off President " +
                        "Recep Tayyip Erdogan to change course on his economic policies."
            )

            feedCardAdapter.addFeedCard(feedCard1)
            feedCardAdapter.addFeedCard(feedCard2)
            feedCardAdapter.addFeedCard(feedCard3)
        }
    }
}