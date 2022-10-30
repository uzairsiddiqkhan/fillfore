package com.fillfore.speakClub.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fillfore.R;
import com.example.fillfore.databinding.ActivityMainBinding;
import com.fillfore.speakClub.fragments.HomeFragment;
import com.fillfore.speakClub.fragments.ProfileFragment;

import com.fillfore.speakClub.fragments.LikedBlogFragment;
import com.fillfore.speakClub.fragments.callFragement;
import com.fillfore.speakClub.fragments.videoFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TabLayout tabLayout;
    Toolbar toolbar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        fragSelection(new HomeFragment());
        tabLayout = findViewById(R.id.tabLayout);
        toolbar = findViewById(R.id.homeToolbar);







        binding.bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.btnHome:
                        fragSelection(new HomeFragment());
                        break;
                    case R.id.btnVideo:
                        fragSelection(new videoFragment());
                        break;

                    case R.id.btnCall:
                        fragSelection(new callFragement());
                        break;
                    case R.id.btnBook:
                        fragSelection(new LikedBlogFragment());
                        break;
                    case R.id.btnProfile:
                        fragSelection(new ProfileFragment());
                        break;

                }


                return true;

            }
        });




    }

    public void fragSelection(Fragment frag) {

        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.container, frag);
        fm.commit();

        // store all data in stack
//            fm.addToBackStack(null); // but a useless method ...
    }

    @Override
    public void onBackPressed() {


        if (binding.bnView.getSelectedItemId() == R.id.btnHome) {

            tabLayout = findViewById(R.id.tabLayout);
            toolbar = findViewById(R.id.homeToolbar);

            if (tabLayout.getSelectedTabPosition() == 0) {


                if (toolbar.hasExpandedActionView()) {
                    toolbar.collapseActionView();
                } else {
                    super.onBackPressed();
                }
            } else if (tabLayout.getSelectedTabPosition() == 1 || tabLayout.getSelectedTabPosition() == 2) {
                if (toolbar.hasExpandedActionView()) {
                    toolbar.collapseActionView();

                } else {

                    tabLayout.getTabAt(0).select();
                }
            }

        } else {
            binding.bnView.setSelectedItemId(R.id.btnHome);
        }

    }




}