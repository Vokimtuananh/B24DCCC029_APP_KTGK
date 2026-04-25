package com.example.b24dccc029_app_ktgk;
import java.io.Serializable;
public abstract class Document implements Serializable {
    private String ma;
    private String ten;
    private double gia;
    public Document(String ma, String ten, double gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }
    public abstract double tinhPhiMuon();
    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public double getGia() { return gia; }
}