package com.fillfore.speakClub.models;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class BloggerAPI {
    public static final String APIKEY="AIzaSyCDF48lDNi8PE3zgtwkC-qKFUthQ2z0htE";
    public static final String URL="https://www.googleapis.com/blogger/v3/blogs/3116895222860721753/posts/";

    public static PostService postService = null;

    public static PostService getPostService (){
        if(postService==null){
            Retrofit retrofit =new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService=retrofit.create(PostService.class);

        }
        return postService;
    }

   public interface PostService{
       @GET
       Call<BlogData>getBlogData(@Url String URL );
   }
}
