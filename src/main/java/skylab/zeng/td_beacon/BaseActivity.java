package skylab.zeng.td_beacon;

import android.app.Activity;
import android.os.Bundle;

import skylab.zeng.td_beacon.Presenter.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter> extends Activity {

    protected T basepresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        basepresenter = initPresent();
        onPrepare();
    }

   public  abstract T initPresent();

    public  abstract int getLayout();

    public  abstract void initView();

    public  abstract void onPrepare();
}
