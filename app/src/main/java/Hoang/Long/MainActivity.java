package Hoang.Long;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppDatabase db;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPhone;
    String gender;
    Button addBtn;
    Button searchBtn;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        editTextName = findViewById(R.id.name);
        editTextEmail = findViewById(R.id.email);
        editTextPhone = findViewById(R.id.phone);
        addBtn = findViewById(R.id.addbtn);
        addBtn.setOnClickListener(this);
        searchBtn = findViewById(R.id.search);
        searchBtn.setOnClickListener(this);
        radioButtonMale = findViewById(R.id.btMale);
        radioButtonFemale = findViewById(R.id.btFemale);
        radioGroup = findViewById(R.id.gendergroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case 0: {
                        gender = "Male";
                        break;
                    }
                    case 1: {
                        gender = "Female";
                        break;
                    }
                    default:
                        break;
                }
            }
        });


    }

    private void insertUser() {
        if (!validate()) return;
        UserEntity user = new UserEntity();
        user.name = editTextName.getText().toString();
        user.email = editTextPhone.getText().toString();
        user.gender = gender;
        db.UserDao().insertUser(user);
    }

    CompoundButton.OnCheckedChangeListener listenerRadio
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                gender = compoundButton.getText().toString();
            }
        }
    };

    private boolean validate() {
        String mes = null;
        if (editTextName.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập username";
        } else if (editTextEmail.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập mail";
        } else if (editTextPhone.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập phone";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addbtn: {
                insertUser();
            }
            default:
                break;
        }
    }
}