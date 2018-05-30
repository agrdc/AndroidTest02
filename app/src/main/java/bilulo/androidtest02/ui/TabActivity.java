package bilulo.androidtest02.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import bilulo.androidtest02.R;
import bilulo.androidtest02.adapter.TabAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends FragmentActivity {

    private static final String LOG_TAG = TabActivity.class.getSimpleName();
    @BindView(R.id.vp_content) ViewPager viewPager;
    @BindView(R.id.btn_contact_tab) Button buttonContactTab;
    @BindView(R.id.btn_investment_tab) Button buttonInvestmentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        hideActionBar();
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(LOG_TAG,"position =" +position);
                swapTabColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        buttonContactTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        buttonInvestmentTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
    }

    public void swapTabColor(int p) {
        if (p==0) {
            buttonInvestmentTab.setBackgroundColor(ContextCompat.getColor(this,R.color.colorDarkerRed));
            buttonContactTab.setBackgroundColor(ContextCompat.getColor(this,R.color.colorRed));
        } else if (p==1) {
            buttonInvestmentTab.setBackgroundColor(ContextCompat.getColor(this,R.color.colorRed));
            buttonContactTab.setBackgroundColor(ContextCompat.getColor(this,R.color.colorDarkerRed));
        }
    }

    public void hideActionBar() {
        if (getActionBar() != null)
            getActionBar().hide();
    }
}
