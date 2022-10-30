package com.fillfore.speakClub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fillfore.R;
import com.fillfore.speakClub.models.callModel;

import java.util.ArrayList;

public class callAdapter extends RecyclerView.Adapter<callAdapter.viewHolder> {

    public callAdapter(ArrayList<callModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<callModel> list;
    Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_call_fragment, parent, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        callModel model = list.get(position);
        holder.onlineName.setText(model.getUserName());
        holder.rating.setText("Rating: " + model.getRating());
        holder.profileImg.setImageResource(model.getImage());
        holder.interest1.setText(model.getInterest1()+",");
        holder.interest2.setText(model.getInterest2()+",");
        holder.interest3.setText(model.getInterest3()+",");

    }

    @Override
    public int getItemCount() {

        return list.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView profileImg;
        TextView interest1, interest2, interest3, onlineName, rating;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.profile_image);
            interest1 = itemView.findViewById(R.id.interest1);
            interest2 = itemView.findViewById(R.id.interest2);
            interest3 = itemView.findViewById(R.id.interest3);
            rating = itemView.findViewById(R.id.rating);
            onlineName = itemView.findViewById(R.id.onlineName);

        }
    }
}
