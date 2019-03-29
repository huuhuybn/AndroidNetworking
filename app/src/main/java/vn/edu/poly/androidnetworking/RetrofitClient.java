package vn.edu.poly.androidnetworking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static GitHubService gitHubService;


    public static GitHubService getInstance() {

        if (gitHubService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.tapetee.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            gitHubService = retrofit.create(GitHubService.class);
        }

        return gitHubService;

    }
}
