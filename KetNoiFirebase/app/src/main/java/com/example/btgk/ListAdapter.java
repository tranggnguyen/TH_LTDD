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
import android.widget.Toast;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Student> {
    Context cM;
    public ListAdapter( Context context, ArrayList<Student> foodArrayList) {
        super(context, R.layout.layoutitem,foodArrayList);
        cM = context;
    }


    @NonNull
    @Override
    public android.view.View getView(int position, @Nullable android.view.View convertView, @NonNull ViewGroup parent) {
        Student fd = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layoutitem, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image1);
        TextView msv = convertView.findViewById(R.id.msv);
        TextView name = convertView.findViewById(R.id.name);
        TextView classStudent = convertView.findViewById(R.id.classStudent);



        byte[] decodedString = Base64.decode(fd.imageId, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);

        imageView.setImageBitmap(decodedByte);
        msv.setText(fd.msv);
        name.setText(fd.name);
        classStudent.setText(fd.classStudent);


//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(cM,
//                        "Bạn đã thêm "+ title.getText() +" vào giỏ hàng "  ,Toast.LENGTH_SHORT).show();
//            }
//        });
//        remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(cM,
//                        "Bạn đã xóa "+ title.getText() +" trong giỏ hàng "  ,Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }
}
