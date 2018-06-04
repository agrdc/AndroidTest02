package bilulo.androidtest02.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bilulo.androidtest02.R;
import bilulo.androidtest02.data.Screen;
import bilulo.androidtest02.data.ScreenInteractor;
import bilulo.androidtest02.data.ScreenInteractorImpl;
import bilulo.androidtest02.presenter.ScreenPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InvestmentFragment extends Fragment implements InvestmentView {

    private ScreenPresenter mScreenPresenter;
    private static final String LOG_TAG = InvestmentFragment.class.getSimpleName();

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_fund_name) TextView tvFundName;
    @BindView(R.id.tv_what_is) TextView tvWhatIs;
    @BindView(R.id.tv_definition) TextView tvDefinition;
    @BindView(R.id.tv_risk_title) TextView tvRiskTitle;
    @BindView(R.id.tv_info_title) TextView tvInfoTitle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_investment, container,false);
        ButterKnife.bind(this,rootView);
        ScreenInteractor interactor = new ScreenInteractorImpl();
        mScreenPresenter = new ScreenPresenter(interactor);
        mScreenPresenter.bind(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mScreenPresenter.fetchScreenTask();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mScreenPresenter.unbind();
    }

    @Override
    public void updateUI(Screen screen) {
        Log.d(LOG_TAG,"teste "+screen.getDefinition());
        tvTitle.setText(screen.getTitle());
        tvFundName.setText(screen.getFundName());
        tvWhatIs.setText(screen.getWhatIs());
        tvDefinition.setText(screen.getDefinition());
        tvRiskTitle.setText(screen.getRiskTitle());
        tvInfoTitle.setText(screen.getInfoTitle());
    }
}
