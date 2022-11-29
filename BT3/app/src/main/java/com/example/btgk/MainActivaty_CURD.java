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
    FirebaseAuth fAuth;
    DatabaseReference database;
    ActivityMainActivatyCurdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainActivatyCurdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        Button addBTN =(Button) binding.addBTN;
        fAuth = FirebaseAuth.getInstance();



        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenkhoahoc = binding.tenkhoahoc.getText().toString();
                String tenthuonggoi = binding.tenthuonggoi.getText().toString();
                String dactinh = binding.dactinh.getText().toString();
                String mausac = binding.mausac.getText().toString();
                String images = binding.images.getText().toString();

                if(tenkhoahoc.isEmpty() || tenthuonggoi.isEmpty() || dactinh.isEmpty() || mausac.isEmpty() || images.isEmpty()){
                    Toast.makeText(MainActivaty_CURD.this, "LÀM ƠN NHẬP ALL DỮ LIỆU", Toast.LENGTH_SHORT).show();
                }
                else{
                    database.child("Cay").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int i = 1;
                            boolean checkTitle = false;
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                if (dataSnapshot.child("tenkhoahoc").getValue(String.class).equals(tenkhoahoc)){
                                    Toast.makeText(MainActivaty_CURD.this, "ĐÃ CÓ CÂY " + tenkhoahoc, Toast.LENGTH_SHORT).show();
                                    checkTitle = true;
                                }
                                i = Integer.parseInt(dataSnapshot.getKey());
                            }
                            if(!checkTitle){
                                i+=1;
                                database.child("Cay").child(""+i).child("tenkhoahoc").setValue(tenkhoahoc);
                                database.child("Cay").child(""+i).child("tenthuonggoi").setValue(tenthuonggoi);
                                database.child("Cay").child(""+i).child("dactinh").setValue(dactinh);
                                database.child("Cay").child(""+i).child("mausac").setValue(mausac);
                                database.child("Cay").child(""+i).child("images").setValue(images);


                                Toast.makeText(MainActivaty_CURD.this, "THÊM SẢN PHẨM THÀNH CÔNG ", Toast.LENGTH_SHORT).show();
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