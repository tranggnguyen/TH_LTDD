package com.example.btgk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.btgk.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding binding;
    ArrayList<String> msv = new ArrayList<>();
    ArrayList<String> images = new ArrayList<>();
    ArrayList<String> classStudent = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> key = new ArrayList<>();
    ListView lv;
    DatabaseReference database;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        setContentView(binding.getRoot());

        ArrayList<Student> foodArrayList = new ArrayList<>();

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);
        if(!listAdapter.isEmpty()){
            listAdapter.clear();
        }

        database.child("SinhVien").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i = 0;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    key.add(Integer.parseInt(dataSnapshot.getKey()));
                    msv.add(dataSnapshot.child("msv").getValue(String.class));
                    classStudent.add(dataSnapshot.child("classStudent").getValue(String.class));
                    name.add(dataSnapshot.child("name").getValue(String.class));
                    images.add(dataSnapshot.child("images").getValue(String.class));
                    Student fd = new Student(key.get(i),msv.get(i),name.get(i), classStudent.get(i), images.get(i));
                    foodArrayList.add(fd);
                    i+=1;
                }
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.lv.setAdapter(listAdapter);
        binding.lv.setClickable(true);

        binding.lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id)
            {
                Intent kk =new Intent(MainActivity.this, MainActivity_EDIT.class);
                kk.putExtra("msv",msv.get(pos));
                kk.putExtra("name",name.get(pos));
                kk.putExtra("classStudent",classStudent.get(pos));
                kk.putExtra("images",images.get(pos));
                kk.putExtra("pos",key.get(pos));
                startActivity(kk);
                return false;
            }
        });

        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent kk =new Intent(MainActivity.this, StudentInfo.class);
                kk.putExtra("msv",msv.get(pos));
                kk.putExtra("name",name.get(pos));
                kk.putExtra("classStudent",classStudent.get(pos));
                kk.putExtra("images",images.get(pos));
                kk.putExtra("pos",key.get(pos));
                startActivity(kk);
            }
        });

    }
}