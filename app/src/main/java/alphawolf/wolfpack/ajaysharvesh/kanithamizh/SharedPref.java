package alphawolf.wolfpack.ajaysharvesh.kanithamizh;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ajays on 1/13/2018.
 */

public class SharedPref {

    SharedPreferences sharedPreferences;

    public SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE) ;
    }

    //It will save the night mode state
    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = sharedPreferences.edit() ;
        editor.putBoolean("NightMode", state) ;
        editor.commit() ;
    }

    public Boolean loadNightModeState() {
        Boolean state = sharedPreferences.getBoolean("NightMode", false) ;
        return state;
    }
}
