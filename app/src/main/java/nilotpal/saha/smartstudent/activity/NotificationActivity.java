package nilotpal.saha.smartstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import nilotpal.saha.smartstudent.R;
import nilotpal.saha.smartstudent.app.AppConfig;
import nilotpal.saha.smartstudent.app.CustomNotification;
import nilotpal.saha.smartstudent.helper.ParseJSON;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener{

//    public static final String JSON_URL = "http://192.168.0.4/smartfs/datafromdb.php";

    private Button buttonGet;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        buttonGet = (Button) findViewById(R.id.buttonRefresh);
        buttonGet.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
        sendRequest();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            startActivity(new Intent(NotificationActivity.this,MainSActivity.class));
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonGet){
            sendRequest();
        }
    }

    private void sendRequest() {
        StringRequest stringRequest = new StringRequest(AppConfig.URL_NOTIFICATION, new Response.Listener<String>() {
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(NotificationActivity.this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json) {
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomNotification cl = new CustomNotification(this, ParseJSON.ids,ParseJSON.sub,ParseJSON.about,ParseJSON.time);
        listView.setAdapter(cl);
    }

}
