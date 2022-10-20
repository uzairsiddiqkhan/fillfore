package com.example.fillfore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fillfore.R;
import com.example.fillfore.adapters.blogBigAdapter;
import com.example.fillfore.databinding.FragmentGeneralBlogBinding;
import com.example.fillfore.models.blogBigModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class general_blog_Fragment extends HomeFragment {
    FragmentGeneralBlogBinding binding;
    ArrayList<blogBigModel> model;
    blogBigAdapter adapter;
    Toolbar toolbar;
    TabLayout tabLayout;
    AppCompatActivity activity;
    SearchView searchView;

    public general_blog_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeneralBlogBinding.inflate(getLayoutInflater());


        model = new ArrayList<>();
        model.add(new blogBigModel(R.drawable.backgroud_cover, 10, "6 steps to improve your emotional intelligence and leadership ability in this era of technology....."));
        model.add(new blogBigModel(R.drawable.backgroud_cover, 980, "Today Why Every Person want to learn English....."));
        model.add(new blogBigModel(R.drawable.backgroud_cover, 220, "The green card help me to came out of serious trouble. Know how?...."));
        model.add(new blogBigModel(R.drawable.backgroud_cover, 220, "Training of mind is the most difficult job in human life....."));

        adapter = new blogBigAdapter(model, getContext());
        binding.generalRecyclerView.setAdapter(adapter);
        binding.generalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tabLayout = getParentFragment().getView().findViewById(R.id.tabLayout);
        toolbar = getParentFragment().getView().findViewById(R.id.homeToolbar);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (tabLayout.getSelectedTabPosition() == 0) {

                    switch (item.getItemId()) {

                        case R.id.ic_home_search:
                            SearchView searchView = (SearchView) item.getActionView();
                            searchView.setQueryHint("Search....");
                            searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

                            searchView.setBackground(getResources().getDrawable(R.drawable.searchview_bg));

                            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                @Override
                                public boolean onQueryTextSubmit(String query) {
                                    return false;
                                }

                                @Override
                                public boolean onQueryTextChange(String newText) {
                                    adapter.getFilter().filter(newText);
                                    return false;
                                }
                            });


                    }
                }


                return true;
            }
        });

        return binding.getRoot();

    }


    public void fragmentGeneral(blogBigAdapter adapter, ArrayList<blogBigModel> model, RecyclerView generalRecyclerView) {


    }


    public void searching() {

    }

}