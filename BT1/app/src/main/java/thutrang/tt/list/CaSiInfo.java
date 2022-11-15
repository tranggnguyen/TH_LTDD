package thutrang.tt.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import thutrang.tt.list.databinding.ActivityCasiInfoBinding;

public class CaSiInfo extends AppCompatActivity {

    ActivityCasiInfoBinding binding;
    TextView back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCasiInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        back= (TextView)findViewById(R.id.back) ;
        back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backman = new Intent(CaSiInfo.this,MainActivity.class);
                startActivity(backman);
            }
        });
        Intent intent = this.getIntent();
        if (intent !=null){
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String sosao = intent.getStringExtra("sosao");
            int img = intent.getIntExtra("imageid",R.drawable.st);
            String quocGia = intent.getStringExtra("quocGia");

            binding.title.setText(title);
            binding.content.setText(content);
            binding.sosao.setText(sosao);
            binding.img.setImageResource(img);
            binding.quocGia.setText(quocGia);
        }
    }
}