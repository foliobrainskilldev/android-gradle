package org.example.myapplication;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean flashLigado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFlash = findViewById(R.id.btnFlash);

        final CameraManager cameraManager =
                (CameraManager) getSystemService(CAMERA_SERVICE);

        btnFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String cameraId = cameraManager.getCameraIdList()[0];

                    if (!flashLigado) {
                        cameraManager.setTorchMode(cameraId, true);
                        flashLigado = true;
                    } else {
                        cameraManager.setTorchMode(cameraId, false);
                        flashLigado = false;
                    }

                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
