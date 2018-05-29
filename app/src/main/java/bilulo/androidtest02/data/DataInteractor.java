package bilulo.androidtest02.data;

import bilulo.androidtest02.data.Data;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInteractor {
    @GET("cells.json")
    Call<Data> fetchCells();
}
