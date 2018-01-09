package skylab.zeng.td_beacon.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import skylab.zeng.td_beacon.R;
import skylab.zeng.td_beacon.animation.ExpandAnimation;


/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class MyView extends LinearLayout implements View.OnClickListener{
    Button btn_onclick;
    LinearLayout linear_data;

    public MyView(Context context) {
        super(context);
        init(context);
    }
    public MyView(Context context, AttributeSet attrs) {
        super((Context)context, (AttributeSet)attrs);
        init(context);
    }
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super((Context)context, (AttributeSet)attrs, defStyleAttr);
        init(context);

    }
   void init(Context context){
       View view= (LinearLayout) View.inflate(context, R.layout.myview, this);
       btn_onclick=view.findViewById(R.id.btn_onckick);
       linear_data=view.findViewById(R.id.liner_data);
       btn_onclick.setOnClickListener(this);
   }

    @Override
    public void onClick(View view) {
        if(linear_data.getVisibility()==View.GONE){
            //��ʾ����
				/*telat_text.startAnimation(mShowAction);
				telat_text.setVisibility(View.VISIBLE); */

            ExpandAnimation expandAni = new ExpandAnimation(linear_data, 100,View.VISIBLE);

            // Start the animation on the toolbar
            linear_data.startAnimation(expandAni);
        }
        else{
            //���ض���
//				telat_text.startAnimation(mHiddenAction);
//				telat_text.setVisibility(View.GONE);
            ExpandAnimation expandAni = new ExpandAnimation(linear_data, 100,View.GONE);

            // Start the animation on the toolbar
            linear_data.startAnimation(expandAni);
        }
    }
}
