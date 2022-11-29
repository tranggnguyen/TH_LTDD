package com.example.btgk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Ngonngu> {
    Context cM;
    public ListAdapter( Context context, ArrayList<Ngonngu> foodArrayList) {
        super(context, R.layout.layoutitem,foodArrayList);
        cM = context;
    }


    @NonNull
    @Override
    public android.view.View getView(int position, @Nullable android.view.View convertView, @NonNull ViewGroup parent) {
        Ngonngu fd = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layoutitem, parent, false);
        }

        TextView tenngonngu = convertView.findViewById(R.id.tenngonngu);
        ImageView icon = convertView.findViewById(R.id.icon);


        tenngonngu.setText(fd.tenngonngu);
        icon.setImageResource(fd.icon);
//        TextView add = convertView.findViewById(R.id.add);
//        TextView remove = convertView.findViewById(R.id.remove);

      //  byte[] decodedString = Base64.decode(fd.imageId, Base64.DEFAULT);
       // Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);

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
