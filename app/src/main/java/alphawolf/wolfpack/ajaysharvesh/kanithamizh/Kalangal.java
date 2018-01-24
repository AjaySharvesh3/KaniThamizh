package alphawolf.wolfpack.ajaysharvesh.kanithamizh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Kalangal extends AppCompatActivity {

    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalangal);

        getSupportActionBar().setTitle("தமிழர் காலம்") ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true) ;

        imageView1 = (ImageView) findViewById(R.id.img1) ;

        String url1 = "https://firebasestorage.googleapis.com/v0/b/kanitamilperavai3.appspot.com/o/Folder1%2Fpicone.jpg?alt=media&token=d5bef62e-257b-44f9-9478-7ec50cf07cf5" ;


    }
}
