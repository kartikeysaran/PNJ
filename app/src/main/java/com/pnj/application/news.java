package com.pnj.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.pnj.application.Model.Adapter;
import com.pnj.application.Model.ApiClient;
import com.pnj.application.Model.Articles;
import com.pnj.application.Model.Headlines;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class news extends AppCompatActivity {
    RecyclerView recyclerView;
    final String API_KEY = "b55877cd57d6465a80319d4f2b51719e";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String country = getCountry();
        retrieveJson(country,API_KEY);

    }
    public void retrieveJson(String country,String apiKey){
        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines(country,apiKey);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if(response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(news.this,articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Toast.makeText(news.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();



    }
}
