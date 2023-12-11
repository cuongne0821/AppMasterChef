package com.example.appmasterchef;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmasterchef.HelperClass;
import com.example.appmasterchef.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    EditText signupUsername, signupPassword, signupPassword1;
    TextView logintext;

    Button signupButton;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        logintext=findViewById(R.id.loginRedirectText);
        signupUsername = findViewById(R.id.signp_username);
        signupPassword = findViewById(R.id.singup_password);
        signupPassword1 = findViewById(R.id.singup_password1);
        signupButton = findViewById(R.id.signup_button);

        reference = FirebaseDatabase.getInstance().getReference("users");

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để mở LoginActivity
                Intent intent = new Intent(register.this, Login.class);

                // Bắt đầu hoạt động mới (chuyển đến LoginActivity)
                startActivity(intent);
            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String password1 = signupPassword1.getText().toString();

                if (!name.isEmpty() && !password.isEmpty() && !password1.isEmpty()) {
                    if (password.equals(password1)) {
                        HelperClass helperClass = new HelperClass(name, password,password1);
                        reference.child(name).setValue(helperClass);
                        Toast.makeText(getApplicationContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}