package bilulo.androidtest02.data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScreenInteractor {
        @GET("fund.json")
        Call<ScreenResponse> fetchScreen();
}
