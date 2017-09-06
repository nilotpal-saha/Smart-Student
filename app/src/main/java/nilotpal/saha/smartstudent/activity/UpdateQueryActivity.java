package nilotpal.saha.smartstudent.activity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Hashtable;
import java.util.Map;

import nilotpal.saha.smartstudent.R;
import nilotpal.saha.smartstudent.app.AppConfig;

public class UpdateQueryActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button buttonUpdate;

    private EditText editTextQuery;

//    private String UPDATE_URL ="http://192.168.0.4/smartfs/datatodbforum.php";

    private String KEY_QUERY = "query";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_query);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

        editTextQuery = (EditText) findViewById(R.id.editTextQuery);
        buttonUpdate.setOnClickListener(this);
    }

    private void updateQueryServer(){
        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Updating...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_FORUM_UPDATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        try {
                            //Showing toast message of the response
                            Toast.makeText(UpdateQueryActivity.this, s , Toast.LENGTH_LONG).show();
                        }catch (Exception e){
                            Log.i("Volley_Response: ",e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();
                        try {
                            //Showing toast
                            Toast.makeText(UpdateQueryActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }catch (Exception e){
                            Log.i("Volley_error: ",e.toString());
                        }

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Getting Image Name
                String query = editTextQuery.getText().toString().trim();

                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_QUERY, query);

                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateQueryServer();
        }
    }
}
