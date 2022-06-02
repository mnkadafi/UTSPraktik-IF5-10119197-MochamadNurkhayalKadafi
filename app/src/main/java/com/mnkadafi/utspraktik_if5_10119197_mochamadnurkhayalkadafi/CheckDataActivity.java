package com.mnkadafi.utspraktik_if5_10119197_mochamadnurkhayalkadafi;

//<!--02 Juni 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckDataActivity extends AppCompatActivity {
    public static final String EXTRA_JENIS_TES = "jenis_tes";
    public static final String EXTRA_TGL_TERKONFIRMASI = "tgl_terkonfirmasi";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIK = "nik";
    public static final String EXTRA_TGL_LAHIR = "tgl";
    public static final String EXTRA_KELAMIN = "kelamin";
    public static final String EXTRA_HUBUNGAN = "hubungan";
    public static final String EXTRA_STATUS = "status";

    private Dialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_check_data);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this,MainActivity.class);

        String jt = intent.getStringExtra(MainActivity.EXTRA_JENIS_TES);
        String tgl_terkonfirmasi = intent.getStringExtra(MainActivity.EXTRA_TGL_TERKONFIRMASI);
        String nik = intent.getStringExtra(MainActivity.EXTRA_NIK);
        String nama = intent.getStringExtra(MainActivity.EXTRA_NAMA);
        String jk = intent.getStringExtra(MainActivity.EXTRA_KELAMIN);
        String tgl_lahir = intent.getStringExtra(MainActivity.EXTRA_TGL_LAHIR);
        String hub = intent.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

        TextView tvJenisTes = findViewById(R.id.tv_jenistes);
        TextView tvTglTerkonfirmasi = findViewById(R.id.tv_tgl_terkonfirmasi);
        TextView tvNik = findViewById(R.id.tv_nik);
        TextView tvNama = findViewById(R.id.tv_nama);
        TextView tvTglLahir = findViewById(R.id.tv_tgl_lahir);
        TextView tvHub = findViewById(R.id.tv_hubungan);
        TextView tvJk = findViewById(R.id.tv_nik);
        Button btn_simpan= findViewById(R.id.btn_confirm);
        Button btn_ubah= findViewById(R.id.btn_ubah);
        ImageView btn_back= findViewById(R.id.ivBack);

        tvJenisTes.setText(jt);
        tvTglTerkonfirmasi.setText(tgl_terkonfirmasi);
        tvNik.setText(nik);
        tvNama.setText(nama);
        tvTglLahir.setText(tgl_lahir);
        tvJk.setText(jk);
        tvHub.setText(hub);
        initCustomDialog();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.show();
            }
        });

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra(EXTRA_STATUS,"ubah");
                intent2.putExtra(EXTRA_JENIS_TES,jt);
                intent2.putExtra(EXTRA_TGL_TERKONFIRMASI,tgl_terkonfirmasi);
                intent2.putExtra(EXTRA_NIK,nik);
                intent2.putExtra(EXTRA_NAMA,nama);
                intent2.putExtra(EXTRA_TGL_LAHIR,tgl_lahir);
                intent2.putExtra(EXTRA_KELAMIN,jk);
                intent2.putExtra(EXTRA_HUBUNGAN,hub);

                startActivity(intent2);
            }
        });
    }


    private void initCustomDialog(){

        customDialog = new Dialog(CheckDataActivity.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.activity_succes_dialog);
        customDialog.setCancelable(true);

        Button btnok = customDialog.findViewById(R.id.btn_ok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog.dismiss();
            }
        });
    }
}