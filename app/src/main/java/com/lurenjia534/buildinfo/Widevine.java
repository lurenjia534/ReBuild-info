package com.lurenjia534.buildinfo;

import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import java.util.UUID;

public class Widevine {
    private static final UUID WIDEVINE_UUID = new UUID(0xEDEF8BA979D64ACEL, 0xA3C827DCD51D21EDL);
    public class WidevineInfo {
        public String vendor;
        public String version;
        public String drmLevel;

        public WidevineInfo(String vendor, String version, String drmLevel){
            this.vendor = vendor;
            this.version = version;
            this.drmLevel = drmLevel;
        }
    }
    public WidevineInfo getWidevineInfo() {
        try {
            MediaDrm mediaDrm = new MediaDrm(WIDEVINE_UUID);
            String vendor = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VENDOR);
            String version = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VERSION);
            String drmLevel = mediaDrm.getPropertyString(("securityLevel"));
            return new WidevineInfo(vendor, version, drmLevel);
        } catch (UnsupportedSchemeException e) {
            return new WidevineInfo("Widevine not supported", "", "");
        }
    }


}
