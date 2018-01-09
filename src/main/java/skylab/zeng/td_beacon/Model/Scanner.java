package skylab.zeng.td_beacon.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class Scanner implements IScanner {
    ScanCallback callback;
    @Override
    public void startScan(ScanCallback callback) {}/*{
        {
             this.callback=callback;

            final BluetoothLeScannerCompat scanner =
                    BluetoothLeScannerCompat.getScanner();
            final ScanSettings settings =
                    new ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).setUseHardwareFilteringIfSupported(false).build();
            final List<ScanFilter> filters = new ArrayList<>();
            //filters.add(new ScanFilter.Builder().setServiceUuid(uuid).build());
            try {
                scanner.startScan(null,settings,scanCallback);

                System.out.println("开始扫描");
            } catch (Exception e) {
                System.out.println("已经运行");
            }
        }
    }*/

    @Override
    public void stopScan() {}/*{

            final BluetoothLeScannerCompat scanner =
                    BluetoothLeScannerCompat.getScanner();
            scanner.stopScan(scanCallback);

    }*/
/*
    private no.nordicsemi.android.support.v18.scanner.ScanCallback scanCallback = new no.nordicsemi.android.support.v18.scanner.ScanCallback() {
        @Override
        public void onScanResult(final int callbackType, final ScanResult result) {
;
            callback.onScanResult(result);
        }

        @Override
        public void onBatchScanResults(final List<ScanResult> results) {
            System.out.println("多次结果="+results.get(0).getDevice().getAddress());
        }


        @Override
        public void onScanFailed(final int errorCode) {
            callback.onScanFailed(errorCode);
        }
    };*/
}
