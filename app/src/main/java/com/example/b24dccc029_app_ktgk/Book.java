package com.example.b24dccc029_app_ktgk;
public class Book extends Document {
    private int soTrang;
    public Book(String ma, String ten, double gia, int soTrang) {
        super(ma, ten, gia);
        this.soTrang = soTrang;
    }
    @Override
    public double tinhPhiMuon() { return getGia() * 0.05; }
}