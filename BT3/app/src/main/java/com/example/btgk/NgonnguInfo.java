package com.example.btgk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.btgk.databinding.ActivityNgonnguInfoBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NgonnguInfo extends DrawerBaseActivity {
    ActivityNgonnguInfoBinding binding;

    int pos = -1;
    String tenngonngu ;
    DatabaseReference database;
    int images[] ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNgonnguInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        Intent intent = this.getIntent();
        if (intent !=null){
            tenngonngu = intent.getStringExtra("tenngonngu");
            pos =  intent.getIntExtra("pos",-1);
            images = intent.getIntArrayExtra("image");
            load();

            binding.btnLuu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String content = binding.sothunhat.getText().toString();
                    database.child("ngongngu").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int i = 1;
                            boolean checkTitle = false;
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                                i = Integer.parseInt(dataSnapshot.getKey());
                            }
                            if(!checkTitle){
                                i+=1;
                                database.child("ngonngu").child(""+i).child("id").setValue(String.valueOf(pos));
                                database.child("ngonngu").child(""+i).child("content").setValue((content));

                                Toast.makeText(NgonnguInfo.this, "Lưu ngôn thành công ", Toast.LENGTH_SHORT).show();
                                load();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });
        }
    }
    public void load(){
        ArrayList<History> listHistory = new ArrayList<>();
        ListAdapter2 listAdapter = new ListAdapter2(NgonnguInfo.this,listHistory);

        ArrayList<String> listA = new ArrayList<>();
        ArrayList<String> listId = new ArrayList<>();

        database.child("ngonngu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i = 0;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    listId.add(dataSnapshot.child("id").getValue(String.class));
                    listA.add(dataSnapshot.child("content").getValue(String.class));
                    History hst = new History(images[Integer.parseInt((listId.get(i)))], listA.get(i));
                    listHistory.add(hst);
                    i+=1;
                }
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.lv2.setAdapter(listAdapter);
        binding.lv2.setClickable(true);
        binding.title.setText(tenngonngu);
    }
}