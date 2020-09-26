package in.rittz.mobileguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

 //   private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

     //   sessionManager = new SessionManager(SplashActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
            /*    if (sessionManager.isLoggedIn()) {
                    intent = new Intent(SplashActivity.this, HomePageActivity.class);
                    intent.putExtra("is_from", "splash");
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.putExtra("is_from", "splash");
                }
            */
                intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}