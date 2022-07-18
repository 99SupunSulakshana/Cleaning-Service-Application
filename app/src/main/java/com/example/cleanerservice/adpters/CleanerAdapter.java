package com.example.cleanerservice.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cleanerservice.R;
import com.example.cleanerservice.model.Constructor;

import java.util.ArrayList;

public class CleanerAdapter extends BaseAdapter {

    Context context;
    TextView id, name, email, phone, location, aboutme;
    ArrayList<Constructor> constructors;

    public CleanerAdapter(Context context, ArrayList<Constructor> constructors){
        this.context = context;
        this.constructors = constructors;
    }

    @Override
    public int getCount() {
        return constructors.size();
    }

    @Override
    public Object getItem(int i) {
        return constructors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_cleaner, viewGroup, false);

        id = (TextView) v.findViewById(R.id.txtCID);
        name = (TextView) v.findViewById(R.id.txtFullNameC);
        email = (TextView) v.findViewById(R.id.txtEmailC);
        phone = (TextView) v.findViewById(R.id.txtPhoneC);
        location = (TextView) v.findViewById(R.id.txtLocationC);
        aboutme = (TextView) v.findViewById(R.id.txtAboutmeC);


        Constructor constructor = constructors.get(i);
        id.setText(""+constructor.getId());
        name.setText(constructor.getFullName());
        email.setText(constructor.getEmail());
        phone.setText(""+constructor.getPhone());
        location.setText(constructor.getAddress());
        aboutme.setText(constructor.getAboutMe());
        return v;
    }
}
