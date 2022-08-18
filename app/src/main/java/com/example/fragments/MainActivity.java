package com.example.fragments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

import com.Fragment1;
import com.Fragment2;
import com.Fragment3;
import com.MyTabListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp < 720) {

            ActionBar actionBar = getSupportActionBar();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            //CRIACAO DA PRIMEIRA ABA(TAB) DO MEU MENU:
            ActionBar.Tab tab1 = actionBar.newTab().setText("Frag 1");
            tab1.setTabListener(new MyTabListener(new Fragment1()));
            actionBar.addTab(tab1);

            ActionBar.Tab tab2 = actionBar.newTab().setText("Frag 2");
            tab2.setTabListener(new MyTabListener(new Fragment2()));
            actionBar.addTab(tab2);

            ActionBar.Tab tab3 = actionBar.newTab().setText("Frag 3");
            tab3.setTabListener(new MyTabListener(new Fragment3()));
            actionBar.addTab(tab3);



/*        //associacao do fragmento pelo código java
        if(savedInstanceState == null){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            Fragment1 frag1 = new Fragment1();

            ft.add(R.id.layoutFrag,frag1, "Fragment1");
            ft.commit();
        }*/
        }
    }
}