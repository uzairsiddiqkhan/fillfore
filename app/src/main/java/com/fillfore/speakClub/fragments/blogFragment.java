package com.fillfore.speakClub.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AbsListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fillfore.R;
import com.example.fillfore.databinding.FragmentBlogBinding;
import com.fillfore.speakClub.adapters.blogAdapter;
import com.fillfore.speakClub.models.BlogData;
import com.fillfore.speakClub.models.BloggerAPI;
import com.fillfore.speakClub.models.Item;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class blogFragment extends HomeFragment {

    FragmentBlogBinding binding;
    blogAdapter adapter;
    Toolbar toolbar;
    TabLayout tabLayout;
    List<Item> blogs = new ArrayList<>();
    Boolean isScrolling = false;
    LinearLayoutManager manager;
    String token = "";
    int totalItem, currentItem, ScrollOutItem;


    public blogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBlogBinding.inflate(getLayoutInflater());

        manager = new LinearLayoutManager(getContext());
        adapter = new blogAdapter(blogs, getContext());
        binding.generalRecyclerView.setLayoutManager(manager);
        binding.generalRecyclerView.setAdapter(adapter);

        binding.generalRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItem =manager.getChildCount();
                totalItem =manager.getItemCount();
                ScrollOutItem =manager.findLastVisibleItemPosition();

                if(isScrolling && (currentItem +ScrollOutItem) == totalItem ){
                    //fetch Data
                    isScrolling =false;
                    getBlogData();

                }

            }
        });


        tabLayout = getParentFragment().getView().findViewById(R.id.tabLayout);
        toolbar = getParentFragment().getView().findViewById(R.id.homeToolbar);


        toolbarFunction();


        getBlogData();
        return binding.getRoot();

    }


    public void getBlogData() {
        String URL = BloggerAPI.URL +"?key=" +BloggerAPI.APIKEY;
        if(token != ""){
            URL = URL + "&pageToken=" +token;
        }
       if(token == null ){
           return;
       }
        binding.shimmer.startShimmer();
        Call<BlogData> blogData = BloggerAPI.getPostService().getBlogData(URL);
        blogData.enqueue(new Callback<BlogData>() {
            @Override

            public void onResponse(Call<BlogData> call, Response<BlogData> response) {

                BlogData blogData = response.body();
                token=blogData.getNextPageToken();
                blogs.addAll(blogData.getItems());
                adapter.notifyDataSetChanged();



                binding.shimmer.setVisibility(View.GONE);
                binding.shimmer.stopShimmer();
                binding.generalRecyclerView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<BlogData> call, Throwable t) {
            }

        });
    }


    public void toolbarFunction() {
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
//                                    adapter.getFilter().filter(newText);
                                    return false;
                                }
                            });


                    }
                }

                return true;
            }
        });
    }


}