package bilulo.androidtest02.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import bilulo.androidtest02.R;
import bilulo.androidtest02.data.Cell;
import bilulo.androidtest02.data.CellResponse;
import bilulo.androidtest02.data.DataInteractor;
import bilulo.androidtest02.data.DataInteractorImpl;
import bilulo.androidtest02.presenter.DataPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsFragment extends Fragment implements ContactsView {

    private int[] mHiddenTvIds;
    private int[] mHiddenEtIds;

    private DataPresenter mDataPresenter;

    private static final String LOG_TAG = ContactsFragment.class.getSimpleName();

    @BindView (R.id.cl_contact)
    ConstraintLayout constraintLayout;

    @BindView (R.id.ll_form)
    LinearLayout linearLayout;

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
    public void updateUI(CellResponse cellResponse) {
        ArrayList<Cell> cells = cellResponse.getCells();
        Context context = getContext();
        mHiddenTvIds = new int[cells.size()];
        mHiddenEtIds = new int[cells.size()];
        int y=0;
        for (int x=0; x<cells.size(); x++) {
            Cell c = cells.get(x);
            if (c.isRequired()) {
                int type = c.getType();
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                int topSpacing = (int) c.getTopSpacing();

                // sorry, these different top spacings are killing me!
                if (topSpacing!=35)
                    topSpacing = 35;

                params.setMargins(0,topSpacing,0,0);
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
                        textView.setLayoutParams(params);
                        editText.setId(ViewStub.generateViewId());
                        editText.setLayoutParams(params);
                        if (c.isHidden()) {
                            mHiddenTvIds[y]=textView.getId();
                            mHiddenEtIds[y]=editText.getId();
                            y++;
                            textView.setVisibility(View.GONE);
                            editText.setVisibility(View.GONE);
                        }
                        linearLayout.addView(textView);
                        linearLayout.addView(editText);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        CheckBox checkBox = new CheckBox(context);
                        checkBox.setId(ViewStub.generateViewId());
                        checkBox.setText(c.getMessage());
                        checkBox.setLayoutParams(params);
                        if (c.isHidden()) {
                            checkBox.setVisibility(View.GONE);
                        }
                        linearLayout.addView(checkBox);
                        break;
                    case 5:
                        Button button = new Button(context);
                        button.setId(ViewStub.generateViewId());
                        button.setLayoutParams(params);
                        button.setText(c.getMessage());
                        if (c.isHidden()) {
                            button.setVisibility(View.GONE);
                        }
                        button.setBackgroundResource(R.drawable.btn_background_round);
                        linearLayout.addView(button);
                        break;
                }
            }
        }
    }
}
