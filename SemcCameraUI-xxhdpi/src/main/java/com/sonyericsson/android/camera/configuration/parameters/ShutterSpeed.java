package com.sonyericsson.android.camera.configuration.parameters;

import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.tanago.camera.R;

/**
 * Created by tanago on 23.9.2016 г..
 */

public enum ShutterSpeed implements ParameterValue {
    //SHUTTER_SPEED_AUTO(-1, R.string.cam_strings_settings_auto_txt, -1),
    SHUTTER_SPEED0(-1, R.string.cam_strings_shutter_speed_0_txt, 0),
    SHUTTER_SPEED1(-1, R.string.cam_strings_shutter_speed_1_txt, 1),
    SHUTTER_SPEED2(-1, R.string.cam_strings_shutter_speed_2_txt, 2),
    SHUTTER_SPEED3(-1, R.string.cam_strings_shutter_speed_3_txt, 3),
    SHUTTER_SPEED4(-1, R.string.cam_strings_shutter_speed_4_txt, 4),
    SHUTTER_SPEED5(-1, R.string.cam_strings_shutter_speed_5_txt, 5),
    SHUTTER_SPEED6(-1, R.string.cam_strings_shutter_speed_6_txt, 6),
    SHUTTER_SPEED7(-1, R.string.cam_strings_shutter_speed_7_txt, 7),
    SHUTTER_SPEED8(-1, R.string.cam_strings_shutter_speed_8_txt, 8),
    SHUTTER_SPEED9(-1, R.string.cam_strings_shutter_speed_9_txt, 9),
    SHUTTER_SPEED10(-1, R.string.cam_strings_shutter_speed_10_txt, 10),
    SHUTTER_SPEED11(-1, R.string.cam_strings_shutter_speed_11_txt, 11),
    SHUTTER_SPEED12(-1, R.string.cam_strings_shutter_speed_12_txt, 12);

    public static final String TAG = "Shutter Speed";
    private static final int sParameterTextId = R.string.cam_strings_shutter_speed_title_txt;
    private final int mIconId;
    private final int mTextId;
    private final int mShutterSpeedValue;


    private ShutterSpeed(int i1, int i2, int i3) {
        this.mIconId = i1;
        this.mTextId = i2;
        this.mShutterSpeedValue = i3;
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
        return ParameterKey.SHUTTER_SPEED;
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
        return SHUTTER_SPEED7;
    }

    @Override
    public int getTextId() {
        return this.mTextId;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.mShutterSpeedValue);
    }

    public static ShutterSpeed[] getOptions(CapturingMode capturingMode) {
        //TODO capturingMode impl
        return values();
    }
}
