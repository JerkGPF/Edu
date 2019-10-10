package com.example.edu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.edu.R;
import com.example.edu.fragment.Home_Fragment_1;
import com.example.edu.fragment.Home_Fragment_2;
import com.example.edu.fragment.Home_Fragment_3;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    List<Fragment> fragments;
    FragmentPagerAdapter fragmentPagerAdapter;
    LinearLayout rg_bottom_navigation_listen,rg_bottom_navigation_think,rg_bottom_navigation_my;
    TextView image1,image2,image3,text1,text2,text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);
        initFindID();
        initFragment();
        initOnClick();
    }

    private void initOnClick() {
        rg_bottom_navigation_think.setOnClickListener(this);
        rg_bottom_navigation_my.setOnClickListener(this);
        rg_bottom_navigation_listen.setOnClickListener(this);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new Home_Fragment_1());
        fragments.add(new Home_Fragment_2());
        fragments.add(new Home_Fragment_3());

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPager.setAdapter(fragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int item =viewPager.getCurrentItem();
                SetTab(item);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void SetTab(int item) {
        color();
        switch (item){
            case 0:
                text1.setTextColor(this.getResources().getColor(R.color.lessgreen));
                image1.setBackgroundResource(R.mipmap.main_course_icon_selected);
                break;
            case 1:
                text2.setTextColor(this.getResources().getColor(R.color.lessgreen));
                image2.setBackgroundResource(R.mipmap.main_exercises_icon_selected);
                break;
            case 2:
                text3.setTextColor(this.getResources().getColor(R.color.lessgreen));
                image3.setBackgroundResource(R.mipmap.main_my_icon_selected);
                break;
        }
    }

    private void color() {
        text1.setTextColor(this.getResources().getColor(R.color.black));
        text2.setTextColor(this.getResources().getColor(R.color.black));
        text3.setTextColor(this.getResources().getColor(R.color.black));
        image1.setBackgroundResource(R.mipmap.main_course_icon);
        image2.setBackgroundResource(R.mipmap.main_exercises_icon);
        image3.setBackgroundResource(R.mipmap.main_my_icon);
    }

    private void initFindID() {
        viewPager = findViewById(R.id.viewpager);
        rg_bottom_navigation_listen = findViewById(R.id.rg_bottom_navigation_listen);
        rg_bottom_navigation_my = findViewById(R.id.rg_bottom_navigation_my);
        rg_bottom_navigation_think = findViewById(R.id.rg_bottom_navigation_think);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rg_bottom_navigation_listen:
                change(0);
                break;
            case R.id.rg_bottom_navigation_think:
                change(1);
                break;
            case R.id.rg_bottom_navigation_my:
                change(2);
                break;
        }
    }

    private void change(int i) {
        SetTab(i);
        viewPager.setCurrentItem(i);
    }
}
