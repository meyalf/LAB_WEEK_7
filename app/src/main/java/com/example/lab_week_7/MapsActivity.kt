package com.example.lab_week_07

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_week_07.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MapsActivity", "=== APP STARTED ===")

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        Log.d("MapsActivity", "Map fragment setup complete")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.d("MapsActivity", "=== MAP IS READY ===")
        mMap = googleMap

        // HARDCODE: Set location to Jakarta
        val jakarta = LatLng(-6.2088, 106.8456)

        Log.d("MapsActivity", "Adding marker at Jakarta")
        mMap.addMarker(
            MarkerOptions()
                .position(jakarta)
                .title("Jakarta")
        )

        Log.d("MapsActivity", "Moving camera to Jakarta")
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jakarta, 12f))

        Log.d("MapsActivity", "=== MAP SETUP COMPLETE ===")
    }
}