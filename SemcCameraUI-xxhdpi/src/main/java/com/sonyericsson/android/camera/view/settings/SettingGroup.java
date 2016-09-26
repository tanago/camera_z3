//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.view.settings;

import com.sonyericsson.android.camera.configuration.ParameterKey;

import lanchon.dexpatcher.annotation.*;

@DexReplace
public enum SettingGroup {
    PHOTO(2131296345, new ParameterKey[]{
            ParameterKey.RESOLUTION,
            ParameterKey.SELF_TIMER,
            ParameterKey.SMILE_CAPTURE,
            ParameterKey.FOCUS_MODE,
            ParameterKey.ISO,
            ParameterKey.METERING,
            ParameterKey.STABILIZER,
            ParameterKey.SOFT_SKIN,
            ParameterKey.AUTO_REVIEW,
            ParameterKey.SUPER_RESOLUTION,
            ParameterKey.SHUTTER_SPEED,
            ParameterKey.CAMERA_MODE
    }),
    VIDEO(2131296359, new ParameterKey[]{
            ParameterKey.VIDEO_SIZE,
            ParameterKey.VIDEO_SELF_TIMER,
            ParameterKey.VIDEO_SMILE_CAPTURE,
            ParameterKey.FOCUS_MODE,
            ParameterKey.VIDEO_HDR,
            ParameterKey.METERING,
            ParameterKey.VIDEO_STABILIZER,
            ParameterKey.MICROPHONE,
            ParameterKey.VIDEO_AUTO_REVIEW}),
    SCENE(2131296841, new ParameterKey[0]),
    CONTROL(2131296768, new ParameterKey[]{
            ParameterKey.WHITE_BALANCE,
            ParameterKey.EV}),
    FLASH_LIGHT(2131296529, new ParameterKey[]{
            ParameterKey.FLASH,
            ParameterKey.PHOTO_LIGHT}),
    COMMON(2131296343, new ParameterKey[]{
            ParameterKey.TOUCH_CAPTURE,
            ParameterKey.GRID_LINE,
            ParameterKey.FAST_CAPTURE,
            ParameterKey.VOLUME_KEY,
            ParameterKey.GEO_TAG,
            ParameterKey.SHUTTER_SOUND,
            ParameterKey.DESTINATION_TO_SAVE,
            ParameterKey.AUTO_UPLOAD,
            ParameterKey.TOUCH_BLOCK});

    public static final String TAG = "SettingGroup";
    private final ParameterKey[] mItems;
    private final int mTextId;

    private SettingGroup(int var3, ParameterKey[] var4) {
        this.mTextId = var3;
        this.mItems = var4;
    }

    public static SettingGroup getGroup(String string) {
        for (SettingGroup settingGroup : SettingGroup.values()) {
            if (settingGroup.toString().equals(string)) return settingGroup;
        }
        return null;
    }


    public ParameterKey[] getSettingItemList() {
        return (ParameterKey[]) this.mItems.clone();
    }


    public int getTextId() {
        return this.mTextId;
    }


    public ParameterKey[] valueOf(SettingGroup var1) {
        return this.getSettingItemList();
    }
}
