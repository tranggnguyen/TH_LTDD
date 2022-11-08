package com.example.btgk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btgk.databinding.ActivityMainActivatyCurdBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivaty_CURD extends DrawerBaseActivity {
    EditText msvET,nameET,classStudentET,imagesET;
    FirebaseAuth fAuth;
    DatabaseReference database;
    ActivityMainActivatyCurdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainActivatyCurdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        msvET = binding.msv;
        nameET =binding.name;
        classStudentET =binding.classStudent;
        imagesET = binding.images;

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        Button addBTN =(Button) binding.addBTN;
        fAuth = FirebaseAuth.getInstance();



        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msv = msvET.getText().toString();
                String name = nameET.getText().toString();
                String classStudent = classStudentET.getText().toString();
                String imagesText = imagesET.getText().toString();

                if(msv.isEmpty() || name.isEmpty() || classStudent.isEmpty() || imagesText.isEmpty() ){
                    Toast.makeText(MainActivaty_CURD.this, "LÀM ƠN NHẬP ALL DỮ LIỆU", Toast.LENGTH_SHORT).show();
                }
                else{
                    database.child("SinhVien").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int i = 1;
                            boolean checkTitle = false;
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                if (dataSnapshot.child("msv").getValue(String.class).equals(msv)){
                                    Toast.makeText(MainActivaty_CURD.this, "ĐÃ CÓ MSV " + msv, Toast.LENGTH_SHORT).show();
                                    checkTitle = true;
                                }
                                i = Integer.parseInt(dataSnapshot.getKey());
                            }
                            if(!checkTitle){
                                i+=1;
                                database.child("SinhVien").child(""+i).child("msv").setValue(msv);
                                database.child("SinhVien").child(""+i).child("name").setValue(name);
                                database.child("SinhVien").child(""+i).child("classStudent").setValue(classStudent);
                                database.child("SinhVien").child(""+i).child("images").setValue(imagesText);

                                Toast.makeText(MainActivaty_CURD.this, "THÊM SINH VIÊN THÀNH CÔNG ", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }

        });

    }
}