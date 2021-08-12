package com.nipun.beautyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.nipun.beautyapp.apiClient.ApiClientJava;
import com.nipun.beautyapp.model.ArticleItem;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallBackActivity extends AppCompatActivity {
    private ViewPagerVideoAdapter dataAdapter;
    private ArrayList<ArticleItem> carModels = new ArrayList<>();
    private ViewPager2 viewPager2;
    private AppBarLayout appbar;
    private ImageView ivImage;
    private CoordinatorLayout main_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.videoViewPager);

        parseJson();

        ivImage = findViewById(R.id.refresh);
        main_content = findViewById(R.id.main_content);
        appbar = findViewById(R.id.appbar);

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJson();
                Intent intent = new Intent(CallBackActivity.this,LoadingActivity.class);
                startActivity(intent);
            }
        });
        main_content.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (appbar.getVisibility() == View.VISIBLE) {
                        appbar.setVisibility(View.GONE);
                    } else {
                        appbar.setVisibility(View.VISIBLE);
                    }
                    return true;
                } else return false;
            }
        });
    }

    private void parseJson() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo9977805.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiClientJava request = retrofit.create(ApiClientJava.class);
        Call<List<ArticleItem>> call1 = request.getData();
        call1.enqueue(new Callback<List<ArticleItem>>() {
            @Override
            public void onResponse(Call<List<ArticleItem>> call, Response<List<ArticleItem>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    carModels = new ArrayList<>(response.body());
                    dataAdapter = new ViewPagerVideoAdapter(carModels, CallBackActivity.this);
                    viewPager2.setAdapter(dataAdapter);
                    dataAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ArticleItem>> call, Throwable t) {

                Toast.makeText(CallBackActivity.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
            }

        });
    }

}