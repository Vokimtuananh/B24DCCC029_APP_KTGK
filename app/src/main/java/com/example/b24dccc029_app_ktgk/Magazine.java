package com.example.b24dccc029_app_ktgk;
public class Magazine extends Document {
    private int soKy;
    public Magazine(String ma, String ten, double gia, int soKy) {
        super(ma, ten, gia);
        this.soKy = soKy;
    }
    @Override
    public double tinhPhiMuon() { return getGia() * 0.03; }
}