package com.leonardoandrade.reveillon.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
        this.mViewHolder.checkParticepate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticepate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate) {
            if (this.mViewHolder.checkParticepate.isChecked() == true) {
                this.mPreferences.storeString(ReveillonConstants.PRESENCE_KEY, ReveillonConstants.CONFIRMATION_YES);
            } else {
                this.mPreferences.storeString(ReveillonConstants.PRESENCE_KEY, ReveillonConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        CheckBox checkParticepate;
        Button buttonConfirm;


    }
}