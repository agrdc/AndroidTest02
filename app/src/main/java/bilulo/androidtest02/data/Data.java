package bilulo.androidtest02.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Data implements Parcelable {
    private ArrayList<Cell> cells;

    public Data() {
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.cells);
    }

    protected Data(Parcel in) {
        this.cells = new ArrayList<Cell>();
        in.readList(this.cells, Cell.class.getClassLoader());
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
