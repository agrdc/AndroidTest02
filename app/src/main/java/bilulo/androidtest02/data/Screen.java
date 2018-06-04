package bilulo.androidtest02.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Screen implements Parcelable {
    private String title;
    private String fundName;
    private String whatIs;
    private String definition;
    private String riskTitle;
    private int risk;
    private String infoTitle;
    private MoreInfo moreInfo;
    private ArrayList<Info> info;
    private ArrayList<DownInfo> downInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(MoreInfo moreInfo) {
        this.moreInfo = moreInfo;
    }

    public ArrayList<Info> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<Info> info) {
        this.info = info;
    }

    public ArrayList<DownInfo> getDownInfo() {
        return downInfo;
    }

    public void setDownInfo(ArrayList<DownInfo> downInfo) {
        this.downInfo = downInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.fundName);
        dest.writeString(this.whatIs);
        dest.writeString(this.definition);
        dest.writeString(this.riskTitle);
        dest.writeInt(this.risk);
        dest.writeString(this.infoTitle);
        dest.writeParcelable(this.moreInfo, flags);
        dest.writeList(this.info);
        dest.writeList(this.downInfo);
    }

    public Screen() {
    }

    protected Screen(Parcel in) {
        this.title = in.readString();
        this.fundName = in.readString();
        this.whatIs = in.readString();
        this.definition = in.readString();
        this.riskTitle = in.readString();
        this.risk = in.readInt();
        this.infoTitle = in.readString();
        this.moreInfo = in.readParcelable(MoreInfo.class.getClassLoader());
        this.info = new ArrayList<Info>();
        in.readList(this.info, Info.class.getClassLoader());
        this.downInfo = new ArrayList<DownInfo>();
        in.readList(this.downInfo, DownInfo.class.getClassLoader());
    }

    public static final Parcelable.Creator<Screen> CREATOR = new Parcelable.Creator<Screen>() {
        @Override
        public Screen createFromParcel(Parcel source) {
            return new Screen(source);
        }

        @Override
        public Screen[] newArray(int size) {
            return new Screen[size];
        }
    };
}
