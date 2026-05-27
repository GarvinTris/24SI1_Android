package edu.uph.m24SI1.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PersegiActivity extends AppCompatActivity {
    // Inisialisasi variabel sesuai komponen baru
    private EditText edtNilaiA, edtNilaiB;
    private Button btnTambah, btnKali, btnBagi;
    private TextView txvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_persegi);

        // Hubungkan variabel dengan ID di XML
        edtNilaiA = findViewById(R.id.edtNilaiA);
        edtNilaiB = findViewById(R.id.edtNilaiB);
        btnTambah = findViewById(R.id.btnTambah);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        txvHasil = findViewById(R.id.txvHasil);

        // Tombol TAMBAH
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidInput()) {
                    double nilaiA = Double.parseDouble(edtNilaiA.getText().toString());
                    double nilaiB = Double.parseDouble(edtNilaiB.getText().toString());
                    double hasil = nilaiA + nilaiB;
                    tampilkanHasil(hasil);
                }
            }
        });

        // Tombol KALI
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidInput()) {
                    double nilaiA = Double.parseDouble(edtNilaiA.getText().toString());
                    double nilaiB = Double.parseDouble(edtNilaiB.getText().toString());
                    double hasil = nilaiA * nilaiB;
                    tampilkanHasil(hasil);
                }
            }
        });

        // Tombol BAGI
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidInput()) {
                    double nilaiA = Double.parseDouble(edtNilaiA.getText().toString());
                    double nilaiB = Double.parseDouble(edtNilaiB.getText().toString());

                    // Validasi pembagian dengan angka 0 agar tidak error/infinity
                    if (nilaiB == 0) {
                        Toast.makeText(PersegiActivity.this, "Nilai B tidak boleh 0 untuk pembagian!", Toast.LENGTH_SHORT).show();
                        txvHasil.setText("Error");
                        return;
                    }

                    double hasil = nilaiA / nilaiB;
                    tampilkanHasil(hasil);
                }
            }
        });
    }

    // Fungsi pembantu untuk cek apakah input kosong atau tidak
    private boolean isValidInput() {
        if (edtNilaiA.getText().toString().trim().isEmpty() || edtNilaiB.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Mohon isi Nilai A dan Nilai B!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Fungsi untuk merapikan tampilan angka (menghilangkan .0 jika hasilnya bulat)
    private void tampilkanHasil(double hasil) {
        if (hasil % 1 == 0) {
            txvHasil.setText(String.valueOf((int) hasil));
        } else {
            txvHasil.setText(String.valueOf(hasil));
        }
    }
}