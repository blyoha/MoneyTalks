package com.theloungeexperts.moneytalks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theloungeexperts.moneytalks.databinding.FeedCardBinding

class FeedCardAdapter : RecyclerView.Adapter<FeedCardAdapter.FeedCardHolder>() {
    private val feedCards = ArrayList<FeedCard>()

    class FeedCardHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = FeedCardBinding.bind(item)

        fun bind(feedCard: FeedCard) = with(binding) {
            theme.text = feedCard.theme
            author.text = feedCard.author
            time.text = feedCard.time
            title.text = feedCard.title
            content.text = feedCard.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedCardHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.feed_card, parent, false)

        return FeedCardHolder(view)
    }

    override fun onBindViewHolder(holder: FeedCardHolder, position: Int) {
        holder.bind(feedCards[position])
    }

    override fun getItemCount(): Int {
        return feedCards.size
    }

    fun addFeedCard(feedCard: FeedCard) {
        feedCards.add(feedCard)
        notifyDataSetChanged()
    }
}