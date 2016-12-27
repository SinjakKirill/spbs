package com.example.sinyakkirill.lab_15_16;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import  android.location.LocationListener;
//import com.google.android.gms.location.LocationListener
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import android.location.Address;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager mLocationManager;
    TextView locationTextView;
    LocationListener mLocationListener;
    Button startButton;
    Button stopButton;
    PolylineOptions  line = new PolylineOptions ();
    Double currentLatitude = null;
    Double currentLongitude = null;
    Boolean pointBeginOrg = false;
    Polyline mPolyline = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationTextView = (TextView) findViewById(R.id.locationTextView);
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPolyline != null)
                    mPolyline.remove();
                if(currentLatitude != null && currentLongitude != null) {
                    LatLng currentPisition = new LatLng(currentLatitude, currentLongitude);
                    mMap.addMarker(new MarkerOptions().position(currentPisition).title("A"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(currentPisition));
                    pointBeginOrg = true;
                    LatLng current = new LatLng(currentLatitude, currentLongitude);
                    line.add(current);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Координаты еще не определены. Подождите пожалуйста.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(line != null){
                    pointBeginOrg = false;
                    LatLng currentPisition = new LatLng(currentLatitude, currentLongitude);
                    mMap.addMarker(new MarkerOptions().position(currentPisition).title("B"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(currentPisition));
                    line.color(Color.RED);
                    mPolyline = mMap.addPolyline(line);
                }
            }
        });

        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {
                    locationTextView.setText(new String(String.format("Coordenates: lat = %1$.4f, lon =  %2$.4f, time = %3$tF %3$tT", location.getLatitude(), location.getLongitude(), new Date(location.getTime()))) + " Altitude: " + location.getAltitude() + " Street: " + getCompleteAddressString(location.getLatitude(), location.getLongitude()));
                    currentLongitude = location.getLongitude();
                    currentLatitude = location.getLatitude();
                    if(pointBeginOrg){
                        LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
                        line.add(point);
                        line.color(Color.GREEN);
                        mPolyline = mMap.addPolyline(line);
                    }
                }
                else
                    locationTextView.setText("NULL");
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                checkEnabled();
            }

            @Override
            public void onProviderDisabled(String provider) {
                checkEnabled();
            }
        };
        checkEnabled();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //СОЗДАЕМ СЛУШАТЕЛЯ, КОТОРЫЙ БУДЕТ СЛЕДИТЬ ЗА ИЗМЕНЕНИЕМ МЕСТОПОЛОЖЕНИЯ


    private void checkEnabled() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Настройки")
                .setMessage("Выберете с помощью чего будет определяться Ваше местоположение.")
                .setNegativeButton("GPS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        if (ActivityCompat.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 * 2, 5, (android.location.LocationListener) mLocationListener);
                            return;
                        }
                        else{
                            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 * 2, 5,(LocationListener) mLocationListener);
                        }
                    }
                })
                .setPositiveButton("Mob.Operator, WiFi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                        if (ActivityCompat.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000 * 2, 5, (android.location.LocationListener) mLocationListener);
                            return;
                        }
                        else{
                            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000 * 2, 5, (android.location.LocationListener) mLocationListener);
                        }
                    }
                });
        Dialog dialog = dialogBuilder.create();
        dialog.show();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            mMap.setMyLocationEnabled(true);
            Toast.makeText(getApplicationContext(), "Yes!!!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            mMap.setMyLocationEnabled(true);
            Toast.makeText(getApplicationContext(), "No!!!", Toast.LENGTH_SHORT).show();
        }
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = null;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");
                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
            } else {}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strAdd;
    }
}
