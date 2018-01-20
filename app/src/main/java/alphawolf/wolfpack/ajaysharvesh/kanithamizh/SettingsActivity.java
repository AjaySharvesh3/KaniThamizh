package alphawolf.wolfpack.ajaysharvesh.kanithamizh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private Switch mySwitch ;

    SharedPref sharedPref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this) ;

        if(sharedPref.loadNightModeState() == true) {
            setTheme(R.style.darkTheme) ;
        } else
            setTheme(R.style.AppTheme) ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mySwitch = (Switch) findViewById(R.id.mySwitch) ;
        if(sharedPref.loadNightModeState() == true) {
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) ;
                    sharedPref.setNightModeState(true) ;
                    restartApp() ;
                } else{
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) ;
                    sharedPref.setNightModeState(false) ;
                    restartApp() ;
                }
            }
        });
    }
    public void restartApp () {
        Intent i = new Intent(getApplicationContext(), SettingsActivity.class) ;
        startActivity(i) ;
        finish() ;
    }
}
