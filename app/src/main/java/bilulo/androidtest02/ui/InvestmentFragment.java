package bilulo.androidtest02.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import bilulo.androidtest02.R;
import bilulo.androidtest02.data.DownInfo;
import bilulo.androidtest02.data.Info;
import bilulo.androidtest02.data.Month;
import bilulo.androidtest02.data.MoreInfo;
import bilulo.androidtest02.data.Screen;
import bilulo.androidtest02.data.ScreenInteractor;
import bilulo.androidtest02.data.ScreenInteractorImpl;
import bilulo.androidtest02.data.TwelveMonths;
import bilulo.androidtest02.data.Year;
import bilulo.androidtest02.presenter.ScreenPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InvestmentFragment extends Fragment implements InvestmentView {

    private static final String LOG_TAG = InvestmentFragment.class.getSimpleName();
    private static final String key_bundle = LOG_TAG+"Key";

    private ScreenPresenter mScreenPresenter;
    private Screen mScreen;

    @BindView(R.id.sv_investment) ScrollView svInvestment;
    @BindView(R.id.pb_loading) ProgressBar pbLoading;

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_fund_name) TextView tvFundName;
    @BindView(R.id.tv_what_is) TextView tvWhatIs;
    @BindView(R.id.tv_definition) TextView tvDefinition;
    @BindView(R.id.tv_risk_title) TextView tvRiskTitle;
    @BindView(R.id.tv_info_title) TextView tvInfoTitle;

    @BindView(R.id.tv_fund_value_month) TextView tvFundValueMonth;
    @BindView(R.id.tv_cdi_value_month) TextView tvCDIValueMonth;
    @BindView(R.id.tv_fund_value_year) TextView tvFundValueYear;
    @BindView(R.id.tv_cdi_value_year) TextView tvCDIValueYear;
    @BindView(R.id.tv_fund_value_twelve_months) TextView tvFundValueTwelveMonths;
    @BindView(R.id.tv_cdi_value_twelve_months) TextView tvCDIValueTwelveMonths;

    @BindView(R.id.tv_info_name_01) TextView tvInfoName01;
    @BindView(R.id.tv_info_data_01) TextView tvInfoData01;
    @BindView(R.id.tv_info_name_02) TextView tvInfoName02;
    @BindView(R.id.tv_info_data_02) TextView tvInfoData02;
    @BindView(R.id.tv_info_name_03) TextView tvInfoName03;
    @BindView(R.id.tv_info_data_03) TextView tvInfoData03;
    @BindView(R.id.tv_info_name_04) TextView tvInfoName04;
    @BindView(R.id.tv_info_data_04) TextView tvInfoData04;
    @BindView(R.id.tv_info_name_05) TextView tvInfoName05;
    @BindView(R.id.tv_info_data_05) TextView tvInfoData05;
    @BindView(R.id.tv_info_name_06) TextView tvInfoName06;
    @BindView(R.id.tv_info_data_06) TextView tvInfoData06;
    @BindView(R.id.tv_info_name_07) TextView tvInfoName07;
    @BindView(R.id.tv_info_data_07) TextView tvInfoData07;

    @BindView(R.id.tv_downinfo_name_01) TextView tvDownInfoName01;
    @BindView(R.id.tv_downinfo_name_02) TextView tvDownInfoName02;
    @BindView(R.id.tv_downinfo_name_03) TextView tvDownInfoName03;
    @BindView(R.id.tv_downinfo_name_04) TextView tvDownInfoName04;
    @BindView(R.id.tv_downinfo_name_05) TextView tvDownInfoName05;

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
        if (savedInstanceState!=null && savedInstanceState.getParcelable(key_bundle)!=null) {
            mScreen = savedInstanceState.getParcelable(key_bundle);
            updateUI(mScreen);
        } else
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
        if (screen!=null) {
            mScreen = screen;
            svInvestment.setVisibility(View.VISIBLE);
            pbLoading.setVisibility(View.INVISIBLE);
            MoreInfo moreInfo = screen.getMoreInfo();
            Month month = moreInfo.getMonth();
            Year year = moreInfo.getYear();
            TwelveMonths twelveMonths = moreInfo.getTwelveMonths();
            ArrayList<Info> infoList = screen.getInfo();
            ArrayList<DownInfo> downInfoList = screen.getDownInfo();
            tvTitle.setText(screen.getTitle());
            tvFundName.setText(screen.getFundName());
            tvWhatIs.setText(screen.getWhatIs());
            tvDefinition.setText(screen.getDefinition());
            tvRiskTitle.setText(screen.getRiskTitle());
            tvInfoTitle.setText(screen.getInfoTitle());
            tvFundValueMonth.setText(String.valueOf(month.getFund()));
            tvCDIValueMonth.setText(String.valueOf(month.getCDI()));
            tvFundValueYear.setText(String.valueOf(year.getFund()));
            tvCDIValueYear.setText(String.valueOf(year.getCDI()));
            tvFundValueTwelveMonths.setText(String.valueOf(twelveMonths.getFund()));
            tvCDIValueTwelveMonths.setText(String.valueOf(twelveMonths.getCDI()));
            tvInfoData01.setText(infoList.get(0).getData());
            tvInfoName01.setText(infoList.get(0).getName());
            tvInfoData02.setText(infoList.get(1).getData());
            tvInfoName02.setText(infoList.get(1).getName());
            tvInfoData03.setText(infoList.get(2).getData());
            tvInfoName03.setText(infoList.get(2).getName());
            tvInfoData04.setText(infoList.get(3).getData());
            tvInfoName04.setText(infoList.get(3).getName());
            tvInfoData05.setText(infoList.get(4).getData());
            tvInfoName05.setText(infoList.get(4).getName());
            tvInfoData06.setText(infoList.get(5).getData());
            tvInfoName06.setText(infoList.get(5).getName());
            tvInfoData07.setText(infoList.get(6).getData());
            tvInfoName07.setText(infoList.get(6).getName());
            tvDownInfoName01.setText(downInfoList.get(0).getName());
            tvDownInfoName02.setText(downInfoList.get(1).getName());
            tvDownInfoName03.setText(downInfoList.get(2).getName());
            tvDownInfoName04.setText(downInfoList.get(3).getName());
            tvDownInfoName05.setText(downInfoList.get(4).getName());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mScreen!=null)
        outState.putParcelable(key_bundle,mScreen);
        super.onSaveInstanceState(outState);
    }
}
