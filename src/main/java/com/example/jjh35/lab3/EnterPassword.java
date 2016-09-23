package com.example.jjh35.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.View;

/*
 * Jesse Hulse, jjh35. lab3
 */

public class EnterPassword extends AppCompatActivity {
private String password = "password";
private EditText passwordField;
private TextView invalidPassword;
private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
        //get the different fields by their ids
        passwordField = ( EditText ) findViewById( R.id.password );
        picture = ( ImageView ) findViewById(R.id.picture);
        invalidPassword = ( TextView ) findViewById(R.id.invalidText );
        //set these fields to invisible
        picture.setVisibility( View.INVISIBLE );
        invalidPassword.setVisibility( View.INVISIBLE );

        /**
         * This is an action listener for the password text field. When the user hits enter
         * it will display a picture with no error message if the password is correct
         * Otherwise it will print an "invalid password" error
         *
         * @var TextView, the textView in question
         */

            passwordField.setOnEditorActionListener( new TextView.OnEditorActionListener()
            {
                @Override
                public boolean onEditorAction( TextView v, int actionId, KeyEvent event )
                {
                    if ( passwordField.getText().toString().equals( password ) )
                    {
                        //password is correct, display pic
                        picture.setVisibility( View.VISIBLE );
                        invalidPassword.setVisibility( View.INVISIBLE );
                        return true;
                    }
                    else
                    {
                        //password is incorrect show error
                        picture.setVisibility( View.INVISIBLE );
                        invalidPassword.setVisibility( View.VISIBLE );
                    }

                    return false;
                }
            });

        }

}
