package thutrang.tt.silde5;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import thutrang.tt.silde5.adapter.EmployeeAdapter;
import thutrang.tt.silde5.model.Employee;
import thutrang.tt.silde5.sqlite.EmplyoyeeDao;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private EmployeeAdapter employeeAdapter;
    private ListView lvEmployees;
    private String employeeId;
    private List<Employee>list;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // dbHelper =new DBHelper(this);
        //SQLiteDatabase database = dbHelper.getReadableDatabase();
        //database.close();
        findViewById(R.id.btnEdit).setOnClickListener(this);
        findViewById(R.id.btnInsert).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);


        lvEmployees =findViewById(R.id.lvEmployees);
        EmplyoyeeDao dao =new EmplyoyeeDao(this);
        List<Employee>list=dao.getAll();

        employeeAdapter = new EmployeeAdapter(this,list);
        lvEmployees.setAdapter(employeeAdapter);
        lvEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Employee emp =list.get(i);
                employeeId = emp.getId();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onResume() {
        super.onResume();
        EmplyoyeeDao dao = new EmplyoyeeDao(this);
        List<Employee>updateList=dao.getAll();
        list.clear();
        updateList.forEach(item->list.add(item));
        employeeAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,AddOrEditEmployeeActivity.class);
        switch (view.getId()){
            case R.id.btnInsert:
                startActivity(intent);
                break;
            case R.id.btnEdit:
                if (employeeId == null){
                    Toast.makeText(this,"Employee is must be  selected",Toast.LENGTH_SHORT).show();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("id",employeeId);
                intent.putExtra("data",bundle);

                startActivity(intent);
                break;
            case R.id.btnDelete:
                if(employeeId == null){
                    Toast.makeText(this,"Employee is must be selected"
                            ,Toast.LENGTH_SHORT).show();
                    return;
                }
                EmplyoyeeDao dao = new EmplyoyeeDao(this);
                dao.delete(employeeId);
                employeeId =null;
                onResume();
                Toast.makeText(this,"Employee is must be deleted",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}