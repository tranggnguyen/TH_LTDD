package com.example.btgk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btgk.databinding.ActivityMainEditBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity_EDIT extends DrawerBaseActivity {
    ActivityMainEditBinding binding;
    EditText tenkhoahoc,tenthuonggoi,dactinh,mausac,images;
    FirebaseAuth fAuth;
    DatabaseReference database;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent !=null){
            String tenkhoahoc = intent.getStringExtra("tenkhoahoc");
            String tenthuonggoi = intent.getStringExtra("tenthuonggoi");
            String dactinh = intent.getStringExtra("dactinh");
            String mausac = intent.getStringExtra("mausac");
            String images = intent.getStringExtra("images");
            position = intent.getIntExtra("pos",-1);
            binding.tenkhoahoc.setText(tenkhoahoc);
            binding.tenthuonggoi.setText(tenthuonggoi);
            binding.dactinh.setText(dactinh);
            binding.mausac.setText(mausac);
            binding.images.setText(images);

        }


        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        Button editBTN =(Button) binding.editBTN;
        Button removeBTN =(Button) binding.removeBTN;


        editBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenkhoahoc = binding.tenkhoahoc.getText().toString();
                String tenthuonggoi = binding.tenthuonggoi.getText().toString();
                String dactinh = binding.dactinh.getText().toString();
                String mausac = binding.mausac.getText().toString();
                String images = binding.images.getText().toString();

                database.child("Ca").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        database.child("Ca").child(""+position).removeValue();
                        database.child("Ca").child(""+position).child("tenkhoahoc").setValue(tenkhoahoc);
                        database.child("Ca").child(""+position).child("tenthuonggoi").setValue(tenthuonggoi);
                        database.child("Ca").child(""+position).child("dactinh").setValue(dactinh);
                        database.child("Ca").child(""+position).child("mausac").setValue(mausac);
                        database.child("Ca").child(""+position).child("images").setValue(images);


                        Toast.makeText(MainActivity_EDIT.this, "SỬA CÁC LOẠI CÁ THÀNH CÔNG ", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        removeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.child("Ca").child(""+position).removeValue();
                Toast.makeText(MainActivity_EDIT.this, "XÓA THÀNH CÔNG", Toast.LENGTH_SHORT).show();
            }
        });
        fAuth = FirebaseAuth.getInstance();
    }
}