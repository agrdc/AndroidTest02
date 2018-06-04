package bilulo.androidtest02.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TwelveMonths implements Parcelable {
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

    public TwelveMonths() {
    }

    protected TwelveMonths(Parcel in) {
        this.fund = in.readDouble();
        this.CDI = in.readDouble();
    }

    public static final Parcelable.Creator<TwelveMonths> CREATOR = new Parcelable.Creator<TwelveMonths>() {
        @Override
        public TwelveMonths createFromParcel(Parcel source) {
            return new TwelveMonths(source);
        }

        @Override
        public TwelveMonths[] newArray(int size) {
            return new TwelveMonths[size];
        }
    };
}
