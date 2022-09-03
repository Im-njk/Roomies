package com.Njk.roomies.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    
    RecyclerView ad_amt_recycler;
    List<roomateDetail> rommatedetail=new ArrayList<>();
    Add_amt_recycler add_amt_recycler_class;
    
    EditText tot_amt;
    double total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amt);

        roomateDetail r0=new roomateDetail("You",0);
        roomateDetail r1=new roomateDetail("Lokesh",0);
        roomateDetail r2=new roomateDetail("H...j",0);
        roomateDetail r3=new roomateDetail("Kamal",0);
        rommatedetail.add(r0);
        rommatedetail.add(r1);
        rommatedetail.add(r2);
        rommatedetail.add(r3);

        ad_amt_recycler =findViewById(R.id.recycler_add_amt);
        ad_amt_recycler.setHasFixedSize(true);
        ad_amt_recycler.setLayoutManager(new GridLayoutManager(this,1));
        
        tot_amt = findViewById(R.id.tot_amt_xml);
        
        tot_amt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        
            }

            @Override
            public void afterTextChanged(Editable editable) {
                total = Double.parseDouble(editable.toString());
                recycler();
            }
        });
        recycler();
    }
    void recycler(){
        add_amt_recycler_class=new Add_amt_recycler(this,rommatedetail,total);
        ad_amt_recycler.setAdapter(add_amt_recycler_class);
    }
}