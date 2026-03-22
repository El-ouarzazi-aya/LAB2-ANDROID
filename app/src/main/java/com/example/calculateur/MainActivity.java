package com.example.calculateur;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText champSurface, champPieces;
    private CheckBox checkPiscine;
    private TextView texteResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        champSurface = findViewById(R.id.input_surface);
        champPieces = findViewById(R.id.input_pieces);
        checkPiscine = findViewById(R.id.checkbox_piscine);
        texteResultat = findViewById(R.id.result);

        findViewById(R.id.button_calcul).setOnClickListener(v -> calculer());
    }

    private void calculer() {
        double surface = Double.parseDouble(champSurface.getText().toString());
        int pieces = Integer.parseInt(champPieces.getText().toString());
        boolean piscine = checkPiscine.isChecked();

        double taxeBase = surface * 2;
        double taxeSupplementaire = pieces * 50 + (piscine ? 100 : 0);
        double montantTotal = taxeBase + taxeSupplementaire;

        texteResultat.setText("Taxe estimée : " + montantTotal + " DH");
    }
}