package com.example.b24dccc029_app_ktgk;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
public class AddActivity extends AppCompatActivity {
    private EditText edtMa, edtTen, edtGia, edtBienPhu;
    private Spinner spLoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        edtGia = findViewById(R.id.edtGia);
        edtBienPhu = findViewById(R.id.edtBienPhu);
        spLoai = findViewById(R.id.spLoai);
        String[] loai = {"Book", "Magazine", "EBook"};
        spLoai.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, loai));
        findViewById(R.id.btnSave).setOnClickListener(v -> {
            String ma = edtMa.getText().toString();
            String ten = edtTen.getText().toString();
            double gia = Double.parseDouble(edtGia.getText().toString());
            double bp = Double.parseDouble(edtBienPhu.getText().toString());
            int pos = spLoai.getSelectedItemPosition();
            if (pos == 0) MainActivity.ds.add(new Book(ma, ten, gia, (int)bp));
            else if (pos == 1) MainActivity.ds.add(new Magazine(ma, ten, gia, (int)bp));
            else MainActivity.ds.add(new EBook(ma, ten, gia, bp));
            finish();
        });
    }
}