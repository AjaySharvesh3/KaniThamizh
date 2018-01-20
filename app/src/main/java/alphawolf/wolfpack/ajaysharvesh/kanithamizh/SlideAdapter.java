package alphawolf.wolfpack.ajaysharvesh.kanithamizh;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ajays on 1/13/2018.
 */

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int [] images = {
            R.drawable.imgone,
            R.drawable.imgtwo,
            R.drawable.imgthree,
            R.drawable.imgfour,
    };

    String [] title = {
            "Title1", "Title2", "Title3", "Title4",
    };

    String [] desc = {
            "desc1", "desc2", "desc3", "desc4",
    };

    public int [] background = {
            Color.rgb(99, 88, 103),
            Color.rgb(199, 88, 103),
            Color.rgb(99, 188, 103),
            Color.rgb(99, 88, 155),
    };

    public SlideAdapter(Context context) {
        this.context = context ;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;
        View view = layoutInflater.inflate(R.layout.slide, container, false) ;
        LinearLayout layoutSlide = (LinearLayout) view.findViewById(R.id.slideLinearLayout) ;
        ImageView imgSlide = (ImageView) view.findViewById(R.id.image1) ;
        TextView textSlide = (TextView) view.findViewById(R.id.t1) ;
        TextView textSlide1 = (TextView) view.findViewById(R.id.t2) ;
        layoutSlide.setBackgroundColor(background[position]) ;
        imgSlide.setImageResource(images[position]) ;
        textSlide.setText(title[position]) ;
        textSlide1.setText(desc[position]) ;
        container.addView(view) ;
        return view ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }
}
