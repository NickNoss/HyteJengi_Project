package fi.nikitanoss.hytejengi_project;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Methods {
    @Headers("X-Api-Key" + "cZ1PNGZBaaXQuQQSgUMrtw==XoNPNmfN8WLUTYlF")
    @GET("exercises?type=cardio")
    Call<Model> getAllData();
}
