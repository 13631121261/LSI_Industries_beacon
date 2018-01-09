package skylab.zeng.td_beacon.service;


import android.app.Activity;

import no.nordicsemi.android.dfu.BuildConfig;
import no.nordicsemi.android.dfu.DfuBaseService;
import skylab.zeng.td_beacon.NotificationActivity;

/**
 * Created by Administrator on 2017/12/26 0026.
 */

public class MyService extends DfuBaseService {
    @Override
    protected Class<? extends Activity> getNotificationTarget() {
        return NotificationActivity.class;
    }
    @Override
    protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
