package com.mobiletraderv.paul.daggertraining.ui.quest;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mobiletraderv.paul.daggertraining.BaseActivity;
import com.mobiletraderv.paul.daggertraining.R;
import com.mobiletraderv.paul.daggertraining.ui.main.MainActivity;
import com.mobiletraderv.paul.daggertraining.ui.mainoutlet.MainOutletActivity;
import com.mobiletraderv.paul.daggertraining.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestActivity extends BaseActivity {

    private static final String TAG = "QuestActivity";

    Bundle bundle;

    String  contactnumbber;

    String  contactphone;

    String  outletaddress;

    int  outletid;

    String  outletname;

    int  repid;

    String  urno;

    int  userid;

    @BindView(R.id.u_phone)
    TextView u_phone;

    @BindView(R.id.cost_name)
    TextView cost_name;

    @BindView(R.id.cust_address)
    TextView cust_address;

    @BindView(R.id.q_one_sp)
    Spinner q_1;

    @BindView(R.id.q_two_sp)
    Spinner q_2;

    @BindView(R.id.q_three_inpute)
    EditText q_3;

    @BindView(R.id.q_four_sp)
    Spinner q_4;

    @BindView(R.id.q_five_sp)
    Spinner q_5;

    @BindView(R.id.q_six_sp)
    Spinner q_6;

    @BindView(R.id.q_seven_sp)
    Spinner q_7;

    @BindView(R.id.q_eight_sp)
    Spinner q_8;

    @BindView(R.id.q_nine_sp)
    Spinner q_9;

    @BindView(R.id.q_nine_inpute)
    EditText q_9_b;

    @BindView(R.id.q_ten_sp)
    Spinner q_10;

    @BindView(R.id.q_ten_inpute)
    EditText q_10_b;

    @BindView(R.id.q_eleven_sp)
    Spinner q_11;

    @BindView(R.id.q_eleven_inpute)
    EditText q_11_b;

    @Inject
    ViewModelProviderFactory providerFactory;

    private QuestViewModel viewModel;

    @BindView(R.id.login_button)
    Button login_button;

    @BindView(R.id.back_page)
    ImageView back_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quest);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        showProgressBar(false);
        viewModel = ViewModelProviders.of(this, providerFactory).get(QuestViewModel.class);

        if (bundle != null) {
            contactnumbber = bundle.getString("CONTN");
            contactphone = bundle.getString("CONTP");
            outletaddress = bundle.getString("OUTLETADD");
            outletid = bundle.getInt("OUTLETID");
            outletname = bundle.getString("OUTLETN");
            repid = bundle.getInt("REPID");
            urno = bundle.getString("URNO");
            userid = bundle.getInt("USERID");
        }

        setDatails();
        login_button.setOnClickListener(v -> {
            showProgressBar(true);
            initDetailsPush();
        });
        observer();

        back_page.setOnClickListener(view -> {
            onBackPressed();
        });
    }


    public void initDetailsPush(){
        String q_1_a = q_1.getSelectedItem().toString();
        String q_2_q = q_2.getSelectedItem().toString();
        String q_3_q = q_3.getText().toString();
        String q_4_q = q_4.getSelectedItem().toString();
        String q_5_q = q_5.getSelectedItem().toString();
        String q_6_q = q_6.getSelectedItem().toString();
        String q_7_q = q_7.getSelectedItem().toString();
        String q_8_q = q_8.getSelectedItem().toString();
        String q_9_q = q_9.getSelectedItem().toString();
        String q_9_q_b = q_9_b.getText().toString();
        String q_10_q = q_10.getSelectedItem().toString();
        String q_10_q_b = q_10_b.getText().toString();
        String q_11_q = q_11.getSelectedItem().toString();
        String q_11_q_b = q_11_b.getText().toString();

        viewModel.observersCustomers(outletid,repid,userid,q_1_a,q_2_q,q_3_q,q_4_q,q_5_q,
                q_6_q,q_7_q,q_8_q,q_9_q,q_9_q_b,q_10_q,q_10_q_b,q_11_q,q_11_q_b);

    }

    public void setDatails() {
        u_phone.setText("->: "+contactphone);
        cost_name.setText("->: "+outletname);
        cust_address.setText("->: "+outletaddress);
    }

    public void observer() {
        viewModel.observeresponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s.equals("200")){
                    showProgressBar(true);
                    showAlertDialog();
                }
            }
        });
    }

    public void showAlertDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Successful")
                .setCancelable(false)
                .setMessage("Report Successfully entered")
                .setNegativeButton("Ok", (paramDialogInterface, paramInt) -> {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                });
        dialog.show();
    }


}
