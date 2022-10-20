package com.example.fillfore.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fillfore.R;
import com.example.fillfore.models.blogBigModel;

import java.util.ArrayList;
import java.util.List;

public class blogBigAdapter extends RecyclerView.Adapter<blogBigAdapter.viewHolder> implements Filterable {

   private List<blogBigModel> model;
    private ArrayList<blogBigModel> modelFull;
    Context context;

    public blogBigAdapter(ArrayList<blogBigModel> model, Context context) {
        this.model = model;
        modelFull =new ArrayList<>(model);
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

    @Override
    public Filter getFilter() {
        return generalFilter;
    }

    private Filter generalFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<blogBigModel> filteredModel =new ArrayList<>();
            if(constraint ==null || constraint.length()==0) {
                filteredModel.addAll(modelFull);
            }
            else   {
                String searchQuery= constraint.toString().toLowerCase().trim();

                Spannable span =new SpannableString(searchQuery);

                for(blogBigModel item : modelFull){
                    if(item.getBlogIntro().toLowerCase().contains(searchQuery)){

                        Spannable WordtoSpan = new SpannableString("partial colored text");
                        WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 2, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


                        filteredModel.add(item);
                    }
                }


                span.setSpan(new ForegroundColorSpan(Color.RED), 0, searchQuery
                                .toString().length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


            }
        FilterResults results =new FilterResults();
            results.values = filteredModel;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
        model.clear();
        Spannable span =new SpannableString(constraint);
        model.addAll((List)results.values);
        notifyDataSetChanged();

        }
    };
}
