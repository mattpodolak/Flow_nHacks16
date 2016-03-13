package nhacks16.flow;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    Button butLogout;
    EditText ETUserName, ETName;
    UserLocalStorage userLocalStorage; //Landing must have access to local store

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        butLogout = (Button) findViewById(R.id.butLogout);
        ETName = (EditText) findViewById(R.id.ETName);
        ETUserName = (EditText) findViewById(R.id.ETUserName);

        butLogout.setOnClickListener(this);

        userLocalStorage = new UserLocalStorage(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate() == true) {
            displayUserDetails();
        }else{
            startActivity(new Intent(LandingActivity.this, UserLogin.class));
        }
    }

    private boolean authenticate() {
        return userLocalStorage.getUserLoggedIn();
        // Returns true if user logged in
    }

    private void displayUserDetails() {
        User user = userLocalStorage.getLoggedInUser();

        ETUserName.setText(user.username);
        ETName.setText(user.name);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butLogout:
                userLocalStorage.clearUserData();
                userLocalStorage.setUserLoggedIn(false);
                // If logged out clear data and destroy sessions

                startActivity(new Intent(this, UserLogin.class));
                break;
        }
    }

}
