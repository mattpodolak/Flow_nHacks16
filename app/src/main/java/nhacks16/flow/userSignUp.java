package nhacks16.flow;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.ErrorManager;

public class userSignUp extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        final EditText ETName = (EditText) findViewById(R.id.ETName);
        final EditText ETUserName = (EditText) findViewById(R.id.ETUserName);
        final EditText ETPassword = (EditText) findViewById(R.id.ETPassword);
        final EditText ETConfirmPassword = (EditText) findViewById(R.id.ETConfirmPassword);
        Button butSignUp = (Button) findViewById(R.id.butSignUp);

        butSignUp.setOnClickListener(new View.OnClickListener() {

            //Override necessary for this to work
            @Override
            public void onClick(View v) {
                final String name = ETName.getText().toString();
                final String userName = ETUserName.getText().toString();
                final String password = ETPassword.getText().toString();
                final String confirm = ETConfirmPassword.getText().toString();

                if (password.length() < 6) {
                    Toast.makeText(userSignUp.this, "Password must be more than 6 characters.", Toast.LENGTH_LONG).show();
                }

                else if (name.equals(" ")) {
                    Toast.makeText(userSignUp.this, "You must enter a name!", Toast.LENGTH_LONG).show();
                }

                else if (!password.equals(confirm)) {
                    Toast.makeText(userSignUp.this, "Your passwords must match.", Toast.LENGTH_LONG).show();
                }
                else if (userName.equals(" ")) {
                    Toast.makeText(userSignUp.this, "You need an e-mail address!", Toast.LENGTH_LONG).show();
                }

                else {
                    DBUserAdapter newUser = new DBUserAdapter(userSignUp.this);
                    //newUser.open();
                    newUser.AddUser(userName, password);
                    //Toast.makeText(userSignUp.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                    //Intent i = new Intent(userSignUp.this, LandingActivity.class);
                            //Add Matt's feature too!!!!
                }

            }
        });
    }
}