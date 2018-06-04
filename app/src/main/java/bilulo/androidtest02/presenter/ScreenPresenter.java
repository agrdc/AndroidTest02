package bilulo.androidtest02.presenter;

import android.util.Log;

import com.google.gson.Gson;

import bilulo.androidtest02.data.Screen;
import bilulo.androidtest02.data.ScreenInteractor;
import bilulo.androidtest02.ui.InvestmentView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenPresenter {
    InvestmentView investmentView;
    private ScreenInteractor screenInteractor;
    private Screen mScreen;
    private static final String LOG_TAG = ScreenPresenter.class.getSimpleName();

    public ScreenPresenter(ScreenInteractor interactor) {
        screenInteractor = interactor;
    }

    public void bind(InvestmentView view) {
        investmentView = view;
    }

    public void unbind() {
        investmentView = null;
    }

    public void fetchScreenTask() {
        screenInteractor.fetchScreen().enqueue(new Callback<Screen>() {
            @Override
            public void onResponse(Call<Screen> call, Response<Screen> response) {
                if (investmentView!=null)
                mScreen = response.body();
                Log.w("JSON =",new Gson().toJson(response));
                investmentView.updateUI(mScreen);
            }

            @Override
            public void onFailure(Call<Screen> call, Throwable t) {

            }
        });
    }
}
