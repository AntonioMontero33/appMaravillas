package com.example.appmaravillas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appmaravillas.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker tgPlaza, tgValle, tgQori, tgSayseg, tgMoray, tempMarker;
    ImageButton btnBack, btnNext, btnReduce;
    ArrayList<Marker> markers = new ArrayList<Marker>();
    Boolean focus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        btnBack = findViewById(R.id.btnBefore);
        btnNext = findViewById(R.id.btnNext);
        btnReduce = findViewById(R.id.btnReducir);

        markers.add(tgPlaza);
        markers.add(tgQori);
        markers.add(tgSayseg);
        markers.add(tgMoray);
        markers.add(tgValle);


        btnReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng ayacucho = new LatLng(-13.516584220474082, -71.97869091610546);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ayacucho, 10.0f));
            };

        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Se esta implementando",Toast.LENGTH_SHORT).show();
            };

        });



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


        // *****marcador simple y desripción ****//
        LatLng ayacucho = new LatLng(-13.516584220474082, -71.97869091610546);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ayacucho, 10.0f));

        //MARCADORES


        //Plaza de Armas
        LatLng Plaza = new LatLng(-13.516584220474082, -71.97869091610546);
        tgPlaza = mMap.addMarker(new MarkerOptions().position(Plaza).draggable(true).title("Plaza de armas del Cusco").snippet
                ("Cusco Ciudad del Sol").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Valle Sagrado
        LatLng vallesagrado = new LatLng(-13.33202248427566, -72.08472243249994);
        tgValle = mMap.addMarker(new MarkerOptions().position(vallesagrado).draggable(true).title("Valle Sagrado").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //saqsayhuaman
        LatLng saqsayhuaman = new LatLng(-13.509689078979589, -71.98168780261206);
        tgSayseg = mMap.addMarker(new MarkerOptions().position(saqsayhuaman).draggable(true).title("Saqseyhuaman").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        //Qoricancha
        LatLng Qoricancha = new LatLng(-13.519986134071862, -71.97522317377646);
        tgQori = mMap.addMarker(new MarkerOptions().position(Qoricancha).draggable(true).title("Qoricancha").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        //Moray
        LatLng Moray = new LatLng(-13.329689823920416, -72.19710090669257);
        tgMoray = mMap.addMarker(new MarkerOptions().position(Moray).draggable(true).title("Moray").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));





        googleMap.setOnMarkerClickListener(this::onMarkerClick);
    }

    private boolean onMarkerClick(Marker marker) {
        //obtner la latitud y longitud
        String lat,lng;
        Double lat1, lng1;
        lat = Double.toString(marker.getPosition().latitude);
        lng = Double.toString(marker.getPosition().longitude);
        lat1 = marker.getPosition().latitude;
        lng1 = marker.getPosition().longitude;
        LatLng temp = new LatLng(lat1, lng1);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(temp, 15.0f));
        // plasme en un toast
        Toast.makeText(this, lat  + "," + lng,Toast.LENGTH_SHORT).show();
        focus = true;
        tempMarker = marker;
        return false;
    }
}