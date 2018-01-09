package skylab.zeng.td_beacon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;


import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import skylab.zeng.td_beacon.Application.MyApplication;
import skylab.zeng.td_beacon.Bean.Beacon;
import skylab.zeng.td_beacon.R;


public class MyAdapter extends  RecyclerView.Adapter implements View.OnClickListener{
	MyApplication application;
	Context context;
	private ArrayList<Beacon> led_list;
	Canvas canvas;
	private Paint paint;
	public MyAdapter(Context context,MyApplication application) {
		this .application=application;
		paint=new Paint();
		this.context=context;
		led_list=new ArrayList<Beacon>();
	}
	public  void clean(){
		led_list.clear();
		notifyDataSetChanged();
	}





	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
		Beacon beacon=led_list.get(i);
		ViewHolder mviewHolder=(ViewHolder) viewHolder;

	}

	@Override
	public int getItemCount() {
		return led_list == null ? 0 : led_list.size();
	}
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.myview, viewGroup, false);
		// 实例化viewholder
		ViewHolder viewHolder = new ViewHolder(v);
		return viewHolder;
	}
	public static class ViewHolder extends RecyclerView.ViewHolder {
		TextView txt_address;
		ImageView ima_led;
		Bitmap bitmap;
		public ViewHolder(View itemView) {
			super(itemView);


		}
	}

	@Override
	public void onClick(View view)
	{

	}




}
