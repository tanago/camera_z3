package com.sonyericsson.android.camera.parameter.dependency;

import com.sonyericsson.android.camera.configuration.parameters.CameraMode;
import com.sonyericsson.android.camera.configuration.parameters.Resolution;
import com.sonyericsson.android.camera.configuration.parameters.Scene;
import com.sonyericsson.android.camera.configuration.parameters.SmileCapture;
import com.sonyericsson.android.camera.parameter.CapturingModeParams;

import lanchon.dexpatcher.annotation.*;

@DexEdit(defaultAction = DexAction.IGNORE)
public abstract class DependencyApplier {
    public static final String TAG = "DependencyApplier";

    @DexAdd
    public static DependencyApplier create(CameraMode cm) {
        if (cm == CameraMode.ISO_PRIO){
            return new CameraModeIsoPrioApplier();
        }
        else if (cm == CameraMode.SHUTTER_PRIO){
            return new CameraModeShutterPrioApplier();
        }
        else if (cm == CameraMode.AUTO){
            return new CameraModeAutoApplier();
        }
        else return new CameraModeManualApplier();
    }

    public static DependencyApplier create(Resolution res) { return null;}

    public static DependencyApplier create(SmileCapture smileCapture) { return null;}

    public static DependencyApplier create(Scene scene) {
        return null;
    }

    public abstract void apply(CapturingModeParams var1);

    public abstract void reset(CapturingModeParams var1);

}