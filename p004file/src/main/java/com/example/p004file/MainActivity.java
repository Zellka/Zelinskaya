package com.example.p004file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveText(View view) {
        FileOutputStream fos = null;
        try {
            Spinner processor = (Spinner) findViewById(R.id.spProcessor);
            Spinner monitor = (Spinner) findViewById(R.id.spMonitor);
            Spinner cases = (Spinner) findViewById(R.id.spCase);
            Spinner videoCard = (Spinner) findViewById(R.id.spVideoCard);
            Spinner hardDrive = (Spinner) findViewById(R.id.spHardDrive);

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            String text = processor.getSelectedItem().toString() + "\n" + monitor.getSelectedItem().toString()
                    + "\n" + cases.getSelectedItem().toString() + "\n" + videoCard.getSelectedItem().toString()
                    + "\n" + hardDrive.getSelectedItem().toString();

            fos.write(text.getBytes());
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openText(View view) {
        FileInputStream fin = null;
        TextView textView = (TextView) findViewById(R.id.tvCalculateSum);
        textView.setVisibility(View.VISIBLE);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text + "\n" + "1223 Р");
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}