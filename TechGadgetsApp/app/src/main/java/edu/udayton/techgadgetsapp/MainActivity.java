package edu.udayton.techgadgetsapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        List<String> Attracions= Arrays.asList(getResources().getStringArray(R.array.attraction));
        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,R.id.Garmin_nuvi_52LM_GPS,Attracions));
    }//end onCreate Method

    protected  void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = null;

        switch (position){
            case 0:
                intent=new Intent(MainActivity.this, Picture.class);

                intent.putExtra(Picture.LBL_KEY,getResources().getString(R.string.garmin_gps));
                intent.putExtra(Picture.BTN_LBL,getResources().getString(R.string.open_gps_site));
                intent.putExtra(Picture.ID_KEY,Integer.toString(R.drawable.garmingps));
                intent.putExtra(Picture.URL,"https://buy.garmin.com/en-US/US/on-the-road/nuvi-52lm/prod120976.html");
                break;

            case 1:
                intent=new Intent(MainActivity.this, Picture.class);

                intent.putExtra(Picture.LBL_KEY,getResources().getString(R.string.fitbit_wristband));
                intent.putExtra(Picture.BTN_LBL,getResources().getString(R.string.open_wristband_site));
                intent.putExtra(Picture.ID_KEY,Integer.toString(R.drawable.wristband));
                intent.putExtra(Picture.URL,"https://www.fitbit.com/in/charge");
                break;

            case 2:
                intent=new Intent(MainActivity.this, Picture.class);

                intent.putExtra(Picture.LBL_KEY,getResources().getString(R.string.samsung));
                intent.putExtra(Picture.BTN_LBL,getResources().getString(R.string.open_samsung_site));
                intent.putExtra(Picture.ID_KEY,Integer.toString(R.drawable.galaxys6edge));
                intent.putExtra(Picture.URL,"http://www.samsung.com/us/mobile/cell-phones/SM-G925TZDATMB");
                break;

            case 3:
                intent=new Intent(MainActivity.this, Picture.class);

                intent.putExtra(Picture.LBL_KEY,getResources().getString(R.string.apple_watch));
                intent.putExtra(Picture.BTN_LBL,getResources().getString(R.string.open_watch_site));
                intent.putExtra(Picture.ID_KEY,Integer.toString(R.drawable.applewatch));
                intent.putExtra(Picture.URL,"http://www.apple.com/watch/");

                break;

            case 4:
                intent=new Intent(MainActivity.this, Picture.class);

                intent.putExtra(Picture.LBL_KEY,getResources().getString(R.string.ipad_air2));
                intent.putExtra(Picture.BTN_LBL,getResources().getString(R.string.open_ipad_air2_site));
                intent.putExtra(Picture.ID_KEY,Integer.toString(R.drawable.ipadair2));
                intent.putExtra(Picture.URL,"http://www.apple.com/ipad-air-2/");
                break;

        }//end switch
        startActivity(intent);
    }//end onListItemClick method
}//end MainActivity Class