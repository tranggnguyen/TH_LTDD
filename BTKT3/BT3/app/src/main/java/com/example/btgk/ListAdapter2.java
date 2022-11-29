package com.example.btgk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter2 extends ArrayAdapter<History> {
    Context cM;
    public ListAdapter2( Context context, ArrayList<History> foodArrayList) {
        super(context, R.layout.activity_view_history,foodArrayList);
        cM = context;
    }

    TextView b;
    @NonNull
    @Override
    public android.view.View getView(int position, @Nullable android.view.View convertView, @NonNull ViewGroup parent) {
        History hst = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_view_history, parent, false);
        }

        TextView content = convertView.findViewById(R.id.idcontent) ;

        ImageView imageView = convertView.findViewById(R.id.images);


        content.setText(hst.content);
        imageView.setImageResource(hst.id);


        return convertView;
    }
}
