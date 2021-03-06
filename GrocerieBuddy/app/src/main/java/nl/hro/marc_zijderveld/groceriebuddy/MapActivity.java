package nl.hro.marc_zijderveld.groceriebuddy;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//Loads the map for the shop, in this activity the shop is loaded.
public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Shop s;

    @Override
    //Creat the map.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
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
    //When the map is ready and created, set the marker for the lat / lon of the shop and then zoom the map.
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        s = (Shop) getIntent().getSerializableExtra("shop");

        // Add a marker in Sydney and move the camera
        LatLng shopLoc = new LatLng(s.location.latitude, s.location.longitude);
        mMap.addMarker(new MarkerOptions().position(shopLoc).title(s.name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shopLoc));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
    }
}
