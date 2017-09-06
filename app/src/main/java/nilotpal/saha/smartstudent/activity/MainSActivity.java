package nilotpal.saha.smartstudent.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import nilotpal.saha.smartstudent.R;
import nilotpal.saha.smartstudent.helper.SQLiteHandler;
import nilotpal.saha.smartstudent.helper.SessionManager;

public class MainSActivity extends Activity implements View.OnClickListener{

	private TextView txtName;
	private TextView txtEmail;
	private Button buttonExamUpdates;
	private Button btnEvent;
	private Button btnForum;
	private Button btnLogout;

	private SQLiteHandler db;
	private SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_s);

		txtName = (TextView) findViewById(R.id.name);
		txtEmail = (TextView) findViewById(R.id.email);
		btnLogout = (Button) findViewById(R.id.btnLogout);
		buttonExamUpdates = (Button) findViewById(R.id.buttonNotification);
		btnEvent = (Button) findViewById(R.id.buttonEvent);
		btnForum = (Button) findViewById(R.id.buttonForum);

		// SqLite database handler
		db = new SQLiteHandler(getApplicationContext());

		// session manager
		session = new SessionManager(getApplicationContext());

		if (!session.isLoggedIn()) {
			logoutUser();
		}

		// Fetching user details from SQLite
		HashMap<String, String> user = db.getUserDetails();

		String name = user.get("name");
		String email = user.get("email");

		// Displaying the user details on the screen
		txtName.setText(name);
		txtEmail.setText(email);

		// Logout button click event
		btnLogout.setOnClickListener(this);
		buttonExamUpdates.setOnClickListener(this);
		btnEvent.setOnClickListener(this);
		btnForum.setOnClickListener(this);
	}

	private void logoutUser() {
		session.setLogin(false);

		db.deleteUsers();

		// Launching the login activity
		Intent intent = new Intent(MainSActivity.this, LoginActivity.class);
		startActivity(intent);
		finish();
	}

	/**
	 * Logging out the user. Will set isLoggedIn flag to false in shared
	 * preferences Clears the user data from sqlite users table
	 * */

	@Override
	public void onClick(View v) {
		if (v == buttonExamUpdates){
			Intent notification = new Intent(MainSActivity.this,NotificationActivity.class);
			startActivity(notification);
			finish();
		}
		if(v == btnLogout){
             logoutUser();
		}
		if (v == btnEvent){
			Intent event = new Intent(MainSActivity.this, EventActivity.class);
			startActivity(event);
			finish();
		}
		if (v == btnForum){
			//Start Forum Activity
			startActivity(new Intent(MainSActivity.this, ForumActivity.class));
			finish();
		}
	}

}
