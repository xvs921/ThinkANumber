package com.example.thinkanumbervorak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ButtonMinus, ButtonPlus, ButtonKuldes;
    private TextView TextViewEredmeny, TextViewTalaldKi;
    private ImageView ImageSziv1, ImageSziv2, ImageSziv3, ImageSziv4, ImageSziv5;
    private Random rand;
    private int elet, tipp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ButtonMinus.setOnClickListener(this);
        ButtonPlus.setOnClickListener(this);
        ButtonKuldes.setOnClickListener(this);

    }

    private void init() {
        ButtonMinus = findViewById(R.id.ButtonMinus);
        ButtonPlus = findViewById(R.id.ButtonPlus);
        ButtonKuldes = findViewById(R.id.ButtonKuldes);
        TextViewEredmeny = findViewById(R.id.TextViewEredmeny);
        TextViewTalaldKi = findViewById(R.id.TextViewTalaldKi);
        ImageSziv1 = findViewById(R.id.imageSziv1);
        ImageSziv2 = findViewById(R.id.imageSziv2);
        ImageSziv3 = findViewById(R.id.imageSziv3);
        ImageSziv4 = findViewById(R.id.imageSziv4);
        ImageSziv5 = findViewById(R.id.imageSziv5);
        rand = new Random(10);
        elet = 5;
        tipp = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ButtonPlus:
                if (tipp >= 10) {
                    Toast.makeText(MainActivity.this, "10-nél kisebb", Toast.LENGTH_SHORT).show();
                } else {
                    tipp++;
                }
                break;
            case R.id.ButtonMinus:
                if (tipp <= 0) {
                    Toast.makeText(MainActivity.this, "0-nál nagyobb", Toast.LENGTH_SHORT).show();
                } else {
                    tipp--;
                }
                break;
            case R.id.ButtonKuldes:
                if (tipp==1)
                {
                    ButtonKuldes.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    elet--;
                    switch (elet){
                        case 5:break;
                        case 4: ImageSziv1.setImageResource(R.drawable.heart1);break;
                        case 3: ImageSziv1.setImageResource(R.drawable.heart1);ImageSziv2.setImageResource(R.drawable.heart1);break;
                        case 2: ImageSziv1.setImageResource(R.drawable.heart1);ImageSziv2.setImageResource(R.drawable.heart1);ImageSziv3.setImageResource(R.drawable.heart1);break;
                        case 1: ImageSziv1.setImageResource(R.drawable.heart1);ImageSziv2.setImageResource(R.drawable.heart1);ImageSziv3.setImageResource(R.drawable.heart1);ImageSziv4.setImageResource(R.drawable.heart1);break;
                        case 0: ImageSziv1.setImageResource(R.drawable.heart1);ImageSziv2.setImageResource(R.drawable.heart1);ImageSziv3.setImageResource(R.drawable.heart1);ImageSziv4.setImageResource(R.drawable.heart1);ImageSziv5.setImageResource(R.drawable.heart1);
                        Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();finish();break;
                    }
                }
        }
    }
}
