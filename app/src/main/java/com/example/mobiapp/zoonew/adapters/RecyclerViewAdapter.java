package com.example.mobiapp.zoonew.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobiapp.zoonew.MainActivity;
import com.example.mobiapp.zoonew.R;
import com.example.mobiapp.zoonew.classes.Product;
import com.example.mobiapp.zoonew.classes.RecomendedProduct;
import com.example.mobiapp.zoonew.classes.RecomendedProductHour;
import com.example.mobiapp.zoonew.viewholder.RecyclerViewHolders;

import java.util.List;

/**
 * Created by mobi app on 27.07.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<RecomendedProductHour> itemList;
    private MainActivity context;

    public RecyclerViewAdapter(MainActivity context, List<RecomendedProductHour> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_shop, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolders holder, int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.price.setText(itemList.get(position).getPrice());
        holder.endPrice.setText(itemList.get(position).getEndPrice());

        long time = Long.parseLong(itemList.get(0).getTime());

        final long startTime = System.currentTimeMillis() + time;

        final Handler timerHandler = new Handler();
        Runnable timerRunnable = new Runnable() {

            @Override
            public void run() {
                //long millis = System.currentTimeMillis() - startTime;
                long millis = startTime - System.currentTimeMillis();
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;

                holder.time.setText(String.format("%d:%02d", minutes, seconds));

                timerHandler.postDelayed(this, 500);
            }
        };
        if(!itemList.get(position).isTine()) {
            if(holder.time.getText().toString().contains("0123"))timerHandler.postDelayed(timerRunnable, 0);
            itemList.get(position).setTine(true);
        }

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
