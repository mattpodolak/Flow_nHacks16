package nhacks16.flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserLogin extends AppCompatActivity implements View.OnClickListener {

    /* The views for the activity */
    Button butLogIn;
    EditText ETUserName, ETPassword;
    TextView TVSignUpLink;
    UserLocalStorage userLocalStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        /* Searches for XML view with these id */
        ETUserName = (EditText) findViewById(R.id.ETUserName);
        ETPassword = (EditText) findViewById(R.id.ETPassword);
        butLogIn = (Button) findViewById(R.id.butLogIn);
        TVSignUpLink = (TextView) findViewById(R.id.TVSignUpLink);

        butLogIn.setOnClickListener(this); // Listen for clicks
        TVSignUpLink.setOnClickListener(this);

        userLocalStorage = new UserLocalStorage(this);
    }

    /* When Login clicked, Method is notified */
    @Override
    public void onClick(View v) {
        // View var 'v' is arg to switch
            /* Equiv to:
                if(v.getId() == R.id.butLogIn) { Then }
            */

        switch(v.getId()){
            case R.id.butLogIn:
                User user = new User(null, null, null);
                // When user logs in, local Db must be alerted
                // that user session is active AND must start storing data
                // for user

                userLocalStorage.setUserLoggedIn(true);
                userLocalStorage.storeUserData(user);


                break;

            //Called when registered link clicked
            case R.id.TVSignUpLink:

                //startActivity is built in
                startActivity(new Intent(this,userSignUp.class));
                break;
        }
    }
}
