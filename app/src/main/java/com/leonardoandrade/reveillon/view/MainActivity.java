package com.leonardoandrade.reveillon.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leonardoandrade.reveillon.R;
import com.leonardoandrade.reveillon.constant.ReveillonConstants;
import com.leonardoandrade.reveillon.data.SercurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SercurityPreferences mPreferences;
    private static final SimpleDateFormat SIMPLES_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mPreferences = new SercurityPreferences(this);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.dias));
        this.mViewHolder.textToday.setText(SIMPLES_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        this.mViewHolder.textDaysLeft.setText(daysLeft);

        this.verifyPresence();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm) {
            String presence = this.mPreferences.getStoreString(ReveillonConstants.PRESENCE_KEY);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(ReveillonConstants.PRESENCE_KEY, presence);
            startActivity(intent);
        }
    }

    private void verifyPresence() {
        String presence = this.mPreferences.getStoreString(ReveillonConstants.PRESENCE_KEY);
        if (presence.equals("")) {
            this.mViewHolder.buttonConfirm.setText(R.string.nao_confirmado);
        } else if (presence.equals(ReveillonConstants.CONFIRMATION_YES)) {
            this.mViewHolder.buttonConfirm.setText(R.string.sim);
        } else {
            this.mViewHolder.buttonConfirm.setText(R.string.nao);
        }
    }

    private int getDaysLeft() {
        return Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR) - Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }
}