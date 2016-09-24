package com.sonyericsson.android.camera.device;

import android.hardware.Camera;

import com.sonyericsson.android.camera.configuration.parameters.ShutterSpeed;
import com.sonyericsson.cameraextension.*;

import lanchon.dexpatcher.annotation.*;

/**
 * Created by tanago on 23.9.2016 г..
 */
@DexEdit(defaultAction = DexAction.IGNORE)
public class CameraDevice implements com.sonyericsson.cameraextension.CameraExtension.SceneRecognitionCallback, android.hardware.Camera.ErrorCallback {
    public void setShutterSpeed(ShutterSpeed shutterSpeed) {
        synchronized (this){
            Camera.Parameters params = this.getParameters();
        }
    }

    private Camera.Parameters getParameters() {
    }


    @Override
    public void onError(int error, Camera camera) {

    }
}
