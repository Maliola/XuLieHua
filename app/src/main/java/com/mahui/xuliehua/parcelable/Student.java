package com.mahui.xuliehua.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * @author 76047
 * @date 2018/8/14
 */

public class Student implements Parcelable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    protected Student(Parcel in) {
        id = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flag) {
        out.writeInt(id);
    }

    public static Creator<Student> getCREATOR() {
        return CREATOR;
    }
}
