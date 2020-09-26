package com.example.tablayoutwithviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabLayoutId);
        viewPager=findViewById(R.id.viewPagerId);

        tabLayout.addTab(tabLayout.newTab().setText("First"));
        tabLayout.addTab(tabLayout.newTab().setText("Second"));
        tabLayout.addTab(tabLayout.newTab().setText("Third"));

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    public  class PagerAdapter extends FragmentPagerAdapter{
        int tabCount;
        public PagerAdapter(@NonNull FragmentManager fm,int tabCount) {
            super(fm);
            this.tabCount=tabCount;
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            // it is fragment position
            switch (position){
                case 0:
                    return  new First();
                case 1:
                    return  new Second();
                    case 2:
                    return  new Third();
            }
            return null;
        }
        @Override
        public int getCount() {
            return tabCount;
        }
    }


}