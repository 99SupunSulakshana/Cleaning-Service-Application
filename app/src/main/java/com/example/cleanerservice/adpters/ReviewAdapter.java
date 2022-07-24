package com.example.cleanerservice.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cleanerservice.R;
import com.example.cleanerservice.activity.Review;
import com.example.cleanerservice.model.Reviews;

import java.util.ArrayList;

public class ReviewAdapter extends BaseAdapter {

    Context context;
    TextView id, name, msg, createat;
    ArrayList<Reviews> reviews;

    public ReviewAdapter(Context context, ArrayList<Reviews> reviews){
        this.context = context;
        this.reviews = reviews;
    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Object getItem(int i) {
        return reviews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_review, viewGroup, false);

        id = (TextView) v.findViewById(R.id.txtIdR);
        name = (TextView) v.findViewById(R.id.txtFullNameR);
        msg = (TextView) v.findViewById(R.id.txtmsgR);
        createat = (TextView) v.findViewById(R.id.txtDateR);

        Reviews review = reviews.get(i);
        id.setText(""+review.getId());
        name.setText(review.getName());
        msg.setText(review.getMessage());
        createat.setText(review.getCreateAt());
        return v;
    }
}
