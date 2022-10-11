package com.example.btgk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.btgk.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding binding;
    String[] fruitList ={"trà sữa dâu","trà sữa thái xanh","trà sữa trân châu","trà đào","trà sữa khoai môn"};
    int fruitImages []= new int[]{R.drawable.tsdau, R.drawable.thaixanh, R.drawable.trasuatranchau, R.drawable.tradao, R.drawable.khoaimon};
    String[] content ={"Thơm,ngon","Tươi mát","Bổ,rẻ","Sảng khoái","Bao ngon"};
    String[] money = {"40$","20$","60$","50$","30$"};
    ListView lv;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Food> foodArrayList = new ArrayList<>();
        for(int i = 0 ; i< fruitList.length; i++ ){
            Food fd = new Food(fruitList[i],content[i], money[i], fruitImages[i],"","");
            foodArrayList.add(fd);
        }
        ArrayList<Food> foods = new ArrayList<>();
        for(int i = 0 ; i< fruitList.length; i++ ){
            Food fd = new Food(fruitList[i],content[i], money[i], fruitImages[i],"","");
            foodArrayList.remove(fd);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);
        binding.lv.setAdapter(listAdapter);
        binding.lv.setClickable(true);
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent kk =new Intent(MainActivity.this, FoodInfo.class);
                kk.putExtra("title",fruitList[position]);
                kk.putExtra("content",content[position]);
                kk.putExtra("money",money[position]);
                kk.putExtra("imageid",fruitImages[position]);
                startActivity(kk);
            }
        });

    }
}