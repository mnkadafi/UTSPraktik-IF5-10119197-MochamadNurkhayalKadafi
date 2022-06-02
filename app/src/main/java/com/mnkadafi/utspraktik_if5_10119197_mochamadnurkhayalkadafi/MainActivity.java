package com.mnkadafi.utspraktik_if5_10119197_mochamadnurkhayalkadafi;

//<!--02 Juni 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_JENIS_TES = "jenis_tes";
    public static final String EXTRA_TGL_TERKONFIRMASI = "tgl_terkonfirmasi";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIK = "nik";
    public static final String EXTRA_TGL_LAHIR = "tgl_lahir";
    public static final String EXTRA_KELAMIN = "kelamin";
    public static final String EXTRA_HUBUNGAN = "hubungan";
    public static final String EXTRA_STATUS = "status";

    EditText date_confirmation, date_birthday;
    DatePickerDialog datePickerDialog;
    String status = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Intent intent2=getIntent();
        status = intent2.getStringExtra(EXTRA_STATUS);

        RadioGroup radioJTGroup = (RadioGroup) findViewById(R.id.rg_jt);
        RadioGroup radioJKGroup = (RadioGroup) findViewById(R.id.rg_jk);
        RadioGroup radioHub = (RadioGroup) findViewById(R.id.rg_hubungan);
        EditText edtNik = findViewById(R.id.edt_nik);
        EditText  edtNama = findViewById(R.id.edt_nama);
        Button btn_lanjut = findViewById(R.id.btn_lanjut);
        date_confirmation = (EditText) findViewById(R.id.edt_tgl_terkonfirmasi);
        date_birthday = (EditText) findViewById(R.id.edt_tgl_lahir);

        if (status != ""){
            String jt = intent2.getStringExtra(MainActivity.EXTRA_JENIS_TES);
            String tgl_terkonfirmasi = intent2.getStringExtra(MainActivity.EXTRA_TGL_TERKONFIRMASI);
            String nik = intent2.getStringExtra(MainActivity.EXTRA_NIK);
            String nama = intent2.getStringExtra(MainActivity.EXTRA_NAMA);
            String tgl_lahir = intent2.getStringExtra(MainActivity.EXTRA_TGL_LAHIR);
            String jk = intent2.getStringExtra(MainActivity.EXTRA_KELAMIN);
            String hub = intent2.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

            date_confirmation.setText(tgl_terkonfirmasi);
            edtNik.setText(nik);
            edtNama.setText(nama);
            date_birthday.setText(tgl_lahir);

            if (jt == "Rapid Antigen"){
                radioJTGroup.check(R.id.rb_rapidantigen);
            }else if(jt == "PCR"){
                radioJTGroup.check(R.id.rb_pcr);
            }

            if (jk == "Laki - laki"){
                radioJKGroup.check(R.id.rb_l);
            }else if(jk == "Perempuan"){
                radioJKGroup.check(R.id.rb_p);
            }

            if (hub == "Orang Tua"){
                radioHub.check(R.id.rb_ortu);
            }else if (hub == "Suami / Istri"){
                radioHub.check(R.id.rb_couple);
            }else if (hub == "Anak"){
                radioHub.check(R.id.rb_anak);
            }else if(hub == "Kerabat Lainnya"){
                radioHub.check(R.id.rb_kerabat);
            }
        }


        // perform click event on edit text

        date_confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                String bulan = "";
                                if ((monthOfYear+1) == 1){
                                    bulan= "January";
                                }if ((monthOfYear+1) == 2){
                                    bulan= "February";
                                }if ((monthOfYear+1) == 3){
                                    bulan= "Maret";
                                }if ((monthOfYear+1) == 4){
                                    bulan= "April";
                                }if ((monthOfYear+1) == 5){
                                    bulan= "Mei";
                                }if ((monthOfYear+1) == 6){
                                    bulan= "Juni";
                                }if ((monthOfYear+1) == 7){
                                    bulan= "July";
                                }if ((monthOfYear+1) == 8){
                                    bulan= "Agustus";
                                }if ((monthOfYear+1) == 9){
                                    bulan= "September";
                                }if ((monthOfYear+1) == 10){
                                    bulan= "Oktober";
                                }if ((monthOfYear+1) == 11){
                                    bulan= "November";
                                }if ((monthOfYear+1) == 12){
                                    bulan= "Desember";
                                }
                                date_confirmation.setText(dayOfMonth + "  " + bulan + "  " + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        date_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                String bulan = "";
                                if ((monthOfYear+1) == 1){
                                    bulan= "January";
                                }if ((monthOfYear+1) == 2){
                                    bulan= "February";
                                }if ((monthOfYear+1) == 3){
                                    bulan= "Maret";
                                }if ((monthOfYear+1) == 4){
                                    bulan= "April";
                                }if ((monthOfYear+1) == 5){
                                    bulan= "Mei";
                                }if ((monthOfYear+1) == 6){
                                    bulan= "Juni";
                                }if ((monthOfYear+1) == 7){
                                    bulan= "July";
                                }if ((monthOfYear+1) == 8){
                                    bulan= "Agustus";
                                }if ((monthOfYear+1) == 9){
                                    bulan= "September";
                                }if ((monthOfYear+1) == 10){
                                    bulan= "Oktober";
                                }if ((monthOfYear+1) == 11){
                                    bulan= "November";
                                }if ((monthOfYear+1) == 12){
                                    bulan= "Desember";
                                }
                                date_birthday.setText(dayOfMonth + "  " + bulan + "  " + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        Intent intent = new Intent(this, CheckDataActivity.class);
        btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedJTId = radioJTGroup.getCheckedRadioButtonId();
                RadioButton radioJTButton = (RadioButton) findViewById(selectedJTId);
                String tgl_terkonfirmasi = date_confirmation.getText().toString();
                String nik = edtNik.getText().toString();
                String nama = edtNama.getText().toString();
                String tgl_lahir = date_birthday.getText().toString();
                int selectedJKId = radioJKGroup.getCheckedRadioButtonId();
                RadioButton radioJKButton = (RadioButton) findViewById(selectedJKId);

                int selectedId2 = radioHub.getCheckedRadioButtonId();
                RadioButton radiohubButton = (RadioButton) findViewById(selectedId2);

                intent.putExtra(EXTRA_JENIS_TES,radioJTButton.getText());
                intent.putExtra(EXTRA_TGL_TERKONFIRMASI,tgl_terkonfirmasi);
                intent.putExtra(EXTRA_NIK,nik);
                intent.putExtra(EXTRA_NAMA,nama);
                intent.putExtra(EXTRA_TGL_LAHIR,tgl_lahir);
                intent.putExtra(EXTRA_KELAMIN,radioJKButton.getText());
                intent.putExtra(EXTRA_HUBUNGAN,radiohubButton.getText());
                startActivity(intent);
            }
        });

    }
}