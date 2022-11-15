package thutrang.tt.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import thutrang.tt.list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView add,remove;
    String[] CasiList ={"Sơn Tùng","Mỹ Tâm","MoNo","Đức Phúc","Hòa Minzy","Noo Phước Thịnh"};
    int CasiImages []= new int[]{R.drawable.st, R.drawable.tam, R.drawable.mono, R.drawable.phuc, R.drawable.hoa,R.drawable.no};
    String[] content ={"Tên là Nguyễn Thanh Tùng",
            "Tên thật là Phan Thị Mỹ Tâm",
            "Tên thật là Nguyễn Việt Hoàng",
            "Tên thật là Nguyễn Đức Phúc",
            "Tên thật là Nguyễn Thị Hòa",
            "Tên thật là Nguyễn Phước Thịnh"};
    String[] star = {"5★","4★","5★","3★","5★","4★"};
    String[] quocGia = {"Việt Nam","Việt Nam","Việt Nam","Việt Nam","Việt Nam","Việt Nam"};
    ListView lv;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayList<CaSi> foodArrayList = new ArrayList<>();
        for(int i = 0 ; i< CasiList.length; i++ ){
            CaSi fd = new CaSi(CasiList[i],content[i], star[i], CasiImages[i], quocGia[i]);
            foodArrayList.add(fd);
        }
        ArrayList<CaSi> foods = new ArrayList<>();
        for(int i = 0 ; i< CasiList.length; i++ ){
            CaSi fd = new CaSi(CasiList[i],content[i], star[i], CasiImages[i],quocGia[i]);
            foodArrayList.remove(fd);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);
        binding.lv.setAdapter(listAdapter);
        binding.lv.setClickable(true);
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent kk =new Intent(MainActivity.this, CaSiInfo.class);
                kk.putExtra("title",CasiList[position]);
                kk.putExtra("content",content[position]);
                kk.putExtra("sosao",star[position]);
                kk.putExtra("imageid",CasiImages[position]);
                kk.putExtra("quocGia",quocGia[position]);
                startActivity(kk);
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kk =new Intent(MainActivity.this, MainActivity_Login.class);
                startActivity(kk);

            }
        });
        
    }
}