package logic.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demotxt.droidsrce.slide.R;

import data.DataRepo;

public class SlideAdapter extends PagerAdapter {

    private Context mActivityCtx;

    public SlideAdapter(Context mActivityCtx) {
        this.mActivityCtx = mActivityCtx;
    }

    @Override
    public int getCount() {
        return DataRepo.titles.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mActivityCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);

        onPrepareView(view);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


    private void onPrepareView(View view) {
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        layoutslide.setBackgroundColor(DataRepo.bgColors[position]);

        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        imgslide.setImageResource(DataRepo.images[position]);

        TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
        txttitle.setText(DataRepo.titles[position]);

        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        description.setText(DataRepo.descriptions[position]);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
