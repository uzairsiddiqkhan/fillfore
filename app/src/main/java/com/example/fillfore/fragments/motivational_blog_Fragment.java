package com.example.fillfore.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fillfore.R;

public class motivational_blog_Fragment extends Fragment {


    public motivational_blog_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_motivational_blog_, container, false);
    }
}

// for menu addition in toolbar
//        binding.homeToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//
//                switch (item.getItemId()) {
//
//                    case R.id.ic_home_search:
//
//
//                        if (binding.tabLayout.getSelectedTabPosition() == 0) {
//

//                            general_blog_Fragment fragment =new general_blog_Fragment();
//                            fragment.searhing();
//
////                            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////                                @Override
////                                public boolean onQueryTextSubmit(String query) {
////
////                                    Toast.makeText(getContext(), "Text submitted", Toast.LENGTH_SHORT).show();
////                                    return false;
////
////                                }
////
////                                @Override
////                                public boolean onQueryTextChange(String newText) {
////                                    Toast.makeText(getContext(), "hi amd ii", Toast.LENGTH_SHORT).show();
////                                    general_blog_Fragment fragment = new general_blog_Fragment();
////
////                                    return true;
////                                }
////                            });
//
//
//                        } else if (binding.tabLayout.getSelectedTabPosition() == 1) {
//                            Toast.makeText(getContext(), "3213870120", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getContext(), "@#$%^&**", Toast.LENGTH_LONG).show();
//                        }
//
//
//                        break;
//                    case R.id.ic_home_notification:
//
//                        Toast.makeText(getContext(), "notification clicked", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//
//
//            }
//        });