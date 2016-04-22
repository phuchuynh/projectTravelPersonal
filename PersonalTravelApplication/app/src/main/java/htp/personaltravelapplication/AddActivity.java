package htp.personaltravelapplication;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import htp.personaltravelapplication.bean.MapObject;

public class AddActivity extends AppCompatActivity {
    EditText eTitle, eContent;
    TextView tLng,tLat, tAddress;
    Button btn;
    LocationManager lManager;
    String provide;
    Location location;
    TableController tableController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eTitle=(EditText)findViewById(R.id.txt_Title);
        eContent=(EditText) findViewById(R.id.txt_Content);
        tAddress =(TextView)findViewById(R.id.lblAddress);
        tLng=(TextView)findViewById(R.id.lblLng);
        tLat=(TextView)findViewById(R.id.lbl_Lat);
        btn=(Button)findViewById(R.id.action_add);
        Intent i = getIntent();
        MapObject mapObject = (MapObject)i.getSerializableExtra("mapObject");
        tLat.setText(String.valueOf(""+mapObject.getLat()));
        tLng.setText(String.valueOf("" + mapObject.getLng()));
        tAddress.setText(mapObject.getAddress());
        tableController = new TableController(AddActivity.this.getBaseContext());




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_list_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /* On selecting action bar icons
    * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click

        switch (item.getItemId()) {
            case R.id.action_add:
                // add action
                btn=(Button)findViewById(R.id.action_add);
                btn.setOnClickListener(new OnClickListenerAddContent());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
