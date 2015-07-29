package com.restaurant.tracking.githubprojectsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jmolsmobile.landscapevideocapture.VideoCaptureActivity;


public class MainActivity extends AppCompatActivity {

    private static final int RESULT_CAPTURE_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button viewById = (Button) findViewById(R.id.cameraButton);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                takeAPhoto();


            }
        });
    }

    private void takeAPhoto() {

//        Capture configuration = CaptureConfiguration(CaptureResolution resolution, CaptureQuality quality);
//        Capture configuration = CaptureConfiguration(CaptureResolution resolution, CaptureQuality quality, int maxDurationSecs, int maxFilesizeMb);
//        Capture configuration = CaptureConfiguration(int videoWidth, int videoHeight, int bitrate);
//        Capture configuration = CaptureConfiguration(int videoWidth, int videoHeight, int bitrate, int maxDurationSecs, int maxFilesizeMb);


        final Intent intent = new Intent(this, VideoCaptureActivity.class);
        intent.putExtra(VideoCaptureActivity.EXTRA_CAPTURE_CONFIGURATION, false);
        intent.putExtra(VideoCaptureActivity.EXTRA_OUTPUT_FILENAME, true);
        startActivityForResult(intent, RESULT_CAPTURE_IMAGE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_CAPTURE_IMAGE://拍照
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "RESULT_CAPTURE_IMAGE", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
