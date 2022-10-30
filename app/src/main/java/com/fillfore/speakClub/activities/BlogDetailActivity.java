package com.fillfore.speakClub.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.fillfore.databinding.ActivityBlogDetailBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BlogDetailActivity extends AppCompatActivity {

    ActivityBlogDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlogDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String title = getIntent().getStringExtra("title");
        String detail = getIntent().getStringExtra("detail");


        // blog content parsing:
        Document document = Jsoup.parse(detail);
        document.outputSettings().prettyPrint(false);


        document.select("br").after("\\n\\n").trimToSize();
        document.select("p").after("\\n\\n").trimToSize();
        String str = document.text().replaceAll("\\\\n", "\n").trim();
        binding.blogDetail.setText(str);


        binding.blogTitle.setText(title);

        Elements elements = document.select("img");
        Glide.with(this).load(elements.get(0).attr("src")).into(binding.blogImage);


    }
}


// binding.webView.setVisibility(View.GONE);
//        binding.webView.getSettings().setJavaScriptEnabled(true);
//        binding.webView.setWebChromeClient(new WebChromeClient());
//        binding.webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                binding.progressBar.setVisibility(View.GONE);
//                binding.webView.setVisibility(View.VISIBLE);
//
//            }
//        });
//        binding.webView.loadUrl(getIntent().getStringExtra("url"));
//
