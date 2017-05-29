package com.ponthaitay.lifecycleactivity.googleio2017.lifecycle.javacode;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.TextView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.ponthaitay.lifecycleactivity.googleio2017.R;

import java.util.List;

public class MainActivity extends BaseLifecycleActivity {

    private static final String TAG = MainActivity.class.getName();
    private MyLocationManager locationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = new MyLocationManager(this, getLifecycle(), new MyLocationManager.MyLocationListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onLocationChange(Location location) {
                Log.d(TAG, location.toString());
                String result = String.format("%f / %f", location.getLatitude(), location.getLongitude());
                ((TextView) findViewById(R.id.tv_result)).setText(result);
            }

            @Override
            public void onProviderDisabled(String msg) {
                Log.d(TAG, msg);
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d(TAG, provider);
            }
        });

        checkPermissionLocation();
    }

    private void checkPermissionLocation() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (!hasDeniedPermission(report)) {
                            locationManager.locationEnable();
                        } else {
                            Snackbar.make(findViewById(R.id.container), report.toString(), Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {

                    }

                    private boolean hasDeniedPermission(MultiplePermissionsReport report) {
                        List<PermissionDeniedResponse> denyPermission = report.getDeniedPermissionResponses();
                        return denyPermission != null && denyPermission.size() > 0;
                    }
                });
    }
}
