package com.piotrmajcher.piwind.piwindmobile.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.piotrmajcher.piwind.piwindmobile.ApplicationController;
import com.piotrmajcher.piwind.piwindmobile.R;
import com.piotrmajcher.piwind.piwindmobile.config.CONFIG;
import com.piotrmajcher.piwind.piwindmobile.services.AuthService;
import com.piotrmajcher.piwind.piwindmobile.services.impl.AuthServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getName();
    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView register;
    private AuthService authService;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RequestQueue requestQueue = ApplicationController.getInstance(getApplicationContext()).getRequestQueue();
        authService = new AuthServiceImpl(requestQueue);
        initViews();
        intent = getIntent();
        loginButton.setOnClickListener(v -> handleLoginRequest());
        register.setOnClickListener(v -> startRegistrationActivity());
    }

    private void startRegistrationActivity() {
        Intent intentRegistration = new Intent(this, RegistrationActivity.class);
        startActivity(intentRegistration);
    }

    private void handleLoginRequest() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        validateCredentials(username, password);
    }

    private void saveCredentials(String email, String password) {
        SharedPreferences sp = getSharedPreferences(CONFIG.LOGIN_PREFERENCES_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(CONFIG.USERNAME, email);
        editor.putString(CONFIG.PASSWORD_KEY, password);
        editor.putBoolean(CONFIG.IS_USER_AUTHORIZED_KEY, true);
        editor.apply();
    }


    private void startActivityBasedOnIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        Intent stationsListIntent = new Intent(this, StationsListActivity.class);
     
        if (extras != null && extras.containsKey(CONFIG.ID_KEY) && extras.containsKey(CONFIG.NAME_KEY) && extras.containsKey(CONFIG.URL_KEY)) {
            stationsListIntent.putExtra(CONFIG.ID_KEY, extras.getString(CONFIG.ID_KEY));
            stationsListIntent.putExtra(CONFIG.NAME_KEY, extras.getString(CONFIG.NAME_KEY));
            stationsListIntent.putExtra(CONFIG.URL_KEY, extras.getString(CONFIG.URL_KEY));
            startActivity(stationsListIntent);
        }
        startActivity(stationsListIntent);
        finishLoginActivity();

    }

    private void finishLoginActivity() {
        finish();
    }

    private void validateCredentials(String username, String password) {
        if (username.length() == 0 || password.length() == 0) {
            // TODO set error label text
        } else {
            try {
                authService.login(
                        username,
                        password,
                        response -> handleResponse(username, password, response),
                        this::handleError
                );
            } catch (JSONException e) {
                Log.e(TAG, "Could not send request");
            }
        }
    }

    private void handleError(VolleyError error) {
        // TODO set error label text
        Log.e(TAG, "error: " + new String(error.networkResponse.data));
    }

    private void handleResponse(String username, String password, JSONObject response) {
        try {
            String token = response.getString("token");
            saveCredentials(username, password);
            ApplicationController.getInstance(getApplicationContext()).setToken(token);
            startActivityBasedOnIntent(intent);
        } catch (JSONException e) {
            //TODO set error label text
            Log.e(TAG, "Could not parse response");
        }
    }

    private void initViews() {
        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        loginButton = (Button) findViewById(R.id.login_button);
        register = (TextView) findViewById(R.id.register_text);
    }
}
