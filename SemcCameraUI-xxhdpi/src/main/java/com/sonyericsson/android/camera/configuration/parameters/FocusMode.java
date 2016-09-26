package com.sonyericsson.android.camera.configuration.parameters;

import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.tanago.camera.R;

import lanchon.dexpatcher.annotation.DexIgnore;


/**
 * Created by tanago on 27.9.2016 г..
 */
@DexIgnore
public enum FocusMode implements ParameterValue {

    FACE_DETECTION(-1, 2131296532, "continuous-picture", "continuous-video", "center", true),
    FIXED(-1, 2131296537, "fixed", "fixed", "center", false),
    INFINITY(-1, 2131296537, "infinity", "infinity", "center", true),
    MULTI(-1, 2131296535, "macro", "macro", "multi", true),
    OBJECT_TRACKING(-1, 2131296536, "continuous-picture", "continuous-video", "center", true),
    SINGLE(-1, 2131296537, "continuous-picture", "continuous-video", "center", true),
    TOUCH_FOCUS(-1, 2131296539, "continuous-picture", "continuous-video", "center", true),
    MACRO(-1, R.string.cam_strings_focus_mode_macro_txt, "macro", "macro", "center", true);

    public static final String TAG = "FocusMode";
    private static final int sParameterTextId = 2131296540;
    private final int mIconId;
    private final int mTextId;
    private String mValue;
    private String mValueForVideo;
    private final String mFocusArea;
    private final boolean mSuccessSound;

    private FocusMode(int mIconId, int mTextId, String mValue, String mValueForVideo, String mFocusArea, boolean mSuccessSound){
        this.mIconId=mIconId;
        this.mTextId=mTextId;
        this.mValue=mValue;
        this.mValueForVideo=mValueForVideo;
        this.mFocusArea=mFocusArea;
        this.mSuccessSound=mSuccessSound;
    }

    @Override
    public void apply(ParameterApplicable parameterApplicable) {

    }

    @Override
    public int getIconId() {
        return 0;
    }

    @Override
    public ParameterKey getParameterKey() {
        return ParameterKey.FOCUS_MODE;
    }

    @Override
    public int getParameterKeyTextId() {
        return sParameterTextId;
    }

    @Override
    public String getParameterName() {
        return null;
    }

    @Override
    public ParameterValue getRecommendedValue(ParameterValue[] parameterValues, ParameterValue parameterValue) {
        return null;
    }

    @Override
    public int getTextId() {
        return this.mTextId;
    }

    @Override
    public String getValue() {
        return null;
    }

    public static ParameterValue getDefaultValue(CapturingMode mode) {

    return null;}

    public static FocusMode[] getOptions(CapturingMode capturingMode) {
        return null;
    }
}
