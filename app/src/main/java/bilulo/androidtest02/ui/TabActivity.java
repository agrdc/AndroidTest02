package bilulo.androidtest02.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import bilulo.androidtest02.R;
import bilulo.androidtest02.adapter.TabAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends FragmentActivity {

    @BindView(R.id.vp_content) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        ButterKnife.bind(this);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        hideActionBar();

    }

    public void hideActionBar() {
        if (getActionBar() != null)
            getActionBar().hide();
    }
}
