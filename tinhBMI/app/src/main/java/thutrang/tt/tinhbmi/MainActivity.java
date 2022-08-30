package thutrang.tt.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.IdentityHashMap;

public class MainActivity extends AppCompatActivity {
    EditText etChieuCao,etCanNang;
    RadioButton rbNam,rbNu;
    Button btnTinhBMI;
    TextView txtChiSo,txtNhanXet;
    double chiSo;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChieuCao = findViewById(R.id.editTextCC);
        etCanNang = findViewById(R.id.editTextNC);
        rbNam = findViewById(R.id.radioButtonnNam);
        rbNu = findViewById(R.id.radioButtonNu);
        btnTinhBMI = findViewById(R.id.buttonTinh);
        txtChiSo = findViewById(R.id.textViewBMI);
        txtNhanXet = findViewById(R.id.textViewDanhGia);

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double chieucao = Double.parseDouble(etChieuCao.getText().toString()) / 100;
                double cannang = Double.parseDouble(etCanNang.getText().toString());
                chiSo = cannang / Math.pow(chieucao, 2);
                if (rbNam.isChecked()) {
                    if (chiSo < 18.5) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                    } else if (chiSo >= 18.5 && chiSo <= 24.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn có chỉ số BMI bình thường");
                    } else if (chiSo == 25) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang bị thừa cân");
                    } else if (chiSo > 25 && chiSo <= 29.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở giai đoạn tiền béo phì/béo phì mực độ thấp");
                    } else if (chiSo >= 30 && chiSo <= 34.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở béo phì độ I");
                    } else if (chiSo >= 30 && chiSo <= 39.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở béo phì độ II");
                    } else if (chiSo == 40) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở béo phì độ III");
                    }
                } else if (rbNu.isChecked()) {
                    if (chiSo < 18.5) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                    } else if (chiSo >= 18.5 && chiSo <= 22.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn có chỉ số BMI bình thường");
                    } else if (chiSo == 23) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang bị thừa cân");
                    } else if (chiSo > 23 && chiSo <= 24.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở giai đoạn tiền béo phì/béo phì mực độ thấp");
                    } else if (chiSo >= 30 && chiSo <= 29.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở béo phì độ I");
                    } else if (chiSo >= 30 && chiSo <= 39.9) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở béo phì độ II");
                    } else if (chiSo == 40) {
                        txtChiSo.setText(String.valueOf(chiSo));
                        txtNhanXet.setText("Bạn đang ở béo phì độ III");
                    }
                    else {
                    Toast.makeText(getApplicationContext(),"Vui lòng chọn giới tính!",
                            Toast.LENGTH_LONG).show();
                }
                }
            }
        });

    }
}



