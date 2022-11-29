package com.example.btgk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.btgk.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MainActivity extends DrawerBaseActivity{

    ActivityMainBinding binding;
    String[] NgonnguList ={"VIỆT NAM","ANH","PHÁP","NGA","HÀN QUỐC","BRAZIL"};
    int iconNgonNgu[] = new int[] {R.drawable.vn,R.drawable.anh,R.drawable.phap, R.drawable.ngapng, R.drawable.hanquocpng,  R.drawable.brazil};
    Button btnTinh,btnLuu;
    ArrayList<Integer> key = new ArrayList<>();
    ListView lv;
    DatabaseReference database;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://btgk-c12ce-default-rtdb.firebaseio.com/");
        setContentView(binding.getRoot());

        ArrayList<Ngonngu> foodArrayList = new ArrayList<>();

//        for(int i = 0 ; i< fruitList.size(); i++ ){
//            Food fd = new Food(fruitList.get(i),content.get(i), money.get(i), fruitImages.get(0),"","");
//            foodArrayList.add(fd);
//        }

//        if(!listAdapter.isEmpty()){
//            listAdapter.clear();
//        }
        for(int i = 0 ; i< NgonnguList.length; i++ ){
//                    key.add(Integer.parseInt(dataSnapshot.getKey()));
//                    tenpheptinh.add(dataSnapshot.child("ca").getValue(String.class));

            Ngonngu fd = new Ngonngu(i,NgonnguList[i],iconNgonNgu[i]);
            foodArrayList.add(fd);
        }
//        listAdapter.notifyDataSetChanged();
//        database.child("Ca").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);
        binding.lv.setAdapter(listAdapter);
        binding.lv.setClickable(true);
//
//        binding.lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
//            @Override
//            public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id)
//            {
//                Intent kk =new Intent(MainActivity.this, MainActivity_EDIT.class);
//                kk.putExtra("tenpheptinh",tenpheptinh.get(pos));
//                kk.putExtra("pos",key.get(pos));
//                startActivity(kk);
//                return false;
//            }
//        });

        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent kk =new Intent(MainActivity.this, NgonnguInfo.class);
                kk.putExtra("tenngonngu",NgonnguList[pos]);
                kk.putExtra("pos",pos);
                kk.putExtra("image",iconNgonNgu);
                startActivity(kk);
            }
        });

    }


}