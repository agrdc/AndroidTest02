package bilulo.androidtest02.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Year implements Parcelable {
    private double fund;
    private double CDI;

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public double getCDI() {
        return CDI;
    }

    public void setCDI(double CDI) {
        this.CDI = CDI;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.fund);
        dest.writeDouble(this.CDI);
    }

    public Year() {
    }

    protected Year(Parcel in) {
        this.fund = in.readDouble();
        this.CDI = in.readDouble();
    }

    public static final Parcelable.Creator<Year> CREATOR = new Parcelable.Creator<Year>() {
        @Override
        public Year createFromParcel(Parcel source) {
            return new Year(source);
        }

        @Override
        public Year[] newArray(int size) {
            return new Year[size];
        }
    };
}
