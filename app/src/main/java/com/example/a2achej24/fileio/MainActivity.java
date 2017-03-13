package com.example.a2achej24.fileio;

import android.app.AlertDialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.savetext) {
            // react to the menu item being selected...
            try
            {
                PrintWriter pw =
                        new PrintWriter( new FileWriter (Environment.getExternalStorageDirectory().getAbsolutePath() + "/edittext.txt"));

                EditText et = (EditText)findViewById(R.id.edittext);

                pw.println("It's a nice day!");
                pw.close(); // close the file to ensure data is flushed to file
            }
            catch(IOException e)
            {
                new AlertDialog.Builder(this).setMessage("ERROR: " + e).
                        setPositiveButton("OK", null).show();
            }
            return true;
        }
        else if (item.getItemId() == R.id.loadtext) {
            // react to the menu item being selected...
            return true;
        }
    }


@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main)

}
}
