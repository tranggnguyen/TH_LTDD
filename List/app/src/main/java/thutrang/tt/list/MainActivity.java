package thutrang.tt.list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import thutrang.tt.list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView add,remove;
    String[] fruitList ={"apple","banana","dau","orange","melon"};
    int fruitImages []= new int[]{R.drawable.apple, R.drawable.banana, R.drawable.dau, R.drawable.orange, R.drawable.melon};
    String[] content ={"Nguyễn Thị Thư Trang","2050531200345","Ngon bổ rẻ","Cam tươi","Chín mọng ,nhiều nước"};
    String[] money = {"60$","60$","60$","60$","60$"};
    ListView lv;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        add = (TextView) findViewById(R.id.add);
        remove = (TextView) findViewById(R.id.remove);


        ArrayList<food> foodArrayList = new ArrayList<>();
        for(int i = 0 ; i< fruitList.length; i++ ){
            food fd = new food(fruitList[i],content[i], money[i], fruitImages[i]);
            foodArrayList.add(fd);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);

        binding.lv.setAdapter(listAdapter);
        binding.lv.setClickable(true);
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this,
                        "Bạn Đã Chọn Loại Trái Cây : " + fruitList[i],Toast.LENGTH_SHORT).show();
                Intent i =new Intent(MainActivity.this,User_Activity.class);
            }
        });
//        //add items
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,
//                        "Bạn đã thêm vào giỏ hàng: " ,Toast.LENGTH_SHORT).show();
//
//            }
//        });
        
    }
}