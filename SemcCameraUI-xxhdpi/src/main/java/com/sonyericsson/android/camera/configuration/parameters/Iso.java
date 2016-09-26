//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.configuration.parameters;


import android.os.Environment;

import com.sonyericsson.android.camera.CameraActivity;
import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.sonyericsson.android.camera.configuration.parameters.CapturingMode;
import com.sonyericsson.android.camera.configuration.parameters.ParameterApplicable;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValue;
import com.sonyericsson.android.camera.configuration.parameters.Resolution;
import com.sonyericsson.android.camera.device.CameraDevice;
import com.sonyericsson.android.camera.util.capability.CapabilityItem;
import com.sonyericsson.android.camera.util.capability.CapabilityList;
import com.sonyericsson.android.camera.util.capability.HardwareCapability;
import com.tanago.camera.R;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lanchon.dexpatcher.annotation.*;

@DexReplace
public enum Iso implements ParameterValue {
    ISO_AUTO(-1, R.string.cam_strings_settings_auto_txt, "auto", -1),
    ISO_50(-1, R.string.cam_strings_iso_50_txt, "iso-prio", 50),
    ISO_64(-1, R.string.cam_strings_iso_64_txt, "iso-prio", 64),
    ISO_80(-1, R.string.cam_strings_iso_80_txt, "iso-prio", 80),
    ISO_100(-1, R.string.cam_strings_iso_100_txt, "iso-prio", 100),
    ISO_125(-1, R.string.cam_strings_iso_125_txt, "iso-prio", 125),
    ISO_160(-1, R.string.cam_strings_iso_160_txt, "iso-prio", 160),
    ISO_200(-1, R.string.cam_strings_iso_200_txt, "iso-prio", 200),
    ISO_400(-1, R.string.cam_strings_iso_400_txt, "iso-prio", 400),
    ISO_800(-1, R.string.cam_strings_iso_800_txt, "iso-prio", 800),
    ISO_1600(-1, R.string.cam_strings_iso_1600_txt, "iso-prio", 1600),
    ISO_3200(-1, R.string.cam_strings_iso_3200_txt, "iso-prio", 3200),
    ISO_6400(-1, R.string.cam_strings_iso_6400_txt, "iso-prio", 6400),
    ISO_10000(-1, R.string.cam_strings_iso_10000_txt, "iso-prio", 10000),
    ISO_12800(-1, R.string.cam_strings_iso_12800_txt, "iso-prio", 12800);

    public static final String TAG = "Iso";
    private static final int sParameterTextId = R.string.cam_strings_iso_txt;
    private final String mAeMode;
    private final int mIconId;
    private final int mIsoValue;
    private final int mTextId;

    @DexIgnore
    private Iso(int n2, int n3, String string2, int n4) {
        this.mIconId = n2;
        this.mTextId = n3;
        //TODO remove AE from ISO class
        this.mAeMode = string2;
        this.mIsoValue = n4;
    }

    @DexReplace
    public static Iso[] getOptions(CapturingMode mode, Resolution resolution) {
        CapabilityList list = HardwareCapability.getCapability(mode.getCameraId());

        CapabilityItem[] test = {list.VIDEO_NR_VALUES, list.MAX_VIDEO_FRAME, list.METERING, list.HDR, list.FOCUS_MODE, list.MAX_NUM_FOCUS_AREA, list.FOCUS_AREA , list.MAX_MULTI_FOCUS_AREAS , list.MULTI_FOCUS_RECTS};
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Environment.getExternalStorageDirectory().getPath() + "/cameratest.txt"));
            for(CapabilityItem capabilityItem : test){
                bufferedWriter.write(capabilityItem.getName() + " " + capabilityItem.get() + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        List<String> supportedISOs = list.ISO.get();
        Iso[] availableISOs = Iso.values();
        List<Iso> options = new ArrayList<>();
        //options.add(ISO_AUTO);
        for (Iso availableISO : availableISOs) {
            if (supportedISOs.contains(String.valueOf(availableISO.getIsoValue()))) {
                options.add(availableISO);
            }
        }
        return options.toArray(new Iso[0]);
    }

    @DexIgnore
    public static boolean isAlwaysChangeToAutoToResolveDependency() {
        return HardwareCapability.getInstance().getCameraExtensionVersion().isLaterThanOrEqualTo(1, 8);
    }

    @DexReplace
    public static boolean isExclusiveWith(Resolution var0) {
        return 5248 <= var0.getPictureRect().width();
    }

    @DexIgnore
    public void apply(ParameterApplicable var1) {
        var1.set(this);
    }

    @DexIgnore
    public int getIconId() {
        return this.mIconId;
    }

    @DexIgnore
    public int getIsoValue() {
        return this.mIsoValue;
    }

    @DexIgnore
    public ParameterKey getParameterKey() {
        return ParameterKey.ISO;
    }

    @DexIgnore
    public int getParameterKeyTextId() {
        return sParameterTextId;
    }

    @DexIgnore
    public String getParameterName() {
        return this.getClass().getName();
    }

    @DexIgnore
    public ParameterValue getRecommendedValue(ParameterValue[] var1, ParameterValue var2) {
        return ISO_400;
    }

    @DexIgnore
    public int getTextId() {
        return this.mTextId;
    }

    @DexIgnore
    public String getValue() {
        return this.mAeMode;
    }
}
