package com.example.fillfore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.MenuItem;

import com.example.fillfore.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());




fragSelection(new HomeFragment());


    binding.bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.btnHome: fragSelection(new HomeFragment());
                    break;
                case R.id.btnCall: fragSelection(new callFragement());
                    break;
                case R.id.btnBook: fragSelection(new LikedBlogFragment());
                    break;
                case R.id.btnProfile: fragSelection(new ProfileFragment());
                    break;

            }


            return true;

        }
    });


    }
    public void fragSelection(Fragment frag){

            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.container, frag);
            fm.commit();

    }
}