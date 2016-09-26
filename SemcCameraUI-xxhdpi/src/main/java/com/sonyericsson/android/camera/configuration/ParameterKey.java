//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.configuration;

import android.content.Context;

import com.sonyericsson.android.camera.configuration.ParameterCategory;
import com.sonyericsson.android.camera.configuration.ParameterSelectability;
import com.sonyericsson.android.camera.configuration.parameters.CapturingMode;
import com.sonyericsson.android.camera.configuration.parameters.Flash;
import com.sonyericsson.android.camera.configuration.parameters.VideoStabilizer;
import com.sonyericsson.cameracommon.utility.ResourceUtil;
import com.tanago.camera.R;

import lanchon.dexpatcher.annotation.*;

@DexReplace
public enum ParameterKey {
    AUTO_REVIEW(true, true, ParameterCategory.COMMON, 2131296590),
    VIDEO_AUTO_REVIEW(true, false, ParameterCategory.CAPTURING_MODE, 2131296601),
    AUTO_UPLOAD(false, true, ParameterCategory.COMMON, 2131296379),
    BURST_SHOT(true, false, ParameterCategory.CAPTURING_MODE, 2131296563),
    CAPTURING_MODE(true, false, ParameterCategory.CAPTURING_MODE, 2131296403),
    DESTINATION_TO_SAVE(true, true, ParameterCategory.COMMON, 2131296631),
    EV(true, false, ParameterCategory.CAPTURING_MODE, 2131296502),
    FACING(false, false, ParameterCategory.CAPTURING_MODE, 2131296388),
    FAST_CAPTURE(true, true, ParameterCategory.COMMON, 2131296518),
    FLASH(true, true, ParameterCategory.COMMON, 2131296529),
    FOCUS_MODE(true, false, ParameterCategory.CAPTURING_MODE, 2131296538),
    GEO_TAG(true, true, ParameterCategory.COMMON, 2131296542),
    HDR(true, false, ParameterCategory.CAPTURING_MODE, 2131296555),
    SHUTTER_SPEED(true, false, ParameterCategory.CAPTURING_MODE, R.string.cam_strings_shutter_speed_title_txt),
    ISO(true, false, ParameterCategory.CAPTURING_MODE, 2131296812),
    METERING(true, false, ParameterCategory.CAPTURING_MODE, 2131296595),
    MICROPHONE(true, false, ParameterCategory.CAPTURING_MODE, 2131296566),
    PHOTO_LIGHT(true, true, ParameterCategory.COMMON, 2131296530),
    RESOLUTION(true, false, ParameterCategory.CAPTURING_MODE, 2131296611),
    SCENE(true, false, ParameterCategory.CAPTURING_MODE, 2131296633),
    SELF_TIMER(true, false, ParameterCategory.CAPTURING_MODE, 2131296676),
    SHUTTER_SOUND(true, true, ParameterCategory.COMMON, 2131296387),
    SMILE_CAPTURE(true, false, ParameterCategory.CAPTURING_MODE, 2131296690),
    SOFT_SKIN(true, false, ParameterCategory.CAPTURING_MODE, 2131296691),
    VIDEO_STABILIZER(true, false, ParameterCategory.CAPTURING_MODE, 2131296694),
    STABILIZER(true, false, ParameterCategory.CAPTURING_MODE, 2131296559),
    SUPER_RESOLUTION(false, false, ParameterCategory.CAPTURING_MODE, -1),
    TOUCH_CAPTURE(true, true, ParameterCategory.COMMON, 2131296714),
    VIDEO_HDR(true, false, ParameterCategory.CAPTURING_MODE, 2131296724),
    VIDEO_SELF_TIMER(true, false, ParameterCategory.CAPTURING_MODE, 2131296676),
    VIDEO_SIZE(true, false, ParameterCategory.CAPTURING_MODE, 2131296732),
    VIDEO_SMILE_CAPTURE(true, false, ParameterCategory.CAPTURING_MODE, 2131296738),
    VOLUME_KEY(true, true, ParameterCategory.COMMON, 2131296741),
    WHITE_BALANCE(true, false, ParameterCategory.CAPTURING_MODE, 2131296749),
    TOUCH_BLOCK(false, true, ParameterCategory.COMMON, -1),
    SEMI_AUTO(false, false, ParameterCategory.CAPTURING_MODE, 0),
    GRID_LINE(true, true, ParameterCategory.COMMON, 2131296550),
    VIDEO_CODEC(true, false, ParameterCategory.CAPTURING_MODE, 2131296720),

    CAMERA_MODE(true, false, ParameterCategory.CAPTURING_MODE, R.string.cam_strings_camera_modes_title_txt);

    public static final String TAG = "ParameterKey";
    private final ParameterCategory mCategory;
    private final boolean mIsCommon;
    private boolean mIsSaved;
    private ParameterSelectability mSelectability;
    private final int mTitleTextId;

    @DexIgnore
    private ParameterKey(boolean var3, boolean var4, ParameterCategory var5, int var6) {
        this.mIsSaved = var3;
        this.mIsCommon = var4;
        this.mCategory = var5;
        this.mTitleTextId = var6;
    }

    @DexIgnore
    public ParameterCategory getCategory() {
        return this.mCategory;
    }

    @DexIgnore
    public ParameterSelectability getSelectability() {
        return this.mSelectability;
    }

    @DexIgnore
    public String getTitleText(Context var1) {
        if (this==TOUCH_BLOCK)return ResourceUtil.getApplicationLabel(var1, "com.sonymobile.touchblocker");
        else return null;
    }

    @DexIgnore
    public int getTitleTextId(CapturingMode var1) {
        if(this==FLASH) return Flash.getParameterKeyTitleTextId();
        else if(this==VIDEO_STABILIZER) return VideoStabilizer.getParameterKeyTitleText(var1.getCameraId());
        else return this.mTitleTextId;
    }

    @DexIgnore
    public boolean isCommon() {
        return this.mIsCommon;
    }

    @DexIgnore
    public boolean isInvalid() {
        return this.getSelectability() == ParameterSelectability.INVALID;
    }

    @DexIgnore
    public boolean isSaved() {
        return this.mIsSaved;
    }

    @DexIgnore
    public boolean isSelectable() {
        return this.getSelectability() == ParameterSelectability.SELECTABLE;
    }

    @DexIgnore
    public void setSaved(boolean var1) {
        this.mIsSaved = var1;
    }

    @DexIgnore
    public void setSelectability(ParameterSelectability var1) {
        this.mSelectability = var1;
    }
}
