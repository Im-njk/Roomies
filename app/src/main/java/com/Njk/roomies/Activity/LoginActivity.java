package com.Njk.roomies.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Int4;
import android.view.View;
import android.widget.Button;

import com.Njk.roomies.DoubleClickListener;
import com.Njk.roomies.R;

public class LoginActivity extends AppCompatActivity {
  Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn=findViewById(R.id.signinbtn);
        signIn.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onSingleClick(View v) {
                Intent i=new Intent(LoginActivity.this,homeActivity.class);
                startActivity(i);
            }

            @Override
            public void onDoubleClick(View v) {

            }
        });

    }
}