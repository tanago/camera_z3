//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.configuration.parameters;

import android.graphics.Path;
import android.os.Environment;

import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.sonyericsson.android.camera.configuration.parameters.CapturingMode;
import com.sonyericsson.android.camera.configuration.parameters.ParameterApplicable;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValue;
import com.sonyericsson.android.camera.configuration.parameters.Resolution;
import com.sonyericsson.android.camera.util.capability.CapabilityList;
import com.sonyericsson.android.camera.util.capability.HardwareCapability;
import com.tanago.camera.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lanchon.dexpatcher.annotation.*;

@DexReplace
public enum Iso implements ParameterValue {
    ISO_200(-1, R.string.cam_strings_iso_200_txt, "iso-prio", 200),
    ISO_400(-1, R.string.cam_strings_iso_400_txt, "iso-prio", 400),
    ISO_AUTO(-1, 2131296677, "auto", -1);

    //public static final String TAG = "Iso";
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
        CapabilityList var5 = HardwareCapability.getCapability(mode.getCameraId());
        List var6 = (List)var5.ISO.get();
        try{
            FileWriter fileWriter = new FileWriter(Environment.getExternalStorageDirectory());
            fileWriter.write(var6.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Iso[] isos = {ISO_AUTO,ISO_200,ISO_400};
        return  isos;
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

    @DexReplace
    public int getParameterKeyTextId() {
        return sParameterTextId;
    }

    @DexIgnore
    public String getParameterName() {
        return this.getClass().getName();
    }

    @DexReplace
    public ParameterValue getRecommendedValue(ParameterValue[] var1, ParameterValue var2) {
        return ISO_200;
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
