package com.example.getlatlong;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import android.view.Menu;

public class GetLatLong extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_lat_long);

        /* Use the LocationManager class to obtain GPS locations */
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();
        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_get_lat_long, menu);
        return true;
    }
    
    /* Class My Location Listener */
    public class MyLocationListener implements LocationListener
    {
    	
    	public void onLocationChanged(Location loc)
    	{
    		loc.getLatitude();
    		loc.getLongitude();
    		String Text = "My current location is: " +
    				"Latitud = " + loc.getLatitude() +
    				"Longitud = " + loc.getLongitude();
    		Toast.makeText( getApplicationContext(),
    				Text,
    				Toast.LENGTH_SHORT).show();
    	}

    	
    	public void onProviderDisabled(String provider)
    	{
    		Toast.makeText( getApplicationContext(),
    				"Gps Disabled",
    				Toast.LENGTH_SHORT ).show();
    	}

    	
    	public void onProviderEnabled(String provider)
    	{
    		Toast.makeText( getApplicationContext(),
    				"Gps Enabled",
    				Toast.LENGTH_SHORT).show();
    	}

    	
    	public void onStatusChanged(String provider, int status, Bundle extras)
    	{

    	}
    }/* End of Class MyLocationListener */
}
