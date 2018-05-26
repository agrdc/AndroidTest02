package bilulo.androidtest02.presenter;

import com.google.gson.GsonBuilder;

import bilulo.androidtest02.data.Screen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScreenInteractorImpl implements ScreenInteractor {

    ScreenInteractor screenInteractor;
    OkHttpClient httpClient = new OkHttpClient.Builder().build();

    public ScreenInteractorImpl() {
        screenInteractor = new Retrofit.Builder()
                .baseUrl("https://floating-mountain-50292.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(httpClient)
                .build().create(ScreenInteractor.class);
    }

    @Override
    public Call<Screen> fetchScreen() {
        return screenInteractor.fetchScreen();
    }
}
