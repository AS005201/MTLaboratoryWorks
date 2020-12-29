package com.jenya.lab23.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jenya.lab23.pojo.MovieDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class NetworkHelper {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "7a44757fab7bde67a7e68a75847625e4";
    public static final String IMG_BASE_URL = "https://image.tmdb.org/t/p/w342/";
    public static final String IMG_BIG_SIZE_URL = "https://image.tmdb.org/t/p/w780/";

    public interface MovieListLoadCallback {
        void onLoadFail(Call call);

        void onLoadSuccess(Response response, List<MovieDetails> movieModels);
    }

    public interface MovieDetailsLoadCallback {
        void onLoadFail(Call call);

        void onLoadSuccess(Response response, MovieDetails movieDetails);
    }

    public static boolean isInternetUnavailable(Context context) {
        final ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return true;
        }
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo == null || !networkInfo.isConnected();
    }
}