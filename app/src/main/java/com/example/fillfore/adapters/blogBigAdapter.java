package com.example.fillfore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fillfore.R;
import com.example.fillfore.models.blogBigModel;

import java.util.ArrayList;

public class blogBigAdapter extends RecyclerView.Adapter<blogBigAdapter.viewHolder> {

    ArrayList<blogBigModel> model;
    Context context;

    public blogBigAdapter(ArrayList<blogBigModel> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.template_blog_big, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        blogBigModel blog = model.get(position);
        holder.blogImage.setImageResource(blog.getBlogImage());
        holder.introBlog.setText(blog.getBlogIntro());


    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView introBlog;
        TextView likes;
        ImageView blogImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            introBlog = itemView.findViewById(R.id.blog_introTxt);


            blogImage = itemView.findViewById(R.id.blog_image);

        }
    }
}
