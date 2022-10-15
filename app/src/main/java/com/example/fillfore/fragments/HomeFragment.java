package com.example.fillfore.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fillfore.R;
import com.example.fillfore.adapters.blogBigAdapter;
import com.example.fillfore.adapters.blog_viewPager_Adapter;
import com.example.fillfore.databinding.FragmentHomeBinding;
import com.example.fillfore.models.blogBigModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
  FragmentHomeBinding binding;

    blog_viewPager_Adapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        // for menu addition in toolbar

        binding.homeToolbar.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.home_toolbar_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home_search:
                        Toast.makeText(getContext(), "search clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_home_notification:
                        Toast.makeText(getContext(), "notification clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });








        //viewPage Adapter or tablayout:
        String[] tabsTitle = new String[] {"General", "Informative", "Motivational"};
        adapter =new blog_viewPager_Adapter(this);
        binding.viewPagerBlog.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout,binding.viewPagerBlog,((tab, position) -> tab.setText(tabsTitle[position]))).attach();


        return binding.getRoot();

    }


}