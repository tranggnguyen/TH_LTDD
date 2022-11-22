package com.example.btgk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;

import com.example.btgk.databinding.ActivityCaInfoBinding;

public class CaInfo extends DrawerBaseActivity {
    ActivityCaInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCaInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent !=null){
            String tenkhoahoc = intent.getStringExtra("tenkhoahoc");
            String tenthuonggoi = intent.getStringExtra("tenthuonggoi");
            String dactinh = intent.getStringExtra("dactinh");
            String mausac = intent.getStringExtra("mausac");
            String imageid = intent.getStringExtra("images");

            byte[] decodedString = Base64.decode(imageid, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);

            Bitmap bmpimg = Bitmap.createScaledBitmap(decodedByte, 250, 250, true);

            binding.tenkhoahoc.setText(tenkhoahoc);
            binding.tenthuonggoi.setText(tenthuonggoi);
            binding.dactinh.setText(dactinh);
            binding.mausac.setText(mausac);
            binding.img.setImageBitmap(bmpimg);
        }
    }
}