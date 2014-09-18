package com.litrgroup.litr;

import com.litrgroup.litr.LoginSignupActivity;
import com.litrgroup.litr.SignActivity;
import com.litrgroup.litr.Welcome;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View; 
import android.widget.Button;
import android.widget.EditText;


public class SignActivity extends Activity {
	 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Determine whether the current user is an anonymous user
		if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
			// If user is anonymous, send the user to LoginSignupActivity.class
			Intent intent = new Intent(SignActivity.this,
					LoginSignupActivity.class);
			startActivity(intent);
			finish();
		} else {
			// If current user is NOT anonymous user
			// Get current user data from Parse.com
			ParseUser currentUser = ParseUser.getCurrentUser();
			if (currentUser != null) {
				// Send logged in users to Welcome.class
				Intent intent = new Intent(SignActivity.this, Welcome.class);
				startActivity(intent);
				finish();
			} else {
				// Send user to LoginSignupActivity.class
				Intent intent = new Intent(SignActivity.this,
						LoginSignupActivity.class);
				startActivity(intent);
				finish();
			}
		}

	}


   
}
