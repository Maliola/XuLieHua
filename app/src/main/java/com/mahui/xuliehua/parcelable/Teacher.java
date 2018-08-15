package com.mahui.xuliehua.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 76047
 * @date 2018/8/14
 */

public class Teacher implements Parcelable {
    private int id;
    private boolean normalStatus;
    private long gmtCreated;
    private String name;
    private BigDecimal price;
    private Student secondBean;
    private List<Student> secondBeanList;
    private int[] numberArray;
    private Map<String,String> map;


    public Teacher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNormalStatus() {
        return normalStatus;
    }

    public void setNormalStatus(boolean normalStatus) {
        this.normalStatus = normalStatus;
    }

    public long getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(long gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Student getSecondBean() {
        return secondBean;
    }

    public void setSecondBean(Student secondBean) {
        this.secondBean = secondBean;
    }

    public List<Student> getSecondBeanList() {
        return secondBeanList;
    }

    public void setSecondBeanList(List<Student> secondBeanList) {
        this.secondBeanList = secondBeanList;
    }

    public int[] getNumberArray() {
        return numberArray;
    }

    public void setNumberArray(int[] numberArray) {
        this.numberArray = numberArray;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    //固定写法, 只用修改Creator的泛型
    public static Creator<Teacher> getCREATOR() {
        return CREATOR;
    }

    //固定写法, 只用修改Creator的泛型
    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            //从序列化的对象创建原始对象
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            //创建指定长度的原始数组
            return new Teacher[size];
        }
    };

    @Override
    public int describeContents() {
        //固定写法
        return 0;
    }

    protected Teacher(Parcel in) {
        //顺序一定要对应上
        id = in.readInt();
        //读取的String转为布尔类型
        normalStatus = Boolean.valueOf(in.readString());
        gmtCreated = in.readLong();
        name = in.readString();
        //读取的price为String类型, 需要转为BigDecimal
        price = new BigDecimal(in.readString());
        //读取对象实现了Parcelable接口的对象
        secondBean = in.readParcelable(Student.class.getClassLoader());
        //读取实现了Parcelable接口的对象List
        secondBeanList = in.readArrayList(Student.class.getClassLoader());
        //创建(读取)int类型数组, 其他数组类型以此类推
        numberArray = in.createIntArray();
        map = in.readHashMap(String.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        //切记非常重要, 写数据(out.write...)和下面的读数据(in.read...)的顺序一定要和声明的属性顺序对应上, 不然会因为读写的数据类型不一致而报异常
        //普通数据类型int, double, String等等, 用法以此类推
        out.writeInt(id);
        //由于没有写入布尔数据类型的方法, 需要把布尔数据类型转换为String
        out.writeString(String.valueOf(normalStatus));
        out.writeLong(gmtCreated);
        out.writeString(name);
        //判空, 因为如果price为null, 也会报异常, 没有写入BigDecimal的数据类型, 需要转为String
        out.writeString(price == null ? "0" : price.toString());
        //写入对象, 该对象必须也要实现Parcelable接口
        out.writeParcelable(secondBean, flags);
        //写入List集合
        out.writeList(secondBeanList);
        //写入int类型数组, 其他的数组类型以此类推
        out.writeIntArray(numberArray);
        out.writeMap(map);
    }
}
