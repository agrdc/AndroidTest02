package bilulo.androidtest02.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CellResponse implements Parcelable {
    private ArrayList<Cell> cells;

    public CellResponse() {
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

    protected CellResponse(Parcel in) {
        this.cells = new ArrayList<Cell>();
        in.readList(this.cells, Cell.class.getClassLoader());
    }

    public static final Parcelable.Creator<CellResponse> CREATOR = new Parcelable.Creator<CellResponse>() {
        @Override
        public CellResponse createFromParcel(Parcel source) {
            return new CellResponse(source);
        }

        @Override
        public CellResponse[] newArray(int size) {
            return new CellResponse[size];
        }
    };
}
