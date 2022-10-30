package com.fillfore.speakClub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fillfore.R;
import com.fillfore.speakClub.adapters.callAdapter;
import com.example.fillfore.databinding.FragmentCallBinding;
import com.fillfore.speakClub.models.callModel;

import java.util.ArrayList;

public class callFragement extends Fragment {

    FragmentCallBinding binding;
    callAdapter adapter;
    ArrayList<callModel> model;

    public callFragement() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentCallBinding.inflate(getLayoutInflater());



        model=new ArrayList<>();
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));
        model.add(new callModel(R.drawable.profile_img,"Uzair Khan","speaking English","Teaching","coding","4.4"));

        adapter= new callAdapter(model,getContext());
        binding.callRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.callRecyclerView.setAdapter(adapter);







       return binding.getRoot();
    }
}