package com.fillfore.speakClub.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.fillfore.speakClub.fragments.blogFragment;
import com.fillfore.speakClub.fragments.poetryFragment;

public class homeViewPagerAdapter extends FragmentStateAdapter {

    String[] tabs = {"Informative Blog", "Motivational Poetry"};


    public homeViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new blogFragment();

            case 1:
                return new poetryFragment();

            default:
                return new blogFragment();

        }

    }

    @Override
    public int getItemCount() {
        return tabs.length;
    }

}
