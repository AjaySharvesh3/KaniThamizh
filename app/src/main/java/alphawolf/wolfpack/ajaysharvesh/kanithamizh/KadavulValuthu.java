package alphawolf.wolfpack.ajaysharvesh.kanithamizh;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class KadavulValuthu extends AppCompatActivity {

    private ViewPager viewPager ;
    private SlideAdapter mySlider ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kadavul_valuthu);

        viewPager = (ViewPager) findViewById(R.id.viewPager) ;
        mySlider = new SlideAdapter(this) ;
        viewPager.setAdapter(mySlider);
    }
}
