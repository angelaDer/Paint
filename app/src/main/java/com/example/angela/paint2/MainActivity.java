package com.example.angela.paint2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.*;


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
            case R.id.save:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Enter a name");
                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_TEXT );
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = input.getText().toString();
                        paintView.saveImage(name);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

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
                pickColor();
        }

        return super.onOptionsItemSelected(item);

    }
    public void pickColor() {
        final AlertDialog.Builder colorDialog = new AlertDialog.Builder(this);

        final LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.colors_rgb, (ViewGroup) findViewById(R.id.color_layout));
        colorDialog.setTitle("Choose RGB color");
        colorDialog.setView(view);


        //Log.d("lol",String.valueOf(colorCheck.getWidth()));
        final SeekBar seekR = (SeekBar) view.findViewById(R.id.r_color);
        seekR.setProgress(50);
        seekR.setMax(255);
        seekR.setKeyProgressIncrement(1);
        final SeekBar seekG = (SeekBar) view.findViewById(R.id.g_color);
        final SeekBar seekB = (SeekBar) view.findViewById(R.id.b_color);
        //final LinearLayout colorCheck = (LinearLayout) findViewById(R.id.color_check);

        seekR.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                paintView.setRGB(seekR.getProgress(),seekG.getProgress(),seekB.getProgress());
        }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekG.setMax(255);
        seekG.setKeyProgressIncrement(1);
        seekG.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                paintView.setRGB(seekR.getProgress(),seekG.getProgress(),seekB.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekB.setMax(255);
        seekB.setKeyProgressIncrement(1);
        seekB.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                paintView.setRGB(seekR.getProgress(),seekG.getProgress(),seekB.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        colorDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        colorDialog.show();

    }

}