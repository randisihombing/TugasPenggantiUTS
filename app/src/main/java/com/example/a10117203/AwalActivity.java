package com.example.a10117203;
//12-05-2020,10117203,Randi Tumbur Arjuna,IF7
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AwalActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPageAdapter introViewPageAdapter;
    TabLayout tabIndicator;
    Button btnGetStarted;
    int position = 0;
    Animation btnAnim;


    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //agar activity full screen
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_awal);

        //hide action bar


        //views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btn_get_started);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        //listscreen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Hello.. Welcome To MyApps","Ini adalah aplikasi android pertama yang saya buat",R.drawable.respon));
        mList.add(new ScreenItem("First App","Aplikasi ini berisi mengenai data diri pribadi saya dan ada sebagian dari teman teman saya",R.drawable.lepi));
        mList.add(new ScreenItem("What Inside?","Selamat mencoba menjelajahi aplikasi",R.drawable.internet));

        //bagian viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPageAdapter = new IntroViewPageAdapter(this,mList);
        screenPager.setAdapter(introViewPageAdapter);

        //tablayout
        tabIndicator.setupWithViewPager(screenPager);

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }

            }


            public void onTabUnselected(TabLayout.Tab tab) {

            }


            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //GetStarted Listener

        btnGetStarted.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //open Main Activity

                Intent navActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(navActivity);


            }
        });


    }
    //menampilkan tombol getStarted
    private void loadLastScreen(){

        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        //
        //
        btnGetStarted.setAnimation(btnAnim);

    }
}

