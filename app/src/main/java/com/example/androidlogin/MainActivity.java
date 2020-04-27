package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userName, passWord;
    private Button loginButton;
    private TextView textView;
    private int counter = 3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userNameID);
        passWord = findViewById(R.id.passwordID);
        loginButton = findViewById(R.id.loginButton);
        textView = findViewById(R.id.textViewID);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String password = passWord.getText().toString();

                if (username.equals("admin") && password.equals("1234")){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                } else {
                    counter--;
                    textView.setText("Attempts remaining :"+counter);
                    if (counter==0){
                        loginButton.setEnabled(false);
                    }
                }

            }
        });
    }
}
