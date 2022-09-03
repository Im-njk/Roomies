package com.Njk.roomies.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.Njk.roomies.DoubleClickListener;
import com.Njk.roomies.R;
import com.Njk.roomies.adapters.Add_amt_recycler;
import com.Njk.roomies.adapters.home_recycler_adapter;
import com.Njk.roomies.model.roomateDetail;
import com.google.android.material.navigation.NavigationView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity {
    Button addBtn;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navbtn;


    RecyclerView recyclerView;
    home_recycler_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addBtn=findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onSingleClick(View v) {
                Intent i=new Intent(homeActivity.this,
                        addAmtActivity.class);
                startActivity(i);
            }

            @Override
            public void onDoubleClick(View v) {

            }
        });


        navbtn=findViewById(R.id.nav_btn);
        navbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          drawerLayout.openDrawer(GravityCompat.START);
                                      }
                                  });
        navigationdrawer();



        recyclerView=findViewById(R.id.home_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        roomateDetail r0=new roomateDetail("You",0);
        roomateDetail r1=new roomateDetail("Lokesh",0);
        roomateDetail r2=new roomateDetail("H...j",0);
        roomateDetail r3=new roomateDetail("Kamal",0);
        List<roomateDetail> rommatedetail = new ArrayList<>();
        rommatedetail.add(r0);
        rommatedetail.add(r1);
        rommatedetail.add(r2);
        rommatedetail.add(r3);
        adapter=new home_recycler_adapter(rommatedetail,this);
        recyclerView.setAdapter(adapter);
    }


    private void navigationdrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nv);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;}
        });

        navbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          drawerLayout.openDrawer(GravityCompat.START);
                                      }
                                  }
        );
    }
}