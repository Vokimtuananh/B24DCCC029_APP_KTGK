package com.example.b24dccc029_app_ktgk;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private EditText edtSearch;
    private ArrayAdapter<String> adapter;
    public static List<Document> ds = new ArrayList<>();
    private List<String> hienThi = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvTaiLieu);
        edtSearch = findViewById(R.id.edtSearch);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hienThi);
        lv.setAdapter(adapter);
        findViewById(R.id.btnAdd).setOnClickListener(v -> startActivity(new Intent(this, AddActivity.class)));
        findViewById(R.id.btnSort).setOnClickListener(v -> {
            Collections.sort(ds, (d1, d2) -> Double.compare(d2.tinhPhiMuon(), d1.tinhPhiMuon()));
            capNhatLV(ds);
        });
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String key = s.toString().toLowerCase();
                List<Document> filtered = new ArrayList<>();
                for (Document d : ds) if (d.getTen().toLowerCase().contains(key)) filtered.add(d);
                capNhatLV(filtered);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Xác nhận xóa")
                    .setMessage("Bạn có muốn xóa tài liệu này không?")
                    .setPositiveButton("Có", (dialog, which) -> {
                        ds.remove(position);
                        capNhatLV(ds);
                    })
                    .setNegativeButton("Không", null).show();
            return true;
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        capNhatLV(ds);
    }
    private void capNhatLV(List<Document> list) {
        hienThi.clear();
        for (Document d : list) {
            String type = d instanceof Book ? "Sách" : d instanceof Magazine ? "Tạp chí" : "EBook";
            hienThi.add(d.getMa() + " - " + d.getTen() + "\nLoại: " + type + " - Phí: " + d.tinhPhiMuon());
        }
        adapter.notifyDataSetChanged();
    }
}