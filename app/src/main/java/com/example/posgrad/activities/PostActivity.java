package com.example.posgrad.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.posgrad.R;
import com.example.posgrad.entidades.Post;
import com.example.posgrad.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    private void consultaPost() {
        Post post = new Post(1,"Novo post","texto do post" );
        RetrofitService.getServico().createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                ((TextView)findViewById(R.id.postView)).setText("Código de retorno: "+response.code()+"\nID do novo registro: "+response.body().getId());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
