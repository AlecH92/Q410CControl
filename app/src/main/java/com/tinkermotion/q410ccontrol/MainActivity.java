package com.tinkermotion.q410ccontrol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                try {
                    String Command = "echo 0 > /sys/class/leds/bt/brightness";
                    Process su = Runtime.getRuntime().exec("su -c "+Command);
                    su.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

        Switch switchBT = (Switch) findViewById(R.id.switchBT);
        switchBT.setChecked(getState("/sys/class/leds/bt/brightness"));
        switchBT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setState("echo 5 > /sys/class/leds/bt/brightness");
                } else {
                    setState("echo 0 > /sys/class/leds/bt/brightness");
                }
            }
        });
        Switch switchWIFI = (Switch) findViewById(R.id.switchWIFI);
        switchWIFI.setChecked(getState("/sys/class/leds/wlan/brightness"));
        switchWIFI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setState("echo 5 > /sys/class/leds/wlan/brightness");
                } else {
                    setState("echo 0 > /sys/class/leds/wlan/brightness");
                }
            }
        });
        Switch switchLED1 = (Switch) findViewById(R.id.switchled1);
        switchLED1.setChecked(getState("/sys/class/leds/led1/brightness"));
        switchLED1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setState("echo 5 > /sys/class/leds/led1/brightness");
                } else {
                    setState("echo 0 > /sys/class/leds/led1/brightness");
                }
            }
        });
        Switch switchLED2 = (Switch) findViewById(R.id.switchled2);
        switchLED2.setChecked(getState("/sys/class/leds/led2/brightness"));
        switchLED2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setState("echo 5 > /sys/class/leds/led2/brightness");
                } else {
                    setState("echo 0 > /sys/class/leds/led2/brightness");
                }
            }
        });
        Switch switchLED3 = (Switch) findViewById(R.id.switchled3);
        switchLED3.setChecked(getState("/sys/class/leds/led3/brightness"));
        switchLED3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setState("echo 5 > /sys/class/leds/led3/brightness");
                } else {
                    setState("echo 0 > /sys/class/leds/led3/brightness");
                }
            }
        });
        Switch switchBoot = (Switch) findViewById(R.id.switchBoot);
        switchBoot.setChecked(getState("/sys/class/leds/boot/brightness"));
        switchBoot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setState("echo 5 > /sys/class/leds/boot/brightness");
                } else {
                    setState("echo 0 > /sys/class/leds/boot/brightness");
                }
            }
        });
        /*Switch switchPIN5 = (Switch) findViewById(R.id.switchPIN5);
        switchPIN5.setChecked(getState("/sys/class/gpio/gpio902/value"));
        switchPIN5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gpioSetup(902);
                    setState("echo 1 > /sys/class/gpio/gpio902/value");
                } else {
                    setState("echo 0 > /sys/class/gpio/gpio902/value");
                }
            }
        });*/
        Switch switchPIN23 = (Switch) findViewById(R.id.switchPIN23);
        switchPIN23.setChecked(getState("/sys/class/gpio/gpio938/value"));
        switchPIN23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gpioSetup(938);
                    setState("echo 1 > /sys/class/gpio/gpio938/value");
                } else {
                    setState("echo 0 > /sys/class/gpio/gpio938/value");
                }
            }
        });
        Switch switchPIN24 = (Switch) findViewById(R.id.switchPIN24);
        switchPIN24.setChecked(getState("/sys/class/gpio/gpio914/value"));
        switchPIN24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gpioSetup(914);
                    setState("echo 1 > /sys/class/gpio/gpio914/value");
                } else {
                    setState("echo 0 > /sys/class/gpio/gpio914/value");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setState(String command) {
        try {
            Process su = Runtime.getRuntime().exec("su -c " + command);
            su.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getState(String command) {
        int value = 0;
        FileReader gpioExport = null;
        try {
            gpioExport = new FileReader(command);
            value = gpioExport.read()-'0';
            Log.d("q410c", Integer.toString(value));
            gpioExport.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value > 0;
    }

    public int getStateInt(String command) {
        int value = 0;
        FileReader gpioExport = null;
        try {
            gpioExport = new FileReader(command);
            Log.d("q410c", Integer.toString(value));
            gpioExport.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void gpioSetup(int theGPIO) {
        if(getStateInt("/sys/class/gpio/gpio" + theGPIO + "/direction") == -1) {
            setState("echo " + theGPIO + " > /sys/class/gpio/export");
            setState("echo out > /sys/class/gpio/gpio" + theGPIO + "/direction");
        }
    }
}
