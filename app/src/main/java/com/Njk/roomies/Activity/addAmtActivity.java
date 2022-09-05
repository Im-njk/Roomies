package com.Njk.roomies.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Njk.roomies.DoubleClickListener;
import com.Njk.roomies.R;
import com.Njk.roomies.adapters.Add_amt_recycler;
import com.Njk.roomies.model.roomateDetail;

import java.util.ArrayList;
import java.util.List;

public class addAmtActivity extends AppCompatActivity { 
    Button next_btn;
    EditText tot_amt , des;
    double total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amt);
        next_btn = findViewById(R.id.nextBtn);
        tot_amt = findViewById(R.id.tot_amt_xml);
        des = findViewById(R.id.description_xml);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String descri = des.getText().toString();
                if(descri.length() > 0){
                    String tot_str = String.valueOf(tot_amt.getText());
                    total = Double.valueOf(tot_str.length() == 0 ? "0.0" : tot_str);
                    Intent yourIntent = new Intent(addAmtActivity.this, selectRoomiesActivity.class);
                    Bundle b = new Bundle();
                    b.putString("des",descri);
                    b.putDouble("tot", total);
                    yourIntent.putExtras(b);
                    startActivity(yourIntent);
                }
                else
                    Toast.makeText(addAmtActivity.this, "Fill out the Descriptiom", Toast.LENGTH_SHORT).show();
            }
        });
    }

}