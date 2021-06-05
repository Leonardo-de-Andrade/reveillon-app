package com.leonardoandrade.reveillon.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.leonardoandrade.reveillon.R;
import com.leonardoandrade.reveillon.constant.ReveillonConstants;
import com.leonardoandrade.reveillon.data.SercurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SercurityPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mPreferences = new SercurityPreferences(this);
        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked() == true) {
                this.mPreferences.storeString(ReveillonConstants.PRESENCE_KEY, ReveillonConstants.CONFIRMATION_YES);
            } else {
                this.mPreferences.storeString(ReveillonConstants.PRESENCE_KEY, ReveillonConstants.CONFIRMATION_NO);
            }
        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(ReveillonConstants.PRESENCE_KEY);
            if (presence != null && presence == ReveillonConstants.CONFIRMATION_YES) {
                this.mViewHolder.checkParticipate.setChecked(true);
            } else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}