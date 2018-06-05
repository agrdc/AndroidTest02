package bilulo.androidtest02.data;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataInteractorImpl implements DataInteractor {

    DataInteractor dataInteractor;
    OkHttpClient httpClient = new OkHttpClient.Builder().build();

    public DataInteractorImpl() {
        dataInteractor = new Retrofit.Builder()
                .baseUrl("https://floating-mountain-50292.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(httpClient)
                .build().create(DataInteractor.class);
    }

    @Override
    public Call<CellResponse> fetchCells() {
        return dataInteractor.fetchCells();
    }
}
