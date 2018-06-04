package bilulo.androidtest02.presenter;

import android.util.Log;

import com.google.gson.Gson;

import bilulo.androidtest02.data.Data;
import bilulo.androidtest02.data.DataInteractor;
import bilulo.androidtest02.ui.ContactsView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPresenter {

    ContactsView contactsView;
    private DataInteractor dataInteractor;
    private Data mData;

    public DataPresenter(DataInteractor interactor) {
        dataInteractor = interactor;
    }

    public void bind(ContactsView view) {
        contactsView = view;
    }

    public void unbind() {
        contactsView = null;
    }

    public void fetchDataTask() {
        dataInteractor.fetchCells().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (contactsView!=null) {
                    Log.w("JSON2 =",new Gson().toJson(response));
                    mData = response.body();
                    contactsView.updateUI(mData);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
