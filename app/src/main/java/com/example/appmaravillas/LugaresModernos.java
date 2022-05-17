package com.example.appmaravillas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appmaravillas.databinding.ActivityLugaresModernosBinding;

public class LugaresModernos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLugaresModernosBinding binding;
    Marker tgMachupicchu, tgChichenitza, tgColiseoRomano, tgCristoredentor, tgMurallaChina, tgTajmahal, tgPetra, tgPlaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLugaresModernosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng ayacucho = new LatLng(-13.516584220474082, -71.97869091610546);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ayacucho, 1.0f));


        //COLOR MARCADOR
        //1****arrastrando marcador con draggable
        LatLng Plaza = new LatLng(-13.516584220474082, -71.97869091610546);
        tgPlaza = mMap.addMarker(new MarkerOptions().position(Plaza).draggable(true).title("Plaza de armas del Cusco").snippet
                ("Cusco Ciudad del Sol").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Machupicchu
        LatLng machupicchu = new LatLng(-13.16318820196556, -72.54497363173597);
        tgMachupicchu = mMap.addMarker(new MarkerOptions().position(machupicchu).draggable(true).title("Machu Picchu").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Chichen Itza
        LatLng chichenitza = new LatLng(20.68363489963051, -88.568763873193);
        tgChichenitza = mMap.addMarker(new MarkerOptions().position(chichenitza).draggable(true).title("Chichen Itza").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        //Coliseo Romano
        LatLng coliseoromano = new LatLng(41.89017024510993, 12.492241626561679);
        tgColiseoRomano = mMap.addMarker(new MarkerOptions().position(coliseoromano).draggable(true).title("Coliseo Romano").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        //Cristo Redentor
        LatLng cristoredentor = new LatLng(-22.951945623360313, -43.210455016032874);
        tgCristoredentor = mMap.addMarker(new MarkerOptions().position(cristoredentor).draggable(true).title("Cristo Redentor").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Muralla China
        LatLng murallachina = new LatLng(40.431915845912634, 116.57037489768426);
        tgMurallaChina = mMap.addMarker(new MarkerOptions().position(murallachina).draggable(true).title("Muralla China").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Taj Mahal
        LatLng tajmahal = new LatLng(27.172820260672175, 78.0407933200394);
        tgTajmahal = mMap.addMarker(new MarkerOptions().position(tajmahal).draggable(true).title("Taj Mahal").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Petra
        LatLng petra = new LatLng(30.328463642324394, 35.44433001092831);
        tgPetra = mMap.addMarker(new MarkerOptions().position(petra).draggable(true).title("Petra").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        googleMap.setOnMarkerClickListener(this::onMarkerClick);
    }

    private boolean onMarkerClick(Marker marker) {
        String lat,lng;
        Double lat1, lng1;
        lat = Double.toString(marker.getPosition().latitude);
        lng = Double.toString(marker.getPosition().longitude);
        lat1 = marker.getPosition().latitude;
        lng1 = marker.getPosition().longitude;
        LatLng temp = new LatLng(lat1, lng1);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(temp, 10.0f));
        // plasme en un toast
        Toast.makeText(this, lat  + "," + lng,Toast.LENGTH_SHORT).show();
        return false;
    }
}