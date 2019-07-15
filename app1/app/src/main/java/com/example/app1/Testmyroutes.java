package com.example.app1;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Testmyroutes extends AppCompatActivity implements OnMapReadyCallback, TaskLoadedCallback{

        GoogleMap map;
        Button btndir;
        MarkerOptions place1,place2;
        Polyline currentPolyline;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            supportMapFragment.getMapAsync(this);

            place1 = new MarkerOptions().position(new LatLng(-0.606144, 30.661249)).title("Location 1");
            place2 = new MarkerOptions().position(new LatLng(-0.604824, 30.661421)).title("Location 2");

                    String url = getUrl(place1.getPosition(),place2.getPosition(),"driving");
                    new DownloadURL(Testmyroutes.this).execute(url,"driving");

        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;
            map.addMarker(place1);
            map.addMarker(place2);

        }
        private String getUrl(LatLng origin, LatLng dest, String directionMode) {
            String string_origin = "origin="+ origin.latitude+","+origin.longitude;
            String string_dest = "destination="+ dest.latitude+","+dest.longitude;
            String mode = "mode=" + directionMode;
            String parameters = string_origin + "&" + string_dest + "&" + mode;
            String output = "json";
            String url = "https://maps.googleapis.com/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
            return url;
        }

        public void onTaskDone(Object... values) {
            if (currentPolyline!=null)
                currentPolyline.remove();
            currentPolyline = map.addPolyline((PolylineOptions) values[1]);

        }


    }



