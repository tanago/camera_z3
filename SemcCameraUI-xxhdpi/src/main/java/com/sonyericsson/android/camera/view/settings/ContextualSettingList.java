//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.view.settings;

import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.sonyericsson.android.camera.configuration.parameters.CapturingMode;

import lanchon.dexpatcher.annotation.*;


@DexReplace
class ContextualSettingList {
    private final ContextualSettingList.Group mAuto;
    private final ContextualSettingList.Group mManual;
    private final ContextualSettingList.Group mVideo;


    public ContextualSettingList() {
        ContextualSettingList.Category common = category(
                2131296568, new ParameterKey[]{
                        ParameterKey.GEO_TAG,
                        ParameterKey.TOUCH_CAPTURE,
                        ParameterKey.GRID_LINE,
                        ParameterKey.AUTO_REVIEW,
                        ParameterKey.VOLUME_KEY,
                        ParameterKey.SHUTTER_SOUND,
                        ParameterKey.DESTINATION_TO_SAVE,
                        ParameterKey.FAST_CAPTURE,
                        ParameterKey.AUTO_UPLOAD,
                        ParameterKey.TOUCH_BLOCK});

        this.mAuto = group(
                category(2131296401, new ParameterKey[]{
                        ParameterKey.SELF_TIMER,
                        ParameterKey.SEMI_AUTO,
                        ParameterKey.ISO,
                        ParameterKey.HDR,
                        ParameterKey.RESOLUTION}),
                category(2131296569, new ParameterKey[]{
                        ParameterKey.FOCUS_MODE,
                        ParameterKey.METERING,
                        ParameterKey.SMILE_CAPTURE,
                        ParameterKey.SOFT_SKIN}),
                common);

        this.mManual = group(
                category(2131296396, new ParameterKey[]{
                        ParameterKey.SELF_TIMER,
                        ParameterKey.SEMI_AUTO,
                        ParameterKey.CAMERA_MODE,
                        ParameterKey.SHUTTER_SPEED,
                        ParameterKey.ISO,
                        ParameterKey.HDR,
                        ParameterKey.RESOLUTION}),
                category(2131296569, new ParameterKey[]{
                        ParameterKey.FOCUS_MODE,
                        ParameterKey.METERING,
                        ParameterKey.SMILE_CAPTURE,
                        ParameterKey.SOFT_SKIN}),
                common);

        this.mVideo = group(
                category(2131296371, new ParameterKey[]{
                        ParameterKey.SEMI_AUTO,
                        ParameterKey.SCENE,
                        ParameterKey.VIDEO_HDR,
                        ParameterKey.VIDEO_SIZE}),
                category(2131296569, new ParameterKey[]{
                        ParameterKey.FOCUS_MODE,
                        ParameterKey.VIDEO_SMILE_CAPTURE,
                        ParameterKey.VIDEO_STABILIZER}),
                common);
    }

    private static ContextualSettingList.Category category(int var0, ParameterKey[] parameterKeys) {
        return new ContextualSettingList.Category(var0, parameterKeys);
    }

    private static ContextualSettingList.Category category(ParameterKey[] parameterKeys) {
        return new ContextualSettingList.Category(0, parameterKeys);
    }

    private static ContextualSettingList.Group group(ContextualSettingList.Category var0, ContextualSettingList.Category var1, ContextualSettingList.Category var2) {
        return new ContextualSettingList.Group(var0, var1, var2);
    }

    public ContextualSettingList.Group get(CapturingMode var1) {
        if(var1 == CapturingMode.FRONT_VIDEO || var1 == CapturingMode.VIDEO)
            return this.mVideo;
        else if(var1 == CapturingMode.SUPERIOR_FRONT || var1 == CapturingMode.SCENE_RECOGNITION)
            return this.mAuto;
        else if(var1 == CapturingMode.FRONT_PHOTO || var1 == CapturingMode.PHOTO || var1 == CapturingMode.NORMAL)
            return this.mManual;
        else
                throw new IllegalArgumentException("The specified mode is not supported. mode:" + var1.name());
    }

    @DexIgnore
    public static class Category {
        public final ParameterKey[] keys;
        public final int titleResource;

        public Category(int var1, ParameterKey... var2) {
            this.titleResource = var1;
            this.keys = var2;
        }

        public boolean hasTitle() {
            return this.titleResource != 0;
        }
    }

    @DexIgnore
    public static class Group {
        public final ContextualSettingList.Category common;
        public final ContextualSettingList.Category priorityHigh;
        public final ContextualSettingList.Category priorityLow;

        public Group(ContextualSettingList.Category var1, ContextualSettingList.Category var2, ContextualSettingList.Category var3) {
            this.priorityHigh = var1;
            this.priorityLow = var2;
            this.common = var3;
        }
    }
}
