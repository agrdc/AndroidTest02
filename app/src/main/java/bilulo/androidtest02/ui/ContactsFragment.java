package bilulo.androidtest02.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import bilulo.androidtest02.R;
import bilulo.androidtest02.data.Cell;
import bilulo.androidtest02.data.Data;
import bilulo.androidtest02.data.DataInteractor;
import bilulo.androidtest02.data.DataInteractorImpl;
import bilulo.androidtest02.presenter.DataPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsFragment extends Fragment implements ContactsView {

    private DataPresenter mDataPresenter;
    @BindView (R.id.cl_contact)
    ConstraintLayout constraintLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container,false);
        ButterKnife.bind(this,rootView);
        DataInteractor interactor = new DataInteractorImpl();
        mDataPresenter = new DataPresenter(interactor);
        mDataPresenter.bind(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDataPresenter.fetchDataTask();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mDataPresenter.unbind();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void updateUI(Data data) {
        ArrayList<Cell> cells = data.getCells();
        Context context = getContext();
        ConstraintSet constraintSet = new ConstraintSet();
        for (int x=0; x<cells.size(); x++) {
            Cell c = cells.get(x);
            if (c.isRequired()) {
                int type = c.getType();
                switch (type) {
                    case 1:
                        TextView textView = new TextView(context);
                        EditText editText = new EditText(context);
                        String typefield = String.valueOf(c.getTypefield());
                        if (typefield.equals("1")) {
                            editText.setInputType(InputType.TYPE_CLASS_TEXT);
                        } else if (typefield.equals("3")) {
                            editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                        } else if (typefield.equals("telnumber")) {
                            editText.setInputType(InputType.TYPE_CLASS_PHONE);
                        }
                        textView.setText(c.getMessage());
                        textView.setId(ViewStub.generateViewId());
                        constraintLayout.addView(textView,constraintLayout.getChildCount());
                        constraintSet.clone(constraintLayout);
                        constraintSet.connect(textView.getId(),ConstraintSet.START, R.id.guideline005, ConstraintSet.START);
                        constraintSet.connect(textView.getId(),ConstraintSet.TOP,R.id.tv_contact,ConstraintSet.BOTTOM ,10);
                        constraintSet.applyTo(constraintLayout);
                    case 2:

                }
            }
        }
    }
}
