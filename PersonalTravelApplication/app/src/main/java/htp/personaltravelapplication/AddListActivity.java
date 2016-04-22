package htp.personaltravelapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import htp.personaltravelapplication.bean.MapObject;

public class AddListActivity extends Activity {
  Button btnCreateList;
    EditText eTitle, eContent;
    TextView tLng,tLat, tAddress;
    LocationManager lManager;
    String provide;
    Location location;
    TableController tableController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_list_form);
        eTitle=(EditText)findViewById(R.id.txt_Title);
        eContent=(EditText) findViewById(R.id.txt_Content);
        tAddress =(TextView)findViewById(R.id.lblAddress);
        tLng=(TextView)findViewById(R.id.lblLng);
        tLat=(TextView)findViewById(R.id.lbl_Lat);
        Intent i = getIntent();
        MapObject mapObject = (MapObject)i.getSerializableExtra("mapObject");
        tLat.setText(String.valueOf(""+mapObject.getLat()));
        tLng.setText(String.valueOf(""+mapObject.getLng()));
        tAddress.setText(mapObject.getAddress());

        tableController = new TableController(AddListActivity.this.getBaseContext());
        btnCreateList.setOnClickListener(new OnClickListenerAddContent());

    }



}
