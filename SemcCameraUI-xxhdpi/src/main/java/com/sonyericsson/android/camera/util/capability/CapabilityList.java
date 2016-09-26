//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.util.capability;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;

import com.sonyericsson.android.camera.configuration.parameters.Hdr;
import com.sonyericsson.android.camera.util.capability.BooleanCapabilityItem;
import com.sonyericsson.android.camera.util.capability.CapabilityItem;
import com.sonyericsson.android.camera.util.capability.FloatCapabilityItem;
import com.sonyericsson.android.camera.util.capability.IntArrayListCapabilityItem;
import com.sonyericsson.android.camera.util.capability.IntegerCapabilityItem;
import com.sonyericsson.android.camera.util.capability.RectCapabilityItem;
import com.sonyericsson.android.camera.util.capability.RectListCapabilityItem;
import com.sonyericsson.android.camera.util.capability.ResolutionCapabilityItem;
import com.sonyericsson.android.camera.util.capability.ResolutionOptions;
import com.sonyericsson.android.camera.util.capability.StringCapabilityItem;
import com.sonyericsson.android.camera.util.capability.StringListCapabilityItem;
import com.sonyericsson.android.camera.util.capability.UxCapabilityItem;
import com.sonyericsson.android.camera.util.capability.UxOptions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lanchon.dexpatcher.annotation.DexReplace;

@DexReplace
public class CapabilityList {
    private static final String KEY_EXPOSURE_COMPENSATION_STEP = "exposure-compensation-step";
    private static final String KEY_FLASH_MODE = "flash-mode";
    private static final String KEY_FOCUS_MODE = "focus-mode";
    private static final String KEY_MAX_EXPOSURE_COMPENSATION = "max-exposure-compensation";
    private static final String KEY_MAX_NUM_DETECTED_FACES = "max-num-detected-faces";
    private static final String KEY_MAX_NUM_FOCUS_AREAS = "max-num-focus-areas";
    private static final String KEY_MAX_ZOOM = "max-zoom";
    private static final String KEY_MIN_EXPOSURE_COMPENSATION = "min-exposure-compensation";
    private static final String KEY_PICTURE_SIZE = "picture-size";
    private static final String KEY_PREFERRED_PREVIEW_SIZE_FOR_STILL = "sony-preferred-preview-size-for-still";
    private static final String KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO = "preferred-preview-size-for-video";
    private static final String KEY_PREVIEW_FPS_RANGE = "preview-fps-range";
    private static final String KEY_PREVIEW_SIZE = "preview-size";
    private static final String KEY_SCENE_MODE = "scene-mode";
    private static final String KEY_SMOOTH_ZOOM_SUPPORTED = "smooth-zoom-supported";
    private static final String KEY_VIDEO_SIZE = "video-size";
    private static final String KEY_VIDEO_SNAPSHOT = "video-snapshot-supported";
    private static final String KEY_WHITE_BALANCE = "whitebalance";
    public static final String TAG = "CapabilityList";
    public final CapabilityItem<List<String>> AE;
    public final CapabilityItem<List<String>> BURST_SHOT;
    public final CapabilityItem<Integer> EV_MAX;
    public final CapabilityItem<Integer> EV_MIN;
    public final CapabilityItem<Float> EV_STEP;
    public final CapabilityItem<List<String>> EXIF_MAKER_NOTES_TYPES;
    public final CapabilityItem<String> EXTENSION_VERSION;
    public final CapabilityItem<List<String>> FLASH;
    public final CapabilityItem<List<String>> FOCUS_AREA;
    public final CapabilityItem<List<String>> FOCUS_MODE;
    public final CapabilityItem<List<int[]>> FPS_RANGE;
    public final CapabilityItem<List<String>> HDR;
    public final CapabilityItem<List<String>> IMAGE_STABILIZER;
    public final CapabilityItem<List<String>> ISO;

    public final CapabilityItem<String> MAX_SS;
    public final CapabilityItem<String> MIN_SS;
    public final CapabilityItem<String> SS_STEP;
    public final CapabilityItem<String> SS_CURRENT;
    public final CapabilityItem<String> ISO_CURRENT;

    public final CapabilityItem<Integer> MAX_AWB_AB;
    public final CapabilityItem<Integer> MAX_BURST_SHOT_FRAME_RATE;
    public final CapabilityItem<Rect> MAX_BURST_SHOT_SIZE;
    public final CapabilityItem<Rect> MAX_INTELLIGENT_ACTIVE_SIZE;
    public final CapabilityItem<Integer> MAX_MULTI_FOCUS_AREAS;
    public final CapabilityItem<Integer> MAX_NUM_FACE;
    public final CapabilityItem<Integer> MAX_NUM_FOCUS_AREA;
    public final CapabilityItem<Integer> MAX_SOFT_SKIN_LEVEL;
    public final CapabilityItem<Integer> MAX_SR_ZOOM;
    public final CapabilityItem<Rect> MAX_STEADY_SHOT_SIZE;
    public final CapabilityItem<Integer> MAX_VIDEO_FRAME;
    public final CapabilityItem<Rect> MAX_VIDEO_HDR_SIZE;
    public final CapabilityItem<Rect> MAX_VIDEO_STABILIZER_SIZE_FOR_LEGACY;
    public final CapabilityItem<Integer> MAX_ZOOM;
    public final CapabilityItem<List<String>> METERING;
    public final CapabilityItem<Integer> MIN_AWB_AB;
    public final CapabilityItem<String> MULTI_FOCUS_RECTS;
    public final CapabilityItem<Boolean> OBJECT_TRACKING;
    public final CapabilityItem<List<Rect>> PICTURE_SIZE;
    public final CapabilityItem<List<Rect>> PREVIEW_SIZE;
    public final CapabilityItem<Rect> PREVIEW_SIZE_FOR_STILL;
    public final CapabilityItem<Rect> PREVIEW_SIZE_FOR_VIDEO;
    public final CapabilityItem<ResolutionOptions> RESOLUTION_CAPABILITY;
    public final CapabilityItem<List<String>> SCENE;
    public final CapabilityItem<Boolean> SCENE_RECOGNITION;
    public final CapabilityItem<List<String>> SCENE_RECOGNITION_TYPES;
    public final CapabilityItem<Boolean> SMILE_DETECTION;
    public final CapabilityItem<Boolean> SMOOTH_ZOOM;
    public final CapabilityItem<Boolean> SR_ZOOM;
    public final CapabilityItem<UxOptions> UX_CAPABILITY;
    public final CapabilityItem<List<String>> VIDEO_HDR;
    public final CapabilityItem<Boolean> VIDEO_MEATDAT_VALUES;
    public final CapabilityItem<List<String>> VIDEO_NR_VALUES;
    public final CapabilityItem<List<Rect>> VIDEO_SIZE;
    public final CapabilityItem<Boolean> VIDEO_SNAPSHOT;
    public final CapabilityItem<List<String>> VIDEO_STABILIZER;
    public final CapabilityItem<List<String>> VIDEO_STABILIZER_TYPE;
    public final CapabilityItem<List<String>> WHITE_BALANCE;
    private final List<CapabilityItem<?>> mValues;

    public CapabilityList(Context var1, SharedPreferences var2) {
        this.EV_MAX = new IntegerCapabilityItem("max-exposure-compensation", var2);
        this.EV_MIN = new IntegerCapabilityItem("min-exposure-compensation", var2);
        this.EV_STEP = new FloatCapabilityItem("exposure-compensation-step", var2);
        this.FLASH = new StringListCapabilityItem("flash-mode", var2);
        this.FOCUS_MODE = new StringListCapabilityItem("focus-mode", var2);
        this.FPS_RANGE = new IntArrayListCapabilityItem("preview-fps-range", var2);
        this.MAX_NUM_FACE = new IntegerCapabilityItem("max-num-detected-faces", var2);
        this.MAX_NUM_FOCUS_AREA = new IntegerCapabilityItem("max-num-focus-areas", var2);
        this.MAX_ZOOM = new IntegerCapabilityItem("max-zoom", var2);
        this.PICTURE_SIZE = new RectListCapabilityItem("picture-size", var2);
        this.PREVIEW_SIZE = new RectListCapabilityItem("preview-size", var2);
        this.PREVIEW_SIZE_FOR_STILL = new RectCapabilityItem("sony-preferred-preview-size-for-still", var2);
        this.PREVIEW_SIZE_FOR_VIDEO = new RectCapabilityItem("preferred-preview-size-for-video", var2);
        this.SCENE = new StringListCapabilityItem("scene-mode", var2);
        this.SMOOTH_ZOOM = new BooleanCapabilityItem("smooth-zoom-supported", var2);
        this.SR_ZOOM = new BooleanCapabilityItem("sony-sr-zoom-supported", var2);
        this.VIDEO_SIZE = new RectListCapabilityItem("video-size", var2);
        this.VIDEO_SNAPSHOT = new BooleanCapabilityItem("video-snapshot-supported", var2);
        this.WHITE_BALANCE = new StringListCapabilityItem("whitebalance", var2);
        this.AE = new StringListCapabilityItem("sony-ae-mode-values", var2);
        this.BURST_SHOT = new StringListCapabilityItem("sony-burst-shot-values", var2);
        this.EXIF_MAKER_NOTES_TYPES = new StringListCapabilityItem("sony-exif-maker-note-types", var2);
        this.FOCUS_AREA = new StringListCapabilityItem("sony-focus-area-values", var2);
        this.HDR = new StringListCapabilityItem("sony-is-values", var2);
        this.IMAGE_STABILIZER = new StringListCapabilityItem("sony-is-values", var2);
        this.ISO = new StringListCapabilityItem("sony-iso-values", var2);

        this.MAX_SS = new StringCapabilityItem("sony-max-shutter-speed", var2);
        this.MIN_SS = new StringCapabilityItem("sony-min-shutter-speed", var2);
        this.SS_STEP = new StringCapabilityItem("sony-shutter-speed-step", var2);
        this.SS_CURRENT = new StringCapabilityItem("sony-shutter-speed", var2);
        this.ISO_CURRENT = new StringCapabilityItem("sony-iso", var2);

        this.MAX_BURST_SHOT_FRAME_RATE = new IntegerCapabilityItem("sony-max-burst-shot-frame-rate", var2);
        this.MAX_BURST_SHOT_SIZE = new RectCapabilityItem("sony-max-burst-shot-size", var2);
        this.MAX_MULTI_FOCUS_AREAS = new IntegerCapabilityItem("sony-max-multi-focus-num", var2);
        this.MAX_SR_ZOOM = new IntegerCapabilityItem("sony-max-sr-zoom", var2);
        this.METERING = new StringListCapabilityItem("sony-metering-mode-values", var2);
        this.MULTI_FOCUS_RECTS = new StringCapabilityItem("sony-multi-focus-rects", var2);
        this.OBJECT_TRACKING = new BooleanCapabilityItem("sony-object-tracking-supported", var2);
        this.SCENE_RECOGNITION = new BooleanCapabilityItem("sony-scene-detect-supported", var2);
        this.SCENE_RECOGNITION_TYPES = new StringListCapabilityItem("sony-scene-detect-apply-types", var2);
        this.SMILE_DETECTION = new BooleanCapabilityItem("sony-smile-detect-values", var2);
        this.EXTENSION_VERSION = new StringCapabilityItem("sony-extension-version", var2);
        this.VIDEO_HDR = new StringListCapabilityItem("sony-video-hdr-values", var2);
        this.VIDEO_STABILIZER = new StringListCapabilityItem("sony-vs-values", var2);
        this.VIDEO_STABILIZER_TYPE = new StringListCapabilityItem("sony-vs-type", var2);
        this.MAX_VIDEO_FRAME = new IntegerCapabilityItem("sony-max-video-frame-rate-for-1920x1080", var2);
        this.MAX_VIDEO_HDR_SIZE = new RectCapabilityItem("sony-max-video-hdr-size", var2);
        this.MAX_VIDEO_STABILIZER_SIZE_FOR_LEGACY = new RectCapabilityItem("sony-max-vs-size", var2);
        this.MAX_STEADY_SHOT_SIZE = new RectCapabilityItem("sony-max-vs-steady-shot-size", var2);
        this.MAX_INTELLIGENT_ACTIVE_SIZE = new RectCapabilityItem("sony-max-vs-intelligent-active-size", var2);
        this.VIDEO_NR_VALUES = new StringListCapabilityItem("sony-video-nr-values", var2);
        this.MAX_SOFT_SKIN_LEVEL = new IntegerCapabilityItem("sony-max-soft-skin-level", var2);
        this.VIDEO_MEATDAT_VALUES = new BooleanCapabilityItem("sony-video-metadata-supported", var2);
        this.MAX_AWB_AB = new IntegerCapabilityItem("sony-max-awb-compensation-ab", var2);
        this.MIN_AWB_AB = new IntegerCapabilityItem("sony-min-awb-compensation-ab", var2);
        this.mValues = this.createList();
        this.RESOLUTION_CAPABILITY = new ResolutionCapabilityItem(this.getResolutionOptions(var1, Hdr.isResolutionIndependentHdrSupported((List) this.SCENE.get())));
        this.UX_CAPABILITY = new UxCapabilityItem(new UxOptions(var1));
    }

    public CapabilityList(Context var1, Parameters var2) {
        this.EV_MAX = new IntegerCapabilityItem("max-exposure-compensation", Integer.valueOf(var2.getMaxExposureCompensation()));
        this.EV_MIN = new IntegerCapabilityItem("min-exposure-compensation", Integer.valueOf(var2.getMinExposureCompensation()));
        this.EV_STEP = new FloatCapabilityItem("exposure-compensation-step", Float.valueOf(var2.getExposureCompensationStep()));
        this.FLASH = new StringListCapabilityItem("flash-mode", var2.getSupportedFlashModes());
        this.FOCUS_MODE = new StringListCapabilityItem("focus-mode", var2.getSupportedFocusModes());
        this.FPS_RANGE = new IntArrayListCapabilityItem("preview-fps-range", var2.getSupportedPreviewFpsRange());
        this.MAX_NUM_FACE = new IntegerCapabilityItem("max-num-detected-faces", Integer.valueOf(var2.getMaxNumDetectedFaces()));
        this.MAX_NUM_FOCUS_AREA = new IntegerCapabilityItem("max-num-focus-areas", Integer.valueOf(var2.getMaxNumFocusAreas()));
        this.MAX_ZOOM = new IntegerCapabilityItem("max-zoom", Integer.valueOf(var2.getMaxZoom()));
        this.PICTURE_SIZE = new RectListCapabilityItem("picture-size", convertCameraSizeList(var2.getSupportedPictureSizes()));
        this.PREVIEW_SIZE = new RectListCapabilityItem("preview-size", convertCameraSizeList(var2.getSupportedPreviewSizes()));
        this.PREVIEW_SIZE_FOR_STILL = new RectCapabilityItem("sony-preferred-preview-size-for-still", var2);
        this.PREVIEW_SIZE_FOR_VIDEO = new RectCapabilityItem("preferred-preview-size-for-video", convertCameraSize(var2.getPreferredPreviewSizeForVideo()));
        this.SCENE = new StringListCapabilityItem("scene-mode", var2.getSupportedSceneModes());
        this.SMOOTH_ZOOM = new BooleanCapabilityItem("smooth-zoom-supported", Boolean.valueOf(var2.isSmoothZoomSupported()));
        this.SR_ZOOM = new BooleanCapabilityItem("sony-sr-zoom-supported", var2);
        this.VIDEO_SIZE = new RectListCapabilityItem("video-size", convertCameraSizeList(var2.getSupportedVideoSizes()));
        this.VIDEO_SNAPSHOT = new BooleanCapabilityItem("video-snapshot-supported", Boolean.valueOf(var2.isVideoSnapshotSupported()));
        this.WHITE_BALANCE = new StringListCapabilityItem("whitebalance", var2.getSupportedWhiteBalance());
        this.AE = new StringListCapabilityItem("sony-ae-mode-values", var2);
        this.BURST_SHOT = new StringListCapabilityItem("sony-burst-shot-values", var2);
        this.EXIF_MAKER_NOTES_TYPES = new StringListCapabilityItem("sony-exif-maker-note-types", var2);
        this.FOCUS_AREA = new StringListCapabilityItem("sony-focus-area-values", var2);
        this.HDR = new StringListCapabilityItem("sony-is-values", var2);
        this.IMAGE_STABILIZER = new StringListCapabilityItem("sony-is-values", var2);
        this.ISO = new StringListCapabilityItem("sony-iso-values", var2);

        this.MAX_SS = new StringCapabilityItem("sony-max-shutter-speed", var2);
        this.MIN_SS = new StringCapabilityItem("sony-min-shutter-speed", var2);
        this.SS_STEP = new StringCapabilityItem("sony-shutter-speed-step", var2);
        this.SS_CURRENT = new StringCapabilityItem("sony-shutter-speed", var2);
        this.ISO_CURRENT = new StringCapabilityItem("sony-iso", var2);

        this.MAX_BURST_SHOT_FRAME_RATE = new IntegerCapabilityItem("sony-max-burst-shot-frame-rate", var2);
        this.MAX_BURST_SHOT_SIZE = new RectCapabilityItem("sony-max-burst-shot-size", var2);
        this.MAX_MULTI_FOCUS_AREAS = new IntegerCapabilityItem("sony-max-multi-focus-num", var2);
        this.MAX_SR_ZOOM = new IntegerCapabilityItem("sony-max-sr-zoom", var2);
        this.METERING = new StringListCapabilityItem("sony-metering-mode-values", var2);
        this.MULTI_FOCUS_RECTS = new StringCapabilityItem("sony-multi-focus-rects", var2);
        this.OBJECT_TRACKING = new BooleanCapabilityItem("sony-object-tracking-supported", var2);
        this.SCENE_RECOGNITION = new BooleanCapabilityItem("sony-scene-detect-supported", var2);
        this.SCENE_RECOGNITION_TYPES = new StringListCapabilityItem("sony-scene-detect-apply-types", var2);
        this.SMILE_DETECTION = new BooleanCapabilityItem("sony-smile-detect-values", var2);
        this.EXTENSION_VERSION = new StringCapabilityItem("sony-extension-version", var2);
        this.VIDEO_HDR = new StringListCapabilityItem("sony-video-hdr-values", var2);
        this.VIDEO_STABILIZER = new StringListCapabilityItem("sony-vs-values", var2);
        this.VIDEO_STABILIZER_TYPE = new StringListCapabilityItem("sony-vs-type", var2);
        this.MAX_VIDEO_FRAME = new IntegerCapabilityItem("sony-max-video-frame-rate-for-1920x1080", var2);
        this.MAX_VIDEO_HDR_SIZE = new RectCapabilityItem("sony-max-video-hdr-size", var2);
        this.MAX_VIDEO_STABILIZER_SIZE_FOR_LEGACY = new RectCapabilityItem("sony-max-vs-size", var2);
        this.MAX_STEADY_SHOT_SIZE = new RectCapabilityItem("sony-max-vs-steady-shot-size", var2);
        this.MAX_INTELLIGENT_ACTIVE_SIZE = new RectCapabilityItem("sony-max-vs-intelligent-active-size", var2);
        this.VIDEO_NR_VALUES = new StringListCapabilityItem("sony-video-nr-values", var2);
        this.MAX_SOFT_SKIN_LEVEL = new IntegerCapabilityItem("sony-max-soft-skin-level", var2);
        this.VIDEO_MEATDAT_VALUES = new BooleanCapabilityItem("sony-video-metadata-supported", var2);
        this.MAX_AWB_AB = new IntegerCapabilityItem("sony-max-awb-compensation-ab", var2);
        this.MIN_AWB_AB = new IntegerCapabilityItem("sony-min-awb-compensation-ab", var2);
        this.mValues = this.createList();
        this.RESOLUTION_CAPABILITY = new ResolutionCapabilityItem(this.getResolutionOptions(var1, Hdr.isResolutionIndependentHdrSupported((List) this.SCENE.get())));
        this.UX_CAPABILITY = new UxCapabilityItem(new UxOptions(var1));
    }

    public static Rect convertCameraSize(Size var0) {
        return var0 == null ? null : new Rect(0, 0, var0.width, var0.height);
    }

    public static List<Rect> convertCameraSizeList(List<Size> var0) {
        ArrayList var3;
        if (var0 == null) {
            var3 = new ArrayList();
        } else {
            ArrayList var1 = new ArrayList();
            Iterator var2 = var0.iterator();

            while (true) {
                var3 = var1;
                if (!var2.hasNext()) {
                    break;
                }

                Size var4 = (Size) var2.next();
                if (var4 != null) {
                    var1.add(convertCameraSize(var4));
                }
            }
        }

        return var3;
    }

    private List<CapabilityItem<?>> createList() {
        ArrayList var1 = new ArrayList();
        var1.add(this.AE);
        var1.add(this.BURST_SHOT);
        var1.add(this.EV_MAX);
        var1.add(this.EV_MIN);
        var1.add(this.EV_STEP);
        var1.add(this.EXIF_MAKER_NOTES_TYPES);
        var1.add(this.FLASH);
        var1.add(this.FOCUS_AREA);
        var1.add(this.FOCUS_MODE);
        var1.add(this.FPS_RANGE);
        var1.add(this.IMAGE_STABILIZER);
        var1.add(this.HDR);
        var1.add(this.ISO);
        var1.add(this.MAX_BURST_SHOT_FRAME_RATE);
        var1.add(this.MAX_BURST_SHOT_SIZE);
        var1.add(this.MAX_MULTI_FOCUS_AREAS);
        var1.add(this.MAX_NUM_FACE);
        var1.add(this.MAX_NUM_FOCUS_AREA);
        var1.add(this.MAX_SR_ZOOM);
        var1.add(this.MAX_ZOOM);
        var1.add(this.METERING);
        var1.add(this.MULTI_FOCUS_RECTS);
        var1.add(this.OBJECT_TRACKING);
        var1.add(this.PICTURE_SIZE);
        var1.add(this.PREVIEW_SIZE);
        var1.add(this.PREVIEW_SIZE_FOR_STILL);
        var1.add(this.PREVIEW_SIZE_FOR_VIDEO);
        var1.add(this.SCENE);
        var1.add(this.SCENE_RECOGNITION);
        var1.add(this.SCENE_RECOGNITION_TYPES);
        var1.add(this.SMILE_DETECTION);
        var1.add(this.SMOOTH_ZOOM);
        var1.add(this.SR_ZOOM);
        var1.add(this.EXTENSION_VERSION);
        var1.add(this.VIDEO_HDR);
        var1.add(this.VIDEO_SIZE);
        var1.add(this.VIDEO_SNAPSHOT);
        var1.add(this.VIDEO_STABILIZER);
        var1.add(this.VIDEO_STABILIZER_TYPE);
        var1.add(this.WHITE_BALANCE);
        var1.add(this.MAX_VIDEO_FRAME);
        var1.add(this.MAX_VIDEO_HDR_SIZE);
        var1.add(this.MAX_VIDEO_STABILIZER_SIZE_FOR_LEGACY);
        var1.add(this.MAX_STEADY_SHOT_SIZE);
        var1.add(this.MAX_INTELLIGENT_ACTIVE_SIZE);
        var1.add(this.VIDEO_NR_VALUES);
        var1.add(this.MAX_SOFT_SKIN_LEVEL);
        var1.add(this.VIDEO_MEATDAT_VALUES);
        var1.add(this.MAX_AWB_AB);
        var1.add(this.MIN_AWB_AB);
        var1.add(this.MAX_SS);
        var1.add(this.MIN_SS);
        var1.add(this.SS_STEP);
        var1.add(this.SS_CURRENT);
        var1.add(this.ISO_CURRENT);
        return var1;
    }

    private ResolutionOptions getResolutionOptions(Context var1, boolean var2) {
        int var5 = this.getMaxPictureSize();
        int var3 = 0;
        int var4 = 0;
        switch (var5) {
            case 3264:
                Iterator var6 = ((List) this.VIDEO_SIZE.get()).iterator();

                while (true) {
                    var4 = var3;
                    if (!var6.hasNext()) {
                        break;
                    }

                    var4 = ((Rect) var6.next()).height();
                    if (var4 == 1080) {
                        break;
                    }

                    if (var4 == 720) {
                        var3 = var4;
                    }
                }
            default:
                return new ResolutionOptions(var1, var5, var4, var2);
        }
    }

    public int getMaxPictureSize() {
        List var2 = (List) this.PICTURE_SIZE.get();
        int var1 = 0;
        Iterator var4 = var2.iterator();

        while (var4.hasNext()) {
            Rect var3 = (Rect) var4.next();
            if (var1 < var3.width()) {
                var1 = var3.width();
            }
        }

        return var1;
    }

    public List<CapabilityItem<?>> values() {
        return this.mValues;
    }
}
