package org.example.myapplication;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isFlashOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFlash = findViewById(R.id.btnFlash);

        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        btnFlash.setOnClickListener(v -> {
            try {
                String cameraId = cameraManager.getCameraIdList()[0];
                isFlashOn = !isFlashOn;
                cameraManager.setTorchMode(cameraId, isFlashOn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
