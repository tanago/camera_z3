package com.sonyericsson.android.camera.device;

import android.hardware.Camera;
import android.os.Handler;

import com.sonyericsson.android.camera.configuration.parameters.CameraMode;
import com.sonyericsson.android.camera.configuration.parameters.Iso;
import com.sonyericsson.android.camera.configuration.parameters.ShutterSpeed;
import com.sonyericsson.android.camera.parameter.Parameters;
import com.sonyericsson.cameraextension.*;

import lanchon.dexpatcher.annotation.*;

/**
 * Created by tanago on 23.9.2016 г..
 */
@DexEdit(defaultAction = DexAction.IGNORE)
public class CameraDevice implements CameraExtension.SceneRecognitionCallback, Camera.ErrorCallback {
    private static Camera.Parameters sCachedParameters = null;
    private boolean mCommitParameters;

    public Camera.Parameters getParameters() {
        return sCachedParameters;
    }


    @Override
    public void onError(int error, Camera camera) {

    }

    @Override
    public void onSceneModeChanged(CameraExtension.SceneRecognitionResult sceneRecognitionResult) {

    }


    @DexAdd
    public void setShutterSpeed(ShutterSpeed shutterSpeed) {
        synchronized (this){
            Camera.Parameters params = this.getParameters();
            if(params==null) {
                return;
            }
            params.set("sony-shutter-speed", shutterSpeed.getValue());
        }
        this.mCommitParameters = true;
    }

    @DexAdd
    public void setCameraMode(CameraMode cameraMode) {
        synchronized (this){
            Camera.Parameters params = this.getParameters();
            if (params == null) {
                return;
            }
            params.set("sony-ae-mode", cameraMode.getValue());
        }
        this.mCommitParameters = true;
    }

    @DexReplace
    public void setIso(Iso iso) {
        synchronized (this) {
            Camera.Parameters parameters = this.getParameters();
            if (parameters == null) {
                return;
            }
            int n = iso.getIsoValue();
            if (n > 0) {
                parameters.set("sony-iso", Integer.toString(n));
            }
        }
        this.mCommitParameters = true;
    }

    @DexEdit(defaultAction = DexAction.IGNORE)
    private class SetupCameraDeviceTask
            implements Runnable {
        private final Handler mHandler;
        private final Parameters mParams;

        public SetupCameraDeviceTask(Parameters parameters) {
            this.mHandler = new Handler();
            this.mParams = parameters;
        }

        @DexEdit (target = "applyAllParameters")
        private void applyAllParameters_src() {
        }
        @DexAdd
        private void applyAllParameters(){
            CameraDevice.this.setCameraMode(this.mParams.getCameraMode());
            CameraDevice.this.setShutterSpeed(this.mParams.getShutterSpeed());
            applyAllParameters_src();
        }

        @Override
        public void run() {

        }
    }
}
