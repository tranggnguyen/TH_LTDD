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
    ArrayList<String> tenkhoahoc = new ArrayList<>();
    ArrayList<String> tenthuonggoi = new ArrayList<>();
    ArrayList<String> dactinh = new ArrayList<>();
    ArrayList<String> mausac = new ArrayList<>();
    ArrayList<String> image = new ArrayList<>();
    ArrayList<Integer> key = new ArrayList<>();
    ListView lv;
    DatabaseReference database;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");

        setContentView(binding.getRoot());

        ArrayList<Ca> foodArrayList = new ArrayList<>();

//        for(int i = 0 ; i< fruitList.size(); i++ ){
//            Food fd = new Food(fruitList.get(i),content.get(i), money.get(i), fruitImages.get(0),"","");
//            foodArrayList.add(fd);
//        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);
        if(!listAdapter.isEmpty()){
            listAdapter.clear();
        }

        database.child("Ca").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i = 0;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    key.add(Integer.parseInt(dataSnapshot.getKey()));
                    tenkhoahoc.add(dataSnapshot.child("tenkhoahoc").getValue(String.class));
                    tenthuonggoi.add(dataSnapshot.child("tenthuonggoi").getValue(String.class));
                    dactinh.add(dataSnapshot.child("dactinh").getValue(String.class));
                    mausac.add(dataSnapshot.child("mausac").getValue(String.class));
                    image.add(dataSnapshot.child("images").getValue(String.class));
                    Ca fd = new Ca(key.get(i),tenkhoahoc.get(i),tenthuonggoi.get(i), dactinh.get(i), mausac.get(i),image.get(i));
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
                kk.putExtra("tenkhoahoc",tenkhoahoc.get(pos));
                kk.putExtra("tenthuonggoi",tenthuonggoi.get(pos));
                kk.putExtra("dactinh",dactinh.get(pos));
                kk.putExtra("mausac",mausac.get(pos));
                kk.putExtra("images",image.get(pos));
                kk.putExtra("pos",key.get(pos));
                startActivity(kk);
                return false;
            }
        });

        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent kk =new Intent(MainActivity.this, CaInfo.class);
                kk.putExtra("tenkhoahoc",tenkhoahoc.get(pos));
                kk.putExtra("tenthuonggoi",tenthuonggoi.get(pos));
                kk.putExtra("dactinh",dactinh.get(pos));
                kk.putExtra("mausac",mausac.get(pos));
                kk.putExtra("images",image.get(pos));
                kk.putExtra("pos",key.get(pos));
                startActivity(kk);
            }
        });

    }
}