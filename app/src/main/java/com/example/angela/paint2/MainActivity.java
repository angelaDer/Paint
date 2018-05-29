package com.example.angela.paint2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    private PaintView paintView;
    private SeekBar mSizeBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = (PaintView) findViewById(R.id.paintView);
        mSizeBar = (SeekBar) findViewById(R.id.BrushSize);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
        mSizeBar.setProgress(20);
        mSizeBar.setOnSeekBarChangeListener(this);

            }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        Toast.makeText(getApplicationContext(),"Size set to: "+progress, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        paintView.setBrushSize(seekBar.getProgress());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.normal:
                paintView.normal();
                return true;
            case R.id.blur:
                paintView.blur();
                return true;
            case R.id.clear:
                paintView.clear();
                return true;
            case R.id.color:
                //paintView.color();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this); // Why? :(
                alertDialogBuilder.setTitle("Choose a color");
                final CharSequence[] items = { "Red", "Green", "Blue" };

                alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) { // not working!
                        switch (item) {
                            case 0:
                                // PaintView.mPaint.setColor(Color.RED);
                                paintView.setCurrentColor(Color.RED);
                                break;
                            case 1:
                               // PaintView.mPaint.setColor(Color.GREEN);
                                paintView.setCurrentColor(Color.GREEN);
                                break;
                            case 2:
                               // PaintView.mPaint.setColor(Color.BLUE);
                                paintView.setCurrentColor(Color.BLUE);
                                break;
                        }
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
        }

        return super.onOptionsItemSelected(item);

    }
}