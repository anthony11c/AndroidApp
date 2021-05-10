package hr.tvz.android.listacosic;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {

    private String name;
    private String details;
    private int imageResource;

    public Country(String name, String details, int image){
            this.name = name;
            this.details = details;
            this.imageResource = image;
    }

    protected Country(Parcel in) {
        name = in.readString();
        details = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int ImageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(details);
        dest.writeInt(imageResource);
    }
}
