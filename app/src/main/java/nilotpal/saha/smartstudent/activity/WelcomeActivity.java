package nilotpal.saha.smartstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import nilotpal.saha.smartstudent.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        student = (ImageView) findViewById(R.id.student_logo);
        student.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == student){
            startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
        }
    }
}
