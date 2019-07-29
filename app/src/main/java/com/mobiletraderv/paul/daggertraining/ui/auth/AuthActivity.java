package com.mobiletraderv.paul.daggertraining.ui.auth;



import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.RequestManager;
import com.google.android.material.textfield.TextInputEditText;
import com.mobiletraderv.paul.daggertraining.BaseActivity;
import com.mobiletraderv.paul.daggertraining.R;
import com.mobiletraderv.paul.daggertraining.ui.main.MainActivity;
import com.mobiletraderv.paul.daggertraining.viewmodels.ViewModelProviderFactory;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;


public class AuthActivity extends BaseActivity {

    private static final String TAG = "AuthActivity";

    private AuthViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @BindView(R.id.login_button)
    Button login_button;


    @BindView(R.id.user_id_input)
    TextInputEditText user_id_input;

    @BindView(R.id.user_id_input_password)
    TextInputEditText user_id_input_password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        showProgressBar(false);
        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);

        login_button.setOnClickListener(v->{
            attemptLogin();
        });

       // setLogo();
        subscribeObervers();
    }

    private void setLogo()
    {
        requestManager
                .load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }

    private void subscribeObervers()
    {
        viewModel.getMediatorResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String data) {
                showProgressBar(false);
                String[] transData = data.split("\\~");
                if(transData[0].equals("200")){
                    onLoginSuccess();
                }else{
                    Log.d(TAG, "onerrors: "+"errors");
                    ErrorsDisplay(transData[1]);
                }
            }
        });
    }

    public void ErrorsDisplay(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void onLoginSuccess()
    {
        Log.d(TAG, "onLoginSuccess: login successful!");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    private void attemptLogin()
    {
        if(TextUtils.isEmpty(user_id_input.getText().toString())){
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(user_id_input_password.getText().toString())){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }else{
            showProgressBar(true);
           viewModel.authenticateWithUserCredential(user_id_input.getText().toString(),
                   user_id_input_password.getText().toString());
        }
    }


}
