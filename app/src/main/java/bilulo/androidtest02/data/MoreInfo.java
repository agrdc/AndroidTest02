package bilulo.androidtest02.data;

import com.google.gson.annotations.SerializedName;

public class MoreInfo {
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
}
