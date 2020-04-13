package ro.pub.cs.systems.eim.Colocviu1_13.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ro.pub.cs.systems.eim.Colocviu1_13.R;
import ro.pub.cs.systems.eim.Colocviu1_13.general.Constants;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {
    private EditText editText;
    private Button registerButton;
    private Button cancelButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_secondary);

        editText = (EditText)findViewById(R.id.editText);
        registerButton = (Button)findViewById(R.id.register_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);

        editText.setText("0");

        registerButton.setOnClickListener(buttonClickListener);
        cancelButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.HISTORY))
            editText.setText(intent.getStringExtra(Constants.HISTORY));
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.register_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }
}
