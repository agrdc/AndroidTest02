package bilulo.androidtest02.data;

import bilulo.androidtest02.data.Screen;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ScreenInteractor {
        @GET("cells.json")
        Call<Screen> fetchScreen();
}
