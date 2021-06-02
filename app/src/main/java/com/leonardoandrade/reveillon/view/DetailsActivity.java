package com.leonardoandrade.reveillon.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.leonardoandrade.reveillon.R;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticepate = findViewById(R.id.check_participate);


    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        CheckBox checkParticepate;
        Button buttonConfirm;


    }
}