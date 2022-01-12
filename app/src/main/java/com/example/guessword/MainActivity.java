package com.example.guessword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    char[] lettersArray = "абвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    String guessesWord = "словосекретное";
    String encryptionWord = guessesWord.replaceAll("[а-я]","*");
    String s = "";
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button t1 = (Button) view;
                String textBtn = String.valueOf(t1.getText());
                if (guessesWord.contains(textBtn)) {
                    s += textBtn;
                    String regex = "[" + "^" + s + "]";
                    String s1 = guessesWord.replaceAll(regex, "*");
                    t1.setEnabled(false);
                    t.setText(s1);
                }
            }
        };
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        GridLayout gridLayout = new GridLayout(this);
        t = new TextView(this);
        t.setTextSize(25);
        t.setText(encryptionWord);
        linearLayout.addView(t);
        gridLayout.setRowCount(8);
        gridLayout.setColumnCount(4);
        linearLayout.addView(gridLayout);
        for (int i = 0; i < lettersArray.length; i++) {
            Button btn = new Button(this);
            btn.setText(lettersArray[i] + "");
            btn.setOnClickListener(onClick);
            gridLayout.addView(btn, i);
        }
        setContentView(linearLayout);
    }
}