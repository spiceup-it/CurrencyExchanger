package com.example.yuzzle.currencyexchanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText input;
    private TextView output;
    private ImageView imageView1, imageView2;
    String[] currencyName1={"INR","JPY","USD","EUR","GBD","CHY","RUB"};
    String[] currencyName2={"INR","JPY","USD","EUR","GBD","CHY","RUB"};
    String amount=null;

    int amountValue,exchangedCurrency,virtualCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=findViewById(R.id.edittext);
        output=findViewById(R.id.text);
        imageView1=findViewById(R.id.currencyimage1);
        imageView2=findViewById(R.id.currencyimage2);
        Spinner spin1 = findViewById(R.id.spinner1);
        Spinner spin2 = findViewById(R.id.spinner2);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,currencyName1);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(aa1);
        spin1.setOnItemSelectedListener(this);


        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,currencyName2);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(aa2);
        spin2.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view,int i, long l){

        Spinner spin1 = findViewById(R.id.spinner1);
        Spinner spin2 = findViewById(R.id.spinner2);

        String item1 = spin1.getSelectedItem().toString();
        switch (item1) {
            case "INR"://INR
                imageView1.setImageResource(R.drawable.one_rupee);
                break;
            case "JPY"://JPY
                imageView1.setImageResource(R.drawable.one_yen);
                break;
            case "USD"://USD
                imageView1.setImageResource(R.drawable.one_dollar);
                break;
            case "EUR"://EUR
                imageView1.setImageResource(R.drawable.one_euro);
                break;
            case "GBD"://GBD
                imageView1.setImageResource(R.drawable.one_pound);
                break;
            case "CHY"://CHY
                imageView1.setImageResource(R.drawable.one_yuan);
                break;
            case "RUB"://RUB
                imageView1.setImageResource(R.drawable.one_ruble);
                break;
        }

        String item2 = (String) spin2.getSelectedItem();
        switch (item2) {
            case "INR"://INR
                imageView2.setImageResource(R.drawable.one_rupee);
                break;
            case "JPY"://JPY
                imageView2.setImageResource(R.drawable.one_yen);
                break;
            case "USD"://USD
                imageView2.setImageResource(R.drawable.one_dollar);
                break;
            case "EUR"://EUR
                imageView2.setImageResource(R.drawable.one_euro);
                break;
            case "GBD"://GBD
                imageView2.setImageResource(R.drawable.one_pound);
                break;
            case "CHY"://CHY
                imageView2.setImageResource(R.drawable.one_yuan);
                break;
            case "RUB"://RUB
                imageView2.setImageResource(R.drawable.one_ruble);
                break;
        }
        //Problem below two lines
        spin1 = (Spinner) adapterView;
        spin2 = (Spinner) adapterView;

        if (spin1.getId() == R.id.spinner1) {
            //Toastnoオブジェクト宣言と初期化を分けるとshow()のメソッドでエラーが発生する。
            Toast toast1 = Toast.makeText(this, "from " + currencyName1[i],Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER_HORIZONTAL,0,-500);
            toast1.show();

            //Toast.makeText(getApplicationContext(), "from " + currencyName1[i], Toast.LENGTH_SHORT ).show();
        }
        if (spin2.getId() == R.id.spinner2) {
            Toast toast2 = Toast.makeText(this, "from " + currencyName1[i],Toast.LENGTH_SHORT);
            toast2.setGravity(Gravity.CENTER_HORIZONTAL,0,650);
            toast2.show();

            //Toast.makeText(getApplicationContext(), "to " + currencyName2[i], Toast.LENGTH_SHORT).show();
        }
        /*
        if (adapterView.getId()==R.id.spinner1) {

        }
        if (adapterView.getId()==R.id.spinner2) {
            Toast.makeText(getApplicationContext(), "to " + currencyName2[i], Toast.LENGTH_SHORT).show();
        }*/
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void exchange(View view){
        amount=input.getText().toString();
        amountValue=Integer.parseInt(amount);
        Spinner spin1 = findViewById(R.id.spinner1);
        Spinner spin2 = findViewById(R.id.spinner2);

        //上のspinner1の国を元に通貨を指定して仲介通貨に変換
        String item1 = spin1.getSelectedItem().toString();
        switch (item1) {
            case "INR"://INR
                virtualCurrency = amountValue * 210;
                break;
            case "JPY"://JPY
                virtualCurrency = amountValue * 127;
                break;
            case "USD"://USD
                virtualCurrency = amountValue * 13888;
                break;
            case "EUR"://EUR
                virtualCurrency = amountValue * 16666;
                break;
            case "GBD"://GBD
                virtualCurrency = amountValue * 19230;
                break;
            case "CHY"://CHY
                virtualCurrency = amountValue * 2202;
                break;
            case "RUB"://RUB
                virtualCurrency = amountValue * 220;
                break;
        }

        //仲介通貨を下のSpinnerの通貨に変換
        String item2 = (String) spin2.getSelectedItem();
        switch (item2) {
            case "INR"://INR
                exchangedCurrency = virtualCurrency / 210;
                break;
            case "JPY"://JPY
                exchangedCurrency = virtualCurrency / 127;
                break;
            case "USD"://USD
                exchangedCurrency = virtualCurrency / 13888;
                break;
            case "EUR"://EUR
                exchangedCurrency = virtualCurrency / 16666;
                break;
            case "GBD"://GBD
                exchangedCurrency = virtualCurrency / 19230;
                break;
            case "CHY"://CHY
                exchangedCurrency = virtualCurrency / 2202;
                break;
            case "RUB"://RUB
                exchangedCurrency = virtualCurrency / 220;
                break;
        }
        output.setText(String.valueOf(exchangedCurrency));


    }
}
