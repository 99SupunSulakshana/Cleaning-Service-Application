package com.example.cleanerservice.adpters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleanerservice.R;
import com.example.cleanerservice.model.Advertisement;

import java.util.ArrayList;

public class AdvertisemntAdapter extends BaseAdapter {
    Context context;
    TextView fullname,email,phone,location,aboutme,pkgname,pkgprice;
    ImageView imageView;

    ArrayList<Advertisement> advertisements;

    public AdvertisemntAdapter(Context context, ArrayList<Advertisement> advertisements){
        this.context = context;
        this.advertisements = advertisements;
    }
    @Override
    public int getCount() {
        return advertisements.size();
    }

    @Override
    public Object getItem(int i) {
        return advertisements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)  {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_add, viewGroup, false);

        fullname = (TextView) v.findViewById(R.id.txtFullNameA);
        email = (TextView) v.findViewById(R.id.txtPhoneA);
        phone = (TextView) v.findViewById(R.id.txtPhoneA);
        location = (TextView) v.findViewById(R.id.txtLocationA);
        aboutme = (TextView) v.findViewById(R.id.txtAboutmeA);
        pkgname = (TextView) v.findViewById(R.id.txtpkgnameA);
        pkgprice = (TextView) v.findViewById(R.id.pkgPriceA);
       imageView = (ImageView) v.findViewById(R.id.addPic);

        Advertisement advertisement = advertisements.get(i);
        fullname.setText(advertisement.getAddName());
        email.setText(advertisement.getAddEmail());
        phone.setText(""+advertisement.getAddContact());
        location.setText(advertisement.getAddLocation());
        aboutme.setText(advertisement.getAddDescription());
        pkgname.setText(advertisement.getAddPackageName());
        pkgprice.setText(advertisement.getAddPackagePrice());
        Bitmap bitmap = BitmapFactory.decodeByteArray(advertisement.getAddFrontImage(),0,advertisement.getAddFrontImage().length);
        imageView.setImageBitmap(bitmap);

        return v;
    }
}
