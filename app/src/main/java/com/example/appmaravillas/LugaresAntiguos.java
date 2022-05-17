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
import com.example.appmaravillas.databinding.ActivityLugaresAntiguosBinding;

public class LugaresAntiguos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLugaresAntiguosBinding binding;
    private Marker tgPlaza, tgGiza, tgMausoleo, tgZeus, tgMoray, tgAlejandria, tgArtemisa, tgColoso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLugaresAntiguosBinding.inflate(getLayoutInflater());
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


        LatLng central = new LatLng(0, 0);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(central, 1.0f));

        //COLOR MARCADOR
        //1****arrastrando marcador con draggable
        LatLng Plaza = new LatLng(-13.516584220474082, -71.97869091610546);
        tgPlaza = mMap.addMarker(new MarkerOptions().position(Plaza).draggable(true).title("Plaza de armas del Cusco").snippet
                ("Cusco Ciudad del Sol").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Piramides de Giza
        LatLng giza = new LatLng(29.977326686130073, 31.132490390583566);
        tgGiza = mMap.addMarker(new MarkerOptions().position(giza).draggable(true).title("Piramides de Giza").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Mausoleo de Halicarnaso
        LatLng mausoleo = new LatLng(37.03787881574647, 27.424094939921304);
        tgMausoleo = mMap.addMarker(new MarkerOptions().position(mausoleo).draggable(true).title("Mausoleo de Halicarnaso").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        //Estatua de Zeus
        LatLng zeus = new LatLng(37.637867835884514, 21.630214099792056);
        tgZeus = mMap.addMarker(new MarkerOptions().position(zeus).draggable(true).title("Estatua de Zeus").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        //Jardines Colgantes de Babilonia
        LatLng babilonia = new LatLng(32.5422514873705, 44.42087855091694);
        tgMoray = mMap.addMarker(new MarkerOptions().position(babilonia).draggable(true).title("Jardines Colgantes de Babilonia").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Faro de Alejandria
        LatLng alejandria = new LatLng(31.20567825462503, 29.909081659187308);
        tgAlejandria = mMap.addMarker(new MarkerOptions().position(alejandria).draggable(true).title("Faro de Alejandria").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Templo de Artemisa
        LatLng artemisa = new LatLng(37.94956201841427, 27.363900278764966);
        tgArtemisa = mMap.addMarker(new MarkerOptions().position(artemisa).draggable(true).title("Templo de Artemisa").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        //Coloso de Rodas
        LatLng coloso = new LatLng(36.45111168805707, 28.225833189040873);
        tgColoso = mMap.addMarker(new MarkerOptions().position(coloso).draggable(true).title("Coloso de Rodas").icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

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