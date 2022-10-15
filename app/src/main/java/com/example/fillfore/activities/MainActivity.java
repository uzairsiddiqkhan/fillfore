package com.example.fillfore;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fillfore.databinding.ActivityMainBinding;
import com.example.fillfore.fragments.HomeFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        fragSelection(new HomeFragment());


        binding.bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.btnHome:
                        fragSelection(new HomeFragment());
                        break;
                    case R.id.btnVideo:
                        fragSelection(new com.example.fillfore.videoFragment());
                        break;
                    case R.id.btnCall:
                        fragSelection(new com.example.fillfore.callFragement());
                        break;
                    case R.id.btnBook:
                        fragSelection(new com.example.fillfore.LikedBlogFragment());
                        break;
                    case R.id.btnProfile:
                        fragSelection(new com.example.fillfore.ProfileFragment());
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
            finish();
            super.onBackPressed();

        } else {
            binding.bnView.setSelectedItemId(R.id.btnHome);
        }

    }

}