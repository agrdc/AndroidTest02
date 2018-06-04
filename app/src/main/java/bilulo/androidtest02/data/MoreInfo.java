package bilulo.androidtest02.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MoreInfo implements Parcelable {
    private Month month;
    private Year year;
    @SerializedName("12months")
    private TwelveMonths twelveMonths;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public TwelveMonths getTwelveMonths() {
        return twelveMonths;
    }

    public void setTwelveMonths(TwelveMonths twelveMonths) {
        this.twelveMonths = twelveMonths;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.month, flags);
        dest.writeParcelable(this.year, flags);
        dest.writeParcelable(this.twelveMonths, flags);
    }

    public MoreInfo() {
    }

    protected MoreInfo(Parcel in) {
        this.month = in.readParcelable(Month.class.getClassLoader());
        this.year = in.readParcelable(Year.class.getClassLoader());
        this.twelveMonths = in.readParcelable(TwelveMonths.class.getClassLoader());
    }

    public static final Parcelable.Creator<MoreInfo> CREATOR = new Parcelable.Creator<MoreInfo>() {
        @Override
        public MoreInfo createFromParcel(Parcel source) {
            return new MoreInfo(source);
        }

        @Override
        public MoreInfo[] newArray(int size) {
            return new MoreInfo[size];
        }
    };
}
