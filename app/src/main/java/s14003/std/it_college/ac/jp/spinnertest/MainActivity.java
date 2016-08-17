package s14003.std.it_college.ac.jp.spinnertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner productSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item);

        for (int i = 1; i <= 100/*ここに数量を入れる*/; i++) {
            adapter.add(String.valueOf(i));
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productSpinner = (Spinner) findViewById(R.id.productspinner);
        productSpinner.setAdapter(adapter);
        productSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner = (Spinner) adapterView;
                showToast(String.valueOf(productSpinner.getSelectedItem()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button buttonCheckSelected;
        buttonCheckSelected = (Button)findViewById(R.id.ButtonCheckSelected);
        buttonCheckSelected.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Spinner.getSelectedItemでSpinnerで選択された値を取得
                showToast((String)productSpinner.getSelectedItem());
            }
        });
    }
    //Toastで表示
        private void showToast(String str) {
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
}

