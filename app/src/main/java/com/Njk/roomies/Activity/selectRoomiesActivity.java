package com.Njk.roomies.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.Njk.roomies.R;
import com.Njk.roomies.adapters.Add_amt_recycler;
import com.Njk.roomies.model.roomateDetail;

import java.util.ArrayList;
import java.util.List;

public class selectRoomiesActivity extends AppCompatActivity {
    RecyclerView ad_amt_recycler;
    List<roomateDetail> rommatedetail=new ArrayList<>();
    Add_amt_recycler add_amt_recycler_class;

    TextView tot , description;

    double total;
    String des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_roomies);

        Bundle b = getIntent().getExtras();
        total = b.getDouble("tot");
        des = b.getString("des");

        tot = findViewById(R.id.tot_amt_xml_select_roomies);
        tot.setText("Rs. "+ total);

        description = findViewById(R.id.des_xml);
        description.setText(des);

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

        recycler();
    }
    void recycler(){
        add_amt_recycler_class=new Add_amt_recycler(this,rommatedetail,total,add_amt_recycler_class,ad_amt_recycler);
        ad_amt_recycler.setAdapter(add_amt_recycler_class);
    }
}