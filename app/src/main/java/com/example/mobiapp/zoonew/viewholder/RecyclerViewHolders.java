package com.example.mobiapp.zoonew.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiapp.zoonew.R;

/**
 * Created by mobi app on 27.07.2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name, price, endPrice, time;
    public ImageView imageViewProductRecomended;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imageViewProductRecomended = (ImageView)itemView.findViewById(R.id.imageViewProductRecomended);
        name = (TextView) itemView.findViewById(R.id.textViewNameProductRecomended);
        price = (TextView) itemView.findViewById(R.id.textViewPriceProductRecomended);
        endPrice = (TextView) itemView.findViewById(R.id.textViewEndProductPriceRecomemded);
        time = (TextView) itemView.findViewById(R.id.textViewTimeProductRecomended);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}