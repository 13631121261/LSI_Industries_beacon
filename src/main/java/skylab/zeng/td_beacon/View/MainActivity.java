package skylab.zeng.td_beacon.View;


//import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import skylab.zeng.td_beacon.Adapter.MyAdapter;
import skylab.zeng.td_beacon.Application.MyApplication;
import skylab.zeng.td_beacon.BaseActivity;
import skylab.zeng.td_beacon.Presenter.BasePresenter;
import skylab.zeng.td_beacon.Presenter.MainPresenter;
import skylab.zeng.td_beacon.R;

public class MainActivity<T extends BasePresenter> extends BaseActivity implements IMainView,View.OnClickListener{
    RecyclerView recyclerView;
    MyApplication application;
    MyAdapter adapter;
    TextView txt_title;
    ImageButton btn_back,btn_memu;

   public  MainPresenter initPresent(){
            return  new MainPresenter();
     }


    public int getLayout(){
         return R.layout.activity_main;
     }

    public void initView(){
     recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        txt_title=(TextView)findViewById(R.id.txt_title);
        btn_back=(ImageButton)findViewById(R.id.btn_back);
        btn_memu=(ImageButton)findViewById(R.id.btn_memu);
        btn_back.setOnClickListener(this);
        btn_memu.setOnClickListener(this);

}


    public void onPrepare(){
        application=(MyApplication) getApplication();
        adapter=new MyAdapter(this,application);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void startScan() {

    }

    @Override
    public void stopScan() {

    }

    @Override
    public void stopScaned() {

    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onEmpty() {
        adapter.clean();
    }

    @Override
    public void onClick(View view) {

    }
}
