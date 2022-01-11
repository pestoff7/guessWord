package com.example.guessword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String guessesWord = "вратарь";
        String encryptionWord = guessesWord.replaceAll("[а-я]", "*");
        StringBuilder guessesWordString = new StringBuilder(guessesWord);
        StringBuilder encryptionWordString = new StringBuilder(encryptionWord);
        TextView t = new TextView(this);
        char[] chrArr = guessesWord.toCharArray();
        final View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button t1 = (Button) view;
                String textBtn = String.valueOf(t1.getText());
                for (int i = 0; i < chrArr.length; i++) {
                    char c = chrArr[i];
                    String c2 = c + "";
                    if (c2.equals(textBtn)){
                        int letterIndex = guessesWord.indexOf(c2);
                        encryptionWordString.setCharAt(letterIndex, c);
                        t.setText(encryptionWordString);
                    }
                }
            }
        };
        super.onCreate(savedInstanceState);
        LinearLayout linLayout = new LinearLayout(this);
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(4);
        gridLayout.setRowCount(9);
        linLayout.addView(t);
        linLayout.addView(gridLayout);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams linLayoutParam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        t.setTextSize(25);
        int idBut = 1;
        char[] letterArray = "абвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        t.setText(encryptionWord);
        for (int i = 0; i < letterArray.length; i++){
            Button but = new Button(this);
            but.setText(letterArray[i] + "");
            but.setId(idBut);
            but.setOnClickListener(onClick);
            idBut++;
            gridLayout.addView(but, i);
        }
        setContentView(linLayout, linLayoutParam);
    }
}
