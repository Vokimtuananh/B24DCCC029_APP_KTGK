package com.example.b24dccc029_app_ktgk;
public class EBook extends Document {
    private double dungLuong;
    public EBook(String ma, String ten, double gia, double dungLuong) {
        super(ma, ten, gia);
        this.dungLuong = dungLuong;
    }
    @Override
    public double tinhPhiMuon() { return dungLuong * 1000; }
}