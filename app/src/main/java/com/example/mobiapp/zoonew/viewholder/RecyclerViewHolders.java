package com.example.mobiapp.zoonew.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiapp.zoonew.MainActivity;
import com.example.mobiapp.zoonew.R;

/**
 * Created by mobi app on 27.07.2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name, price, endPrice, time;
    public ImageView imageViewProductRecomended;
    MainActivity activity;

    public RecyclerViewHolders(View itemView, MainActivity activity) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.activity = activity;
        imageViewProductRecomended = (ImageView)itemView.findViewById(R.id.imageViewProductRecomended);
        name = (TextView) itemView.findViewById(R.id.textViewNameProductRecomended);
        price = (TextView) itemView.findViewById(R.id.textViewPriceProductRecomended);
        endPrice = (TextView) itemView.findViewById(R.id.textViewEndProductPriceRecomemded);
        time = (TextView) itemView.findViewById(R.id.textViewTimeProductRecomended);

    }

    @Override
    public void onClick(View view) {
        activity.startInfoProduct(getPosition());

    }
}