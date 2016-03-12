package com.androidexample.path.Retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.androidexample.path.R;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;


public class Main extends Activity {

    private class Gist
    {
        String id;

        @Override
        public String toString() {
            String output=id;
            return output;
        }
    }

    private interface GitHubService
    {
        @GET("/gists/public")
        List<Gist> getpublicgists();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //renamed remember
        //remember every single class in retrofit is a class

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GitHubService service = adapter.create(GitHubService.class);//byheart

       Log.d("sample",service.getpublicgists().get(0).toString());



    }
}
