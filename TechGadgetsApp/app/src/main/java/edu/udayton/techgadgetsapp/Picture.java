package edu.udayton.techgadgetsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Picture extends AppCompatActivity implements View.OnClickListener{
    public static final String ID_KEY="RES_ID", LBL_KEY="LABEL", BTN_LBL="BTN_LABEL" , URL="URL";
    private String siteUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

         Intent intent=getIntent();
         Bundle extras=intent.getExtras();

        if(extras!=null){
            String label=extras.getString(LBL_KEY);
            String btnLabel=extras.getString(BTN_LBL);
            Integer imageId=Integer.parseInt(extras.getString(ID_KEY));
            siteUrl=extras.getString(URL).toString();

            Button btn= (Button) findViewById(R.id.pictureSite);
            TextView title= (TextView) findViewById(R.id.pictureTitle);
            ImageView img= (ImageView) findViewById(R.id.pictureImage);

            title.setText(label);
            btn.setText(btnLabel);
            img.setImageResource(imageId);
            img.setContentDescription(label);

            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
      Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(siteUrl));
      startActivity(intent);
    }
}
