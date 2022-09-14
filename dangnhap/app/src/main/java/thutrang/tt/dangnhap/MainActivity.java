package thutrang.tt.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textViewRegister, textViewUser, textViewPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lay du lieu tu text user
        textViewUser = (TextView) findViewById(R.id.edtUser);
        // lay du lieuj tu text pass chua
        textViewPass =(TextView) findViewById(R.id.edtPass);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "trang";
                String pass = "123456";
                //dang nhap tu lam them cai password di de hieu k
                if (textViewUser.getText().toString().equals(user) && textViewPass.getText().toString().equals(pass)){
                    Intent i = new Intent(MainActivity.this, MainActivity5.class);
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();

                    startActivity(i);
                }
               else{
                   // hien loi
                   Toast.makeText(MainActivity.this, "Dang nhap loi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // bam chu nhay page cac giao diẹn no lỗi r
        textViewRegister = (TextView) findViewById(R.id.textViewRegister) ;
        textViewRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(i);
            }
        });


    }
}
