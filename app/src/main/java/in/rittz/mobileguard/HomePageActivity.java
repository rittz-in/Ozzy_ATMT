package in.rittz.mobileguard;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.JsonElement;

import retrofit2.Call;

public class HomePageActivity extends AppCompatActivity {

    private CardView cardView1 ,cardView2;
    private DrawerLayout drawerLayout;
    boolean doubleBackToExitPressedOnce = false;

    Boolean mSlideState = false;
    private ImageView imgMenu;
   // private ApiInterface apiInterface;
  //  private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

  //      sessionManager = new SessionManager(HomePageActivity.this);
  //      apiInterface =  ApiClient.getApiClient().create(ApiInterface.class);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        imgMenu = (ImageView) findViewById(R.id.imgMenu);


        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(HomePageActivity.this, PlaceListActivity.class);
                intent.putExtra("category_id","1");
                startActivity(intent);*/
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(HomePageActivity.this, PlaceListActivity.class);
                intent.putExtra("category_id","2");
                startActivity(intent);*/
            }
        });
        listener();
    }

    private void listener() {
        drawerLayout.addDrawerListener(new ActionBarDrawerToggle(HomePageActivity.this, drawerLayout, 0, 0) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mSlideState = false;
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mSlideState = true;
            }
        });

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openCloseDrawerMenu();
            }
        });

    }
    @SuppressLint("WrongConstant")
    public void openCloseDrawerMenu()
    {
        if(mSlideState)
        {
            drawerLayout.closeDrawer(Gravity.START);
        }
        else
        {
            drawerLayout.openDrawer(Gravity.START);
        }
    }

    @Override
    public void onBackPressed()
    {
        if (doubleBackToExitPressedOnce)
        {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back button again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
