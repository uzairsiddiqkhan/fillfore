package com.example.fillfore.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fillfore.R;
import com.example.fillfore.adapters.blogBigAdapter;
import com.example.fillfore.databinding.FragmentGeneralBlogBinding;
import com.example.fillfore.models.blogBigModel;

import java.util.ArrayList;

public class general_blog_Fragment extends Fragment {
FragmentGeneralBlogBinding binding;
ArrayList<blogBigModel> model = new ArrayList<>();

    public general_blog_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentGeneralBlogBinding.inflate(getLayoutInflater());



        // General Screen

        model.add(new blogBigModel(R.drawable.backgroud_cover,0,"6 steps to improve your emotional intelligence and leadership ability in this era of technology....."));
        model.add(new blogBigModel(R.drawable.backgroud_cover,980,"6 steps to improve your emotional intelligence and leadership ability in this era of technology....."));
        model.add(new blogBigModel(R.drawable.backgroud_cover,220,"6 steps to improve your emotional intelligence and leadership ability in this era of technology....."));
        model.add(new blogBigModel(R.drawable.backgroud_cover,220,"6 steps to improve your emotional intelligence and leadership ability in this era of technology....."));



        blogBigAdapter adapter = new blogBigAdapter(model,getContext());
        binding.generalRecyclerView.setAdapter(adapter);
        binding.generalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();

    }
}