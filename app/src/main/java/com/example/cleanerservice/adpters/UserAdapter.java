package com.example.cleanerservice.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cleanerservice.R;
import com.example.cleanerservice.model.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    Context context;
    TextView id,fullname,email,phone,location;
    ArrayList<User> users;

    public UserAdapter(Context context,ArrayList<User> users){
        this.context = context;
        this.users = users;

    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_layout, viewGroup, false);

        id = (TextView) v.findViewById(R.id.txtId);
        fullname = (TextView) v.findViewById(R.id.txtFullName);
        email = (TextView) v.findViewById(R.id.txtEmail);
        phone = (TextView) v.findViewById(R.id.txtPhone);
        location = (TextView) v.findViewById(R.id.txtLocation);

        User user = users.get(i);
        id.setText(""+user.getId());
        fullname.setText(user.getFullName());
        email.setText(user.getEmail());
        phone.setText(""+user.getPhoneNumber());
        location.setText(user.getAddress());
        return v;
    }
}
