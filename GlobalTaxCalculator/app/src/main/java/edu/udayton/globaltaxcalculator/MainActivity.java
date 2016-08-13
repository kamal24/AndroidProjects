package edu.udayton.globaltaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{
    private Button calTax;
    private EditText et;
    private String msg;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //display the actionBar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        calTax=(Button) findViewById(R.id.button);
        et=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.resultMsg);

        final RadioButton rd1=(RadioButton)findViewById(R.id.china);
        final RadioButton rd2=(RadioButton)findViewById(R.id.sweden);
        final RadioButton rd3=(RadioButton)findViewById(R.id.usa);
        final RadioButton rd4=(RadioButton)findViewById(R.id.germany);


        final DecimalFormat formatter=new DecimalFormat("###,###.##");

        View.OnClickListener calculateListener=new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String input=et.getText().toString();
                String curr = "";
                double us = 0.18;
                double germany = 0.32;
                double sweden = 0.34;
                double china = 0.25;
                double tax= 0.0;
                String country="";
                msg="Invalid Data Entered";
                try {
                    double amount=Double.parseDouble(input);
                    if(rd1.isChecked()) {
                        curr = "Renminbi";
                        tax=amount*china;
                        country="China";

                    }
                     else if(rd4.isChecked()) {
                        curr = "euros";
                        tax=amount*germany;
                        country="Germany";
                    }
                    else if(rd3.isChecked()) {
                        curr = "Dollars";
                        tax=amount*us;
                        country="U.S.A.";
                    }
                    else if(rd2.isChecked()) {
                        tax=amount*sweden;
                        curr = "euros";
                        country="Sweden";
                    }
                    msg = "Your past year's income as a resident of "+country+" is " + formatter.format(tax) +" "+ curr;
                }

                catch (Exception e){
                    Toast toast=Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG);
                    toast.show();
                }
                tv.setText(msg);

            }//end on click method
        };
        calTax.setOnClickListener(calculateListener);
    }//end onCreate Method

}//end MainActivity Class
