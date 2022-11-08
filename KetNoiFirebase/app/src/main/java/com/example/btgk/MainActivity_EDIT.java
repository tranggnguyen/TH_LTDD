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
    EditText title,Class,content,images;
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
            String msv = intent.getStringExtra("msv");
            String name = intent.getStringExtra("name");
            String classStudent = intent.getStringExtra("classStudent");
            String images = intent.getStringExtra("images");
            position = intent.getIntExtra("pos",-1);
            binding.msvEDIT.setText(msv);
            binding.nameEDIT.setText(name);
            binding.classStudentEDIT.setText(classStudent);
            binding.imagesEDIT.setText(images);
        }


        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        Button editBTN =(Button) binding.editBTN;
        Button removeBTN =(Button) binding.removeBTN;


        editBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msv = binding.msvEDIT.getText().toString();
                String classStudent = binding.classStudentEDIT.getText().toString();
                String name = binding.nameEDIT.getText().toString();
                String imagesText = binding.imagesEDIT.getText().toString();

                database.child("SinhVien").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        database.child("SinhVien").child(""+position).removeValue();
                        database.child("SinhVien").child(""+position).child("msv").setValue(msv);
                        database.child("SinhVien").child(""+position).child("name").setValue(name);
                        database.child("SinhVien").child(""+position).child("classStudent").setValue(classStudent);
                        database.child("SinhVien").child(""+position).child("images").setValue(imagesText);

                        Toast.makeText(MainActivity_EDIT.this, "SỬA SINH VIÊN THÀNH CÔNG ", Toast.LENGTH_SHORT).show();

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

                database.child("SinhVien").child(""+position).removeValue();
                Toast.makeText(MainActivity_EDIT.this, "XÓA THÀNH CÔNG", Toast.LENGTH_SHORT).show();
            }
        });
        fAuth = FirebaseAuth.getInstance();
    }
}