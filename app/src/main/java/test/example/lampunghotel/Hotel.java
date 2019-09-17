package test.example.lampunghotel;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {
    private String name;
    private String detail;
    private String photo;

    private Hotel(Parcel in) {
        name = in.readString();
        detail = in.readString();
        photo = in.readString();
    }

    Hotel() {

    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDetail() {
        return detail;
    }

    void setDetail(String detail) {
        this.detail = detail;
    }

    String getPhoto() {
        return photo;
    }

    void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeString(photo);
    }
}
