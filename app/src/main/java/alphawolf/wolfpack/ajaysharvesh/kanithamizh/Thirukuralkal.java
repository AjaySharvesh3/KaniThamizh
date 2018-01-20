package alphawolf.wolfpack.ajaysharvesh.kanithamizh;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Thirukuralkal extends AppCompatActivity {

    //private ViewPager viewPager ;
    //private SlideAdapter mySlider ;

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirukuralkal);

        listView = (ListView) findViewById(R.id.listview);
        CustomAdaptor adapter = new CustomAdaptor(this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /**Intent intent = new Intent(getApplicationContext(), TopicList.class);
                 intent.putExtra("Position", position);

                 startActivity(intent); */

                if (position == 0) {
                    Intent i = new Intent(view.getContext(), KadavulValuthu.class);
                    startActivityForResult(i, 0);
                }

        /*viewPager = (ViewPager) findViewById(R.id.viewPager) ;
        mySlider = new SlideAdapter(this) ;
        viewPager.setAdapter(mySlider); */
            }

            });

    }
}