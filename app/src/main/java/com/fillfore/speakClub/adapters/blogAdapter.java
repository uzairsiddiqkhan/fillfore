package com.fillfore.speakClub.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fillfore.R;
import com.fillfore.speakClub.activities.BlogDetailActivity;
import com.fillfore.speakClub.models.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class blogAdapter extends RecyclerView.Adapter<blogAdapter.viewHolder>  {

List<Item> model;
   List<Item> modelFull;
    Context context;

    public blogAdapter(List<Item> model, Context context) {
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
       final Item blog = model.get(position);

        holder.introBlog.setText(blog.getTitle());

        //After HTML PARSING: --> for text
        Document document = Jsoup.parse(blog.getContent());
        holder.detailBlog.setText(document.text());

        // for Images
        Elements elements =document.select("img");
        Glide.with(context).load(elements.get(0).attr("src")).into(holder.blogImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BlogDetailActivity.class);

                intent.putExtra("title",blog.getTitle());
                intent.putExtra("detail",blog.getContent());

                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return model.size();
    }




    public class viewHolder extends RecyclerView.ViewHolder {
        TextView introBlog;
        TextView detailBlog;
        ImageView blogImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            introBlog = itemView.findViewById(R.id.blog_introTxt);
            detailBlog =itemView.findViewById(R.id.blog_DetailText);
            blogImage = itemView.findViewById(R.id.blog_image);

        }
    }

//    @Override
//    public Filter getFilter() {
//        return generalFilter;
//    }
//
//    private Filter generalFilter =new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
//            List<Item> filteredModel =new ArrayList<>();
//            if(constraint ==null || constraint.length()==0) {
//                filteredModel.addAll(modelFull);
//            }
//            else   {
//                String searchQuery= constraint.toString().toLowerCase().trim();
//
//                Spannable span =new SpannableString(searchQuery);
//
//                for(Item item : modelFull){
//                    if(item.getTitle().toLowerCase().contains(searchQuery)){
//
//
//                        filteredModel.add(item);
//                    }
//                }
//
//
//                span.setSpan(new ForegroundColorSpan(Color.RED), 0, searchQuery
//                                .toString().length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//
//            }
//        FilterResults results =new FilterResults();
//            results.values = filteredModel;
//            return  results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//        model.clear();
//        Spannable span =new SpannableString(constraint);
//        model.addAll((List)results.values);
//        notifyDataSetChanged();
//
//        }
//    };
}
