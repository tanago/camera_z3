package com.sonyericsson.android.camera.configuration.parameters;

import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.tanago.camera.R;

/**
 * Created by tanago on 25.9.2016 г..
 */

public enum CameraMode implements ParameterValue {
    AUTO(-1, R.string.cam_strings_camera_mode_auto_txt, "auto"),
    ISO_PRIO(-1, R.string.cam_strings_camera_mode_iso_prio_txt, "iso-prio"),
    SHUTTER_PRIO(-1, R.string.cam_strings_camera_mode_shutter_prio_txt, "shutter-prio"),
    MANUAL(-1, R.string.cam_strings_camera_mode_manual_txt, "manual");

    public static final String TAG = "Camera Mode";
    private static final int sParameterTextId = R.string.cam_strings_camera_modes_title_txt;
    private final int mIconId;
    private final int mTextId;
    private final String mCameraModeValue;

    private CameraMode(int iconId, int textId, String value){
        this.mIconId=iconId;
        this.mTextId=textId;
        this.mCameraModeValue=value;
    }

    @Override
    public void apply(ParameterApplicable parameterApplicable) {
        parameterApplicable.set(this);
    }

    @Override
    public int getIconId() {
        return this.mIconId;
    }

    @Override
    public ParameterKey getParameterKey() {
        return ParameterKey.CAMERA_MODE;
    }

    @Override
    public int getParameterKeyTextId() {
        return sParameterTextId;
    }

    @Override
    public String getParameterName() {
        return this.getClass().getName();
    }

    @Override
    public ParameterValue getRecommendedValue(ParameterValue[] parameterValues, ParameterValue parameterValue) {
        return AUTO;
    }

    @Override
    public int getTextId() {
        return this.mTextId;
    }

    @Override
    public String getValue() {
        return this.mCameraModeValue;
    }
}
