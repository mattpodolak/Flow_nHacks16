package nhacks16.flow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLogin extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_user_login);

        final EditText ETUserName = (EditText) findViewById(R.id.ETUserName);
        final EditText ETPassword = (EditText) findViewById(R.id.ETPassword);
        Button butLogin = (Button) findViewById(R.id.butLogIn);
        final TextView TVSignUpLink = (TextView) findViewById(R.id.TVSignUpLink);

        butLogin.setOnClickListener(new OnClickListener() {

                                        @Override
                                        public void onClick(View v) {
                                            String userName = ETUserName.getText().toString();
                                            String password = ETPassword.getText().toString();

                                            //case R.id.butLogIn:
                                            try {
                                                if (userName.length() > 0 && password.length() > 0) {
                                                    DBUserAdapter dbUser = new DBUserAdapter(UserLogin.this);
                                                    dbUser.open();

                                                    if (dbUser.Login(userName, password)) {
                                                        Toast.makeText(UserLogin.this, "Successfully Logged In", Toast.LENGTH_LONG).show();

                                                    } else {
                                                        Toast.makeText(UserLogin.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                                                    }
                                                    dbUser.close();
                                                }

                                            } catch (Exception e) {
                                                Toast.makeText(UserLogin.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });

            TVSignUpLink.setOnClickListener(new OnClickListener() {
                    public void onClick(View t) {
                        // case R.id.TVSignUpLink:
                        //startActivity is built in
                        Intent myIntent = new Intent(UserLogin.this, userSignUp.class);
                        startActivity(myIntent);
                    }
            });

        }
    }