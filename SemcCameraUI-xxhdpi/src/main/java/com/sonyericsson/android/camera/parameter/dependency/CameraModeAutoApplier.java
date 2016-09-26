package com.sonyericsson.android.camera.parameter.dependency;

import com.sonyericsson.android.camera.configuration.parameters.CameraMode;
import com.sonyericsson.android.camera.parameter.CapturingModeParams;
import com.sonyericsson.android.camera.parameter.ParameterUtil;

import lanchon.dexpatcher.annotation.DexAdd;

/**
 * Created by tanago on 25.9.2016 г..
 */
@DexAdd
public class CameraModeAutoApplier extends DependencyApplier {
    @Override
    public void apply(CapturingModeParams capturingModeParams) {
        ParameterUtil.unavailable(capturingModeParams.mShutterSpeed, capturingModeParams.mShutterSpeed.get());
        ParameterUtil.unavailable(capturingModeParams.mIso, capturingModeParams.mIso.get());
    }

    @Override
    public void reset(CapturingModeParams capturingModeParams) {
        ParameterUtil.reset(capturingModeParams.mShutterSpeed);
        ParameterUtil.reset(capturingModeParams.mIso);
    }
}
