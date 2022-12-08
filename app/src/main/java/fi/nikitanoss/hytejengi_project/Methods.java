package fi.nikitanoss.hytejengi_project;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Methods {
    @Headers("X-Api-Key")
    @GET("exercises?muscle=biceps")
    Call<Model> getAllData();
}
