package com.example.constructor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {


    Fragment previosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        previosFragment= new HomeFragment();

    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment=new HomeFragment();;
                            previosFragment=selectedFragment;
                            break;
                        case R.id.nav_search:
                            selectedFragment=new SearchFragment();
                            previosFragment=selectedFragment;
                            break;
                        case R.id.nav_add:

                            selectedFragment=previosFragment;
                            BottomSheet bottomSheet=new BottomSheet();
                            bottomSheet.show(getSupportFragmentManager(),"bottomsheet");
                            break;

                        case R.id.nav_notification:
                            selectedFragment=new notificationFragment();
                            previosFragment=selectedFragment;
                            break;
                        case R.id.nav_profile:
                            selectedFragment=new profileFragment();
                            previosFragment=selectedFragment;
                            break;

                    }



                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                    return true;

                }
            };
}
