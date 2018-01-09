package skylab.zeng.td_beacon.Bean;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class Beacon {
    int rssi;
    int major;
    int minor;
    String uuid;
    int Broadcast_interval;
    int rssi_level;
    String name;
    String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBroadcast_interval() {
        return Broadcast_interval;
    }

    public void setBroadcast_interval(int broadcast_interval) {
        Broadcast_interval = broadcast_interval;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getRssi() {
        return rssi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRssi_level() {
        return rssi_level;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getAddress() {
        return address;
    }

    public void setRssi_level(int rssi_level) {
        this.rssi_level = rssi_level;
    }

    public String getName() {
        return name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

}
