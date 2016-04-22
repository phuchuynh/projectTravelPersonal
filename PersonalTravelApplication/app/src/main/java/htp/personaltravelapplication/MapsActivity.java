package htp.personaltravelapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import htp.personaltravelapplication.bean.MapObject;
import htp.personaltravelapplication.bean.ObjectList;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;
    Location location;
    private GoogleMap mMap;
    private MapObject mapObject = null;
    private View mAddFormView;
    ListView listView;
    //menubutton
    private FABToolbarLayout toolbarLayout;
    private View one, show, search, list;
    private TextView txtInfo;
    private View fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // create buttonmenu
        toolbarLayout = (FABToolbarLayout) findViewById(R.id.fabtoolbar);
        //listview
        // one = findViewById(R.id.one);
        show = findViewById(R.id.show_list_button);
        search = findViewById(R.id.search_button);
        list = findViewById(R.id.list_button);
        fab = findViewById(R.id.fabtoolbar_fab);
        txtInfo = (TextView) findViewById(R.id.info);
        listView=(ListView)findViewById(R.id.listViewAll);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapObject != null) {
                    Intent intent = new Intent(MapsActivity.this, AddActivity.class);
                    intent.putExtra("mapObject", mapObject);
                    startActivity(intent);
                }
            }
        });

        show .setOnClickListener(new OnClickViewListDetail());
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapObject != null) {
                    Intent intent = new Intent(MapsActivity.this, AddActivity.class);
                    intent.putExtra("mapObject", mapObject);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        toolbarLayout.hide();
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in HCM and move the camera

        enableMyLocation();
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.activity_inforwindown, null);
                LatLng location = marker.getPosition();


                String address = getLocation(location.latitude, location.longitude);
                TextView txtAddress = (TextView) v.findViewById(R.id.txt_address);
                txtAddress.setText(address);
                mMap.setOnInfoWindowClickListener(MapsActivity.this);
                return v;

            }
        });
        //Login click event maps
        mMap.setOnMapLongClickListener(new OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                googleMap.clear();
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                Marker marker = googleMap.addMarker(markerOptions);
                String address = getLocation(marker.getPosition().latitude, marker.getPosition().longitude);
                mapObject = new MapObject(address, marker.getPosition().latitude, marker.getPosition().longitude);
                marker.showInfoWindow();
                toolbarLayout.show();
            }
        });


    }


    private String getLocation(double lat, double lng) {
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addr = geocoder.getFromLocation(lat, lng, 1);
            StringBuilder stringBuilder = new StringBuilder();
            if (addr.size() > 0) {
                Address address = addr.get(0);
                //stringBuilder.append(address.getSubLocality());

                for (int i = 0; i < address.getMaxAddressLineIndex(); i++)
                    stringBuilder.append(address.getAddressLine(i)).append(" ");
                stringBuilder.append(address.getCountryName());

                //stringBuilder.append(address.getLocality()).append(",");
            }
            String addressString = stringBuilder.toString();
            return addressString;
        } catch (IOException e) {
            return "Not found address";
        }
    }


    private void enableMyLocation() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(10.797083, 106.691851)).title("HCM"));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }
}
