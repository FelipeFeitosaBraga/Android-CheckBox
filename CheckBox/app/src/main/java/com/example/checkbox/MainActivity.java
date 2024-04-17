package com.example.checkbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CheckBox ckbCi, ckbFu, ckbGa, ckbIn, ckbLi, ckbTe;
    private TextView txtSel;
    private Button btnEx, btnDes;
    private int cont;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ckbCi = (CheckBox) findViewById(R.id.checkBox1);
        ckbFu = (CheckBox) findViewById(R.id.checkBox2);
        ckbGa = (CheckBox) findViewById(R.id.checkBox3);
        ckbIn = (CheckBox) findViewById(R.id.checkBox4);
        ckbLi = (CheckBox) findViewById(R.id.checkBox5);
        ckbTe = (CheckBox) findViewById(R.id.checkBox6);
        txtSel = (TextView) findViewById(R.id.textView2);
        btnEx = (Button) findViewById(R.id.button);
        btnDes = (Button) findViewById(R.id.button2);
        ckbCi.setOnCheckedChangeListener(this);
        ckbFu.setOnCheckedChangeListener(this);
        ckbGa.setOnCheckedChangeListener(this);
        ckbIn.setOnCheckedChangeListener(this);
        ckbLi.setOnCheckedChangeListener(this);
        ckbTe.setOnCheckedChangeListener(this);
        btnEx.setOnClickListener(this);
        btnDes.setOnClickListener(this);
        cont = 0;
        exibirSelecionados();
    }
    @SuppressLint("DefaultLocale")
    private void exibirSelecionados() {
        // Recuperar o texto contido no TextView
        String txt = getResources().getString(R.string.txt_selecionados);
        txtSel.setText(String.format("%s= %d", txt, cont));
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            String txt = "Temas selecionados\n\n";
            txt += ckbCi.isChecked() ? "Cinema\n" : "";
            txt += ckbFu.isChecked() ? "Futebol\n" : "";
            txt += ckbGa.isChecked() ? "Gastronomia\n" : "";
            txt += ckbIn.isChecked() ? "Informática\n" : "";
            txt += ckbLi.isChecked() ? "Literatura\n" : "";
            txt += ckbTe.isChecked() ? "Teatro\n" : "";
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage(txt);
            dlg.setPositiveButton("OK", null);
            dlg.show();
        }
        else if (view.getId() == R.id.button2) {
            ckbCi.setChecked(false);
            ckbFu.setChecked(false);
            ckbGa.setChecked(false);
            ckbIn.setChecked(false);
            ckbLi.setChecked(false);
            ckbTe.setChecked(false);
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
    {
        if (b == true) {
            cont++;
        } else {
            cont--;
        }
        exibirSelecionados();
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
