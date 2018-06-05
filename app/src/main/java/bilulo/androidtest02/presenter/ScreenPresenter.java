package bilulo.androidtest02.presenter;

import bilulo.androidtest02.data.Screen;
import bilulo.androidtest02.data.ScreenResponse;
import bilulo.androidtest02.data.ScreenInteractor;
import bilulo.androidtest02.ui.InvestmentView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenPresenter {
    InvestmentView investmentView;
    private ScreenInteractor screenInteractor;
    private ScreenResponse mScreenResponse;
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
        screenInteractor.fetchScreen().enqueue(new Callback<ScreenResponse>() {
            @Override
            public void onResponse(Call<ScreenResponse> call, Response<ScreenResponse> response) {
                if (investmentView!=null)
                mScreenResponse = response.body();
                Screen screen = mScreenResponse.getScreen();
                investmentView.updateUI(screen);
            }

            @Override
            public void onFailure(Call<ScreenResponse> call, Throwable t) {

            }
        });
    }
}
