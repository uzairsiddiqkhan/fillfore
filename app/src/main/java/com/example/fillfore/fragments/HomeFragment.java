package com.example.fillfore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.fillfore.adapters.blogBigAdapter;
import com.example.fillfore.adapters.blog_viewPager_Adapter;
import com.example.fillfore.databinding.FragmentHomeBinding;
import com.example.fillfore.models.blogBigModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    blog_viewPager_Adapter viewPager_adapter;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());


        closeSearchView();

        //viewPage Adapter or tablayout:
        String[] tabsTitle = new String[]{"General", "Informative", "Motivational"};
        viewPager_adapter = new blog_viewPager_Adapter(this);
        binding.viewPagerBlog.setAdapter(viewPager_adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPagerBlog, ((tab, position) -> tab.setText(tabsTitle[position]))).attach();
        if (binding.tabLayout.getSelectedTabPosition() == 0) {


        }


        return binding.getRoot();


    }


//close search View when fragment move...

    public void closeSearchView() {

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (binding.homeToolbar.hasExpandedActionView()) {
                    binding.homeToolbar.collapseActionView();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

// search query listener


}



