package bilulo.androidtest02.ui;

import android.app.Activity;
import android.os.Bundle;

import bilulo.androidtest02.R;

public class TabActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(R.layout.activity_tab);
    }

    public void hideActionBar() {
        if (getActionBar() != null)
            getActionBar().hide();
    }
}
