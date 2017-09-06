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
import nilotpal.saha.smartstudent.app.EventCustomNotification;
import nilotpal.saha.smartstudent.helper.ParseJSONevent;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

//    public static final String JSON_URL = "http://192.168.0.4/smartfs/datafromevent.php";

    private Button buttonGet;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        buttonGet = (Button) findViewById(R.id.EventbuttonRefresh);
        buttonGet.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.EventlistView);
        sendRequest();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            startActivity(new Intent(EventActivity.this,MainSActivity.class));
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
        StringRequest stringRequest = new StringRequest(AppConfig.URL_EVENT, new Response.Listener<String>() {
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(EventActivity.this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json) {
        ParseJSONevent pj = new ParseJSONevent(json);
        pj.parseJSONevent();
        EventCustomNotification cl = new EventCustomNotification(this, ParseJSONevent.ids,ParseJSONevent.sub,ParseJSONevent.about,ParseJSONevent.time);
        listView.setAdapter(cl);
    }

}
