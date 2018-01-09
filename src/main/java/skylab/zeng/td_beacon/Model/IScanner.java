package skylab.zeng.td_beacon.Model;

//import no.nordicsemi.android.support.v18.scanner.ScanResult;

import android.bluetooth.le.ScanResult;

/**
 * Created by Administrator on 2018/1/4 0004.
 */

public interface IScanner {
        void startScan(ScanCallback callback);
        void stopScan();

        interface ScanCallback{
                void onScanResult(ScanResult result);
                void onScanFailed(int errorCode);
        }
}
