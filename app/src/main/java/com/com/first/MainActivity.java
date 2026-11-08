package com.com.first;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int currentTipPercent = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etBillAmount = findViewById(R.id.etBillAmount);
        TextView tvTipPercentLabel = findViewById(R.id.tvTipPercentLabel);
        SeekBar seekBarTip = findViewById(R.id.seekBarTip);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvResult = findViewById(R.id.tvResult);

        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentTipPercent = progress;
                tvTipPercentLabel.setText("Чаевые: " + currentTipPercent + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String billString = etBillAmount.getText().toString();

                if (billString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Пожалуйста, введите сумму чека", Toast.LENGTH_SHORT).show();
                    return;
                }

                double billAmount = Double.parseDouble(billString);

                double tipAmount = billAmount * (currentTipPercent / 100.0);
                double totalAmount = billAmount + tipAmount;

                tvResult.setText(String.format("Чаевые: %.2f\nИтого к оплате: %.2f", tipAmount, totalAmount));
            }
        });

    }
}