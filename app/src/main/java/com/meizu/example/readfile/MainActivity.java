package com.meizu.example.readfile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;


public class MainActivity extends Activity {
    private static final String FILEPATH = "/proc/1/status";
    private TextView mFirstByteContent;
    private String mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirstByteContent = (TextView)findViewById(R.id.first_byte_content);
        File mFile = new File(FILEPATH);
        if(!mFile.exists()){
            mContent = "No File.";
        }else {
            try {
                mContent = "" + (char)ReadFile.readFirstByte(mFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mFirstByteContent.setText(mContent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
