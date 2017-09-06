package nilotpal.saha.smartstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import nilotpal.saha.smartstudent.app.ForumListView;
import nilotpal.saha.smartstudent.helper.ParseJSONforum;

public class ForumActivity extends AppCompatActivity implements View.OnClickListener{

//    public static final String JSON_URL = "http://192.168.0.4/smartfs/datafromforum.php";

    private Button buttonGet;
    private Button send;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        buttonGet = (Button) findViewById(R.id.buttonRefreshForum);
        send = (Button) findViewById(R.id.buttonSend);
        buttonGet.setOnClickListener(this);
        send.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listViewForum);
        sendRequest();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonGet){
            sendRequest();
        }
        if (v == send){
            //Send Query to Server
            startActivity(new Intent(ForumActivity.this,UpdateQueryActivity.class));
        }
    }

    private void sendRequest() {
        StringRequest stringRequest = new StringRequest(AppConfig.URL_FORUM, new Response.Listener<String>() {
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(ForumActivity.this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json) {
        ParseJSONforum pj = new ParseJSONforum(json);
        pj.parseJSONforum();
        ForumListView cl = new ForumListView(this, ParseJSONforum.ids,ParseJSONforum.query, ParseJSONforum.answer);
        listView.setAdapter(cl);
    }

}
