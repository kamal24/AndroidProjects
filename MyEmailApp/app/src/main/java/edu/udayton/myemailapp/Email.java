package edu.udayton.myemailapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Email extends Activity implements View.OnClickListener{

    Button chkCmd;
    EditText input1,input2,input3,input4;
    TextView tv;

    @Override
    public void onClick(View p1)
    {
        // TODO: Implement this method
        String emailAdd=input1.getText().toString();
        String[] emailAddress={emailAdd};
        String msg="Name: "+input2.getText().toString()+"\nMessage: "+
                input3.getText().toString()+"\nLocation is: "+input4.getText().toString();

        if(emailAdd.isEmpty() || input2.getText().toString().isEmpty() || input3.getText().toString().isEmpty() || input4.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(Email.this, "All Fields must be filled or Any input Field should not Be Empty", Toast.LENGTH_LONG);
            toast.show();
        }

        else {
            switch (p1.getId()) {
                case R.id.bResults1:
                    try {
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
                        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Mail For Information");
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, msg);
                        emailIntent.setType("plain/text");
                        startActivity(emailIntent);
                    }
                    catch (ActivityNotFoundException ex){
                        Toast.makeText(Email.this,"There are no email applications installed.Please Install At least one email application on your device",Toast.LENGTH_SHORT).show();
                    }

                        break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        intialize();
        chkCmd.setOnClickListener(this);
    }

    private void intialize(){

        input1=(EditText) findViewById(R.id.etCommands1);

        input2=(EditText) findViewById(R.id.etCommands2);

        input3=(EditText) findViewById(R.id.etCommands3);

        input4=(EditText) findViewById(R.id.etCommands4);

        tv=(TextView) findViewById(R.id.tvResults1);

        chkCmd=(Button) findViewById(R.id.bResults1);
    }
}
