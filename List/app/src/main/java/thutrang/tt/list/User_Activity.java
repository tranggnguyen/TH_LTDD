package thutrang.tt.list;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class User_Activity extends AppCompatActivity {
    ActivityUserBinding binding;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    binding =ActivityUserBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    Intent intent=this.getIntent();
    if(intent !=null){
        String name =intent.getStringExtra()
    }
}
}
