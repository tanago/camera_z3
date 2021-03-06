package com.sonyericsson.android.camera.parameter.dependency;

import com.sonyericsson.android.camera.parameter.CapturingModeParams;
import com.sonyericsson.android.camera.parameter.ParameterUtil;

import lanchon.dexpatcher.annotation.DexAdd;

/**
 * Created by tanago on 25.9.2016 г..
 */
@DexAdd
public class CameraModeShutterPrioApplier extends DependencyApplier {
    @Override
    public void apply(CapturingModeParams capturingModeParams) {
        ParameterUtil.unavailable(capturingModeParams.mIso, capturingModeParams.mIso.get());
    }

    @Override
    public void reset(CapturingModeParams capturingModeParams) {
        ParameterUtil.reset(capturingModeParams.mIso);
    }
}
