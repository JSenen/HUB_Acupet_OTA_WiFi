package com.espressif;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.espressif.provisioning.ESPDevice;
import com.espressif.provisioning.ESPProvisionManager;
import com.espressif.ui.activities.EspMainActivity;
import com.espressif.wifi_provisioning.R;

public class SplashScreen extends AppCompatActivity {

    Button buttonOta, buttonWiFi;
    private SharedPreferences sharedPreferences;
    private ESPProvisionManager provisionManager;
    private ESPDevice espDevice;  // Añadir espDevice
    private TextView txtVersion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        buttonOta = findViewById(R.id.buttLaunchOTA);
        buttonWiFi = findViewById(R.id.buttLaunchWiFi);
        txtVersion = findViewById(R.id.txt_version);

        String version = "1.1.0";
        txtVersion.setText(version);

        provisionManager = ESPProvisionManager.getInstance(getApplicationContext());  // Inicializa ESPProvisionManager

        //Obtener la imagen
        ImageView imageView = findViewById(R.id.imageView);

        buttonOta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonWiFi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pasar información del dispositivo al intent
                Intent intent = new Intent(getApplicationContext(), EspMainActivity.class);
                startActivity(intent);
                finish();

            }
        });


        //Cargar animacion
        //Animation bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        //Aplicar la animacion
        //imageView.startAnimation(bounceAnimation);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 3000); // 3000 ms delay


    }
}