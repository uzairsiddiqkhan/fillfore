package com.example.fillfore.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fillfore.fragments.Informative_blog_fragment;
import com.example.fillfore.fragments.general_blog_Fragment;
import com.example.fillfore.fragments.motivational_blog_Fragment;

public class blog_viewPager_Adapter extends FragmentStateAdapter {

    String[] tabs = {"General", "Informative", "Motivational"};



    public blog_viewPager_Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }





    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new general_blog_Fragment();

            case 1:
                return new Informative_blog_fragment();

            case 2:
                return new motivational_blog_Fragment();

            default:
                return new general_blog_Fragment();

        }

    }

    @Override
    public int getItemCount() {
        return tabs.length;
    }

}
