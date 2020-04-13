package ro.pub.cs.systems.eim.Colocviu1_13.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ro.pub.cs.systems.eim.Colocviu1_13.R;
import ro.pub.cs.systems.eim.Colocviu1_13.general.Constants;

public class Colocviu1_13MainActivity​ extends AppCompatActivity {
    private EditText historyEditText;
    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private int clicksNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_main);

        historyEditText = (EditText)findViewById(R.id.history_editText);
        northButton = (Button)findViewById(R.id.north_button);
        southButton = (Button)findViewById(R.id.south_button);
        westButton = (Button)findViewById(R.id.west_button);
        eastButton = (Button)findViewById(R.id.east_button);

        northButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            clicksNo = savedInstanceState.getInt(Constants.CLICKS_NO);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(Constants.CLICKS_NO, clicksNo);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicksNo = savedInstanceState.getInt(Constants.CLICKS_NO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(this, "The activity returned with " + resultCode, Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, intent);
    }

    private void setHistoryEditText(String direction) {
        if (historyEditText.getText().toString().isEmpty())
            historyEditText.setText(direction);
        else
            historyEditText.setText(historyEditText.getText().toString() + "," + direction);
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.north_button:
                    setHistoryEditText(getResources().getString(R.string.north_button));
                    clicksNo += 1;
                    break;
                case R.id.south_button:
                    setHistoryEditText(getResources().getString(R.string.south_button));
                    clicksNo += 1;
                    break;
                case R.id.east_button:
                    setHistoryEditText(getResources().getString(R.string.east_button));
                    clicksNo += 1;
                    break;
                case R.id.west_button:
                    setHistoryEditText(getResources().getString(R.string.west_button));
                    clicksNo += 1;
                    break;
                case R.id.next_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_13SecondaryActivity.class);
                    intent.putExtra(Constants.HISTORY, historyEditText.getText().toString());
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    historyEditText.setText("");
                    clicksNo = 0;
                    break;
            }
            Toast.makeText(getApplicationContext(), clicksNo + "buttons pressed", Toast.LENGTH_LONG).show();
        }
    }
}
