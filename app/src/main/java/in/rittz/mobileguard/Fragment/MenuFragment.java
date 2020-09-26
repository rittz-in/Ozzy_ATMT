package in.rittz.mobileguard.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.rittz.mobileguard.EmergencyContactActivity;
import in.rittz.mobileguard.ProfileActivity;
import in.rittz.mobileguard.R;


public class MenuFragment extends Fragment
{
    LinearLayout tv1;
    LinearLayout tv2;
    LinearLayout tv3;
    LinearLayout tv4;
    LinearLayout tv5;

    Context context;

  //  SessionManager sessionManager;
 //   private ApiInterface apiInterface;

    ImageView imgProfile;
    TextView tvName,tvEmail;

    View view2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        tv1 = (LinearLayout) view.findViewById(R.id.lMenu1);
        tv2 = (LinearLayout) view.findViewById(R.id.lMenu2);
        tv3 = (LinearLayout) view.findViewById(R.id.lMenu3);
        tv4 = (LinearLayout) view.findViewById(R.id.lMenu4);
        tv5 = (LinearLayout) view.findViewById(R.id.lMenu5);

        view2 = (View) view.findViewById(R.id.view2);

    //    sessionManager = new SessionManager(context);
    //    apiInterface =  ApiClient.getApiClient().create(ApiInterface.class);

        tvName = (TextView) view.findViewById(R.id.tvName);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvEmail.setVisibility(View.GONE);
        imgProfile = (ImageView) view.findViewById(R.id.imgUser);

    //    tvName.setText("Welcome, \n"+sessionManager.getUserName());

    /*    Glide.with(getActivity())
                .load(sessionManager.getPhoto())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .placeholder(R.drawable.user_default)
                .into(imgProfile);

        tvEmail.setText(sessionManager.getEmail());

        if(sessionManager.getUserType().equals("un-registered"))
        {
            view2.setVisibility(View.GONE);
            tv5.setVisibility(View.GONE);
        }
*/
        listener();
        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

     /*   if(sessionManager.getUserType().equals("un-registered"))
        {
            view2.setVisibility(View.GONE);
            tv5.setVisibility(View.GONE);
        }
        else
        {
            view2.setVisibility(View.VISIBLE);
            tv5.setVisibility(View.VISIBLE);
            Glide.with(getActivity())
                    .load(sessionManager.getPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .placeholder(R.drawable.user_default)
                    .into(imgProfile);
            tvName.setText("Welcome, \n"+sessionManager.getUserName());

        }*/
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

   private void listener()
    {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(context, ProfileActivity.class));
                /*if(!sessionManager.getUserType().equals("un-registered"))
                {
                    startActivity(new Intent(context, ProfileActivity.class));
                }
                else
                {
                    Intent i = new Intent(context, LoginActivity.class);
                    i.putExtra("is_from","splash");
                    startActivity(i);
                }*/
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(context, EmergencyContactActivity.class));
                /*if(!sessionManager.getUserType().equals("un-registered"))
                {
                    startActivity(new Intent(context, TransactionsActivity.class));
                }
                else
                {
                    Intent i = new Intent(context, LoginActivity.class);
                    i.putExtra("is_from","splash");
                    startActivity(i);
                }*/
            }
        });

        /*tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(context, SupportActivity.class));

            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(context, AboutActivity.class));
            }
        });*/


        tv5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Uninstall?");
                builder.setMessage("Are you sure want to Uninstall? ");
                builder.setPositiveButton("Uninstall", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        /*ClearDeviceID();
                        sessionManager.logout();
                        Intent i = new Intent(context, LoginActivity.class);
                        i.putExtra("is_from","splash");
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        ((Activity)context).finish();*/
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }


  /*private void ClearDeviceID()
    {
        Call<JsonElement> call = apiInterface.DeviceIdReset(sessionManager.getId());

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {


                try {
                    Log.e("response", response.body().toString());

                    JSONArray jsonArray = new JSONArray(response.body().toString());
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String code = jsonObject.getString("status");
                    Log.e("response", code);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("response", t.getMessage());
            }
        });
    }
*/
}
