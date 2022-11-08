package com.example.btgk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;

import com.example.btgk.databinding.ActivityStudentInfoBinding;

public class StudentInfo extends DrawerBaseActivity {
    ActivityStudentInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent !=null){
            String msv = intent.getStringExtra("msv");
            String name = intent.getStringExtra("name");
            String classStudent = intent.getStringExtra("classStudent");
            String imageid = intent.getStringExtra("images");

            byte[] decodedString = Base64.decode(imageid, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);


            binding.msv.setText(msv);
            binding.classStudent.setText(classStudent);
            binding.name.setText(name);
            binding.img.setImageBitmap(decodedByte);
        }
    }
}