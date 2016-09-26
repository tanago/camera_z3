package com.sonyericsson.android.camera.view.settings;

import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.tanago.camera.R;

import lanchon.dexpatcher.annotation.*;

/**
 * Created by tanago on 25.9.2016 г..
 */

@DexEdit(defaultAction = DexAction.IGNORE)
public class SettingController {

    @DexEdit(target = "getContextualMenuIcon")
    private int getContextualMenuIcon_src(ParameterKey parameterKey) {

        return -1;
    }

    @DexAdd
    private int getContextualMenuIcon(ParameterKey pk){
        if(pk == ParameterKey.CAMERA_MODE) return R.drawable.cam_core_contextual_settings_camera_mode_icn;
        else if (pk == ParameterKey.SHUTTER_SPEED) return R.drawable.cam_core_contextual_settings_shutter_speed_icn;
        else return getContextualMenuIcon_src(pk);
    }
}
