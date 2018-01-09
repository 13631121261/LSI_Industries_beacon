package skylab.zeng.td_beacon.View;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public interface IMainView {
    void startScan();
    void stopScan();
    void stopScaned();
    void onEmpty();
    void refreshAdapter();

}
