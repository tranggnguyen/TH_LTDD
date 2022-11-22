package com.example.btgk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Ca> {
    Context cM;
    public ListAdapter( Context context, ArrayList<Ca> foodArrayList) {
        super(context, R.layout.layoutitem,foodArrayList);
        cM = context;
    }


    @NonNull
    @Override
    public android.view.View getView(int position, @Nullable android.view.View convertView, @NonNull ViewGroup parent) {
        Ca fd = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layoutitem, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image1);
        TextView tenkhoahoc = convertView.findViewById(R.id.tenkhoahoc);
        TextView tenthuonggoi = convertView.findViewById(R.id.tenthuonggoi);
//        TextView dactinh = convertView.findViewById(R.id.dactinh);
        TextView mausac = convertView.findViewById(R.id.mausac);

//        TextView add = convertView.findViewById(R.id.add);
//        TextView remove = convertView.findViewById(R.id.remove);

        byte[] decodedString = Base64.decode(fd.imageId, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);

        imageView.setImageBitmap(decodedByte);
        tenkhoahoc.setText(fd.tenkhoahoc);
        tenthuonggoi.setText(fd.tenthuonggoi);
        mausac.setText(fd.mausac);
//        add.setText(fd.add);
//        add.setText(fd.remove);
//
//
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(cM,
//                        "Bạn đã thêm "+ tenkhoahoc.getText() +" vào giỏ hàng "  ,Toast.LENGTH_SHORT).show();
//            }
//        });
//        remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(cM,
//                        "Bạn đã xóa "+ tenkhoahoc.getText() +" trong giỏ hàng "  ,Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }
}
