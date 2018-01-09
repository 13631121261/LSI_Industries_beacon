package skylab.zeng.td_beacon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;

import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceController;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;
import skylab.zeng.td_beacon.service.MyService;

public class DfuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
       // DfuServiceInitiator.createDfuNotificationChannel(this);
    }
    public void start(){

        final DfuServiceInitiator starter = new DfuServiceInitiator("CA:C8:F9:23:30:27")
                .setDeviceName("TD03_CAC8F9233027")
                .setKeepBond(false);
// If you want to have experimental buttonless DFU feature supported call additionally:
        starter.setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
// but be aware of this: https://devzone.nordicsemi.com/question/100609/sdk-12-bootloader-erased-after-programming/
// and other issues related to this experimental service.

// Init packet is required by Bootloader/DFU from SDK 7.0+ if HEX or BIN file is given above.
// In case of a ZIP file, the init packet (a DAT file) must be included inside the ZIP file.

           starter.setZip(null, Environment.getExternalStorageDirectory()+"/tencent/qqfile_recv/B0092_V1.03_APP.zip");
      //  starter.setZip(null, Environment.getExternalStorageDirectory()+"/tencent/qqfile_recv/B0096_App_V1.03.zip");
        final DfuServiceController controller = starter.start(this, MyService.class);
// You may use the controller to pause, resume or abort the DFU process.

    }
    private final DfuProgressListener mDfuProgressListener = new DfuProgressListenerAdapter() {
        @Override
        public void onDeviceConnecting(final String deviceAddress) {
         System.out.println("连接中");
        }

        @Override
        public void onDfuProcessStarting(final String deviceAddress) {
            System.out.println("进行中");
        }

        @Override
        public void onError(String deviceAddress, int error, int errorType, String message) {
            super.onError(deviceAddress, error, errorType, message);
            System.out.println("错误中");
        }
        @Override
        public void onDeviceConnected(final String deviceAddress) {
            // empty default implementation
            System.out.println("连接成功");
        }
        @Override
        public void onFirmwareValidating(final String deviceAddress) {
            // empty default implementation
            System.out.println("认证固件");
        }
        @Override
        public void onDfuCompleted(final String deviceAddress) {
            // empty default implementation
            System.out.println("onDfuCompleted？成功？》");
        }
        @Override
        public void onDeviceDisconnected(final String deviceAddress) {
            // empty default implementation
            System.out.println("主动断开连接");
        }
        ///...
    };

    @Override
    protected void onResume() {
        super.onResume();
        DfuServiceListenerHelper.registerProgressListener(this, mDfuProgressListener);
    }
    @Override
    protected void onPause() {
        super.onPause();

        DfuServiceListenerHelper.unregisterProgressListener(this, mDfuProgressListener);
    }
}
