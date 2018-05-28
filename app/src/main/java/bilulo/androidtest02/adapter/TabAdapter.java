package bilulo.androidtest02.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bilulo.androidtest02.ui.ContactsFragment;
import bilulo.androidtest02.ui.InvestmentFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_VIEWS = 2;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InvestmentFragment();
            case 1:
                return new ContactsFragment();
            default:
                return new InvestmentFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_VIEWS;
    }
}
