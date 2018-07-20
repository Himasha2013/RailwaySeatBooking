package com.express.railway.railwayseatbooking.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.express.railway.railwayseatbooking.R;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText pwd;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.userName);
        pwd = (EditText) findViewById(R.id.pwd);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logUser(name.getText().toString(), pwd.getText().toString());
            }
        });
    }

    private void logUser(String name, String pwd) {

        if(name.equals("user")&&pwd.equals("user")){
           //Normal user
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            //pass username to the new Activity
            intent.putExtra("USER_NAME", name);
            startActivity(intent);
        }
        else if(name.equals("admin")&&pwd.equals("admin")){
            //Admin
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            //pass username to the new Activity
            intent.putExtra("USER_NAME", name);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
        }
    }
}
