package nhacks16.flow;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.ErrorManager;

public class userSignUp extends AppCompatActivity implements View.OnClickListener {

    Button butSignUp;
    EditText ETName, ETUserName, ETPassword, ETConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        butSignUp = (Button) findViewById(R.id.butSignUp);
        ETName = (EditText) findViewById(R.id.ETName);
        ETUserName = (EditText) findViewById(R.id.ETUserName);
        ETPassword= (EditText) findViewById(R.id.ETPassword);
        ETConfirmPassword = (EditText) findViewById(R.id.ETConfirmPassword);


        butSignUp.setOnClickListener(this);
    }

    @Override
    /* Must implement before Override */
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.butSignUp:
                if (ETPassword != ETConfirmPassword) {

                }
                else {
                    String name = ETName.getText().toString();
                    String username = ETUserName.getText().toString();
                    String password = ETPassword.getText().toString();
                    User registeredData = new User( name, username, password);
                    break;
                }
        }
    }
}
