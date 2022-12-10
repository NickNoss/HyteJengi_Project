package fi.nikitanoss.hytejengi_project;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Methods {
    @Headers("X-Api-Key" + "PNaMlfXN+zoH+59tQrauWw==TY47R7TCS4r7Wmrr")
    @GET("exercises?muscle=biceps")
    Call<Model> getAllData();
}
