package com.sonyericsson.android.camera.parameter;

import com.sonyericsson.android.camera.configuration.parameters.AutoReview;
import com.sonyericsson.android.camera.configuration.parameters.AutoUpload;
import com.sonyericsson.android.camera.configuration.parameters.BurstShot;
import com.sonyericsson.android.camera.configuration.parameters.CameraMode;
import com.sonyericsson.android.camera.configuration.parameters.CapturingMode;
import com.sonyericsson.android.camera.configuration.parameters.DestinationToSave;
import com.sonyericsson.android.camera.configuration.parameters.Ev;
import com.sonyericsson.android.camera.configuration.parameters.Facing;
import com.sonyericsson.android.camera.configuration.parameters.FastCapture;
import com.sonyericsson.android.camera.configuration.parameters.Flash;
import com.sonyericsson.android.camera.configuration.parameters.FocusMode;
import com.sonyericsson.android.camera.configuration.parameters.Geotag;
import com.sonyericsson.android.camera.configuration.parameters.GridLine;
import com.sonyericsson.android.camera.configuration.parameters.Hdr;
import com.sonyericsson.android.camera.configuration.parameters.Iso;
import com.sonyericsson.android.camera.configuration.parameters.Metering;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValueHolder;
import com.sonyericsson.android.camera.configuration.parameters.PhotoLight;
import com.sonyericsson.android.camera.configuration.parameters.Resolution;
import com.sonyericsson.android.camera.configuration.parameters.Scene;
import com.sonyericsson.android.camera.configuration.parameters.SelfTimer;
import com.sonyericsson.android.camera.configuration.parameters.ShutterSound;
import com.sonyericsson.android.camera.configuration.parameters.SmileCapture;
import com.sonyericsson.android.camera.configuration.parameters.Stabilizer;
import com.sonyericsson.android.camera.configuration.parameters.SuperResolution;
import com.sonyericsson.android.camera.configuration.parameters.TouchBlock;
import com.sonyericsson.android.camera.configuration.parameters.TouchCapture;
import com.sonyericsson.android.camera.configuration.parameters.VideoCodec;
import com.sonyericsson.android.camera.configuration.parameters.VideoHdr;
import com.sonyericsson.android.camera.configuration.parameters.VideoSize;
import com.sonyericsson.android.camera.configuration.parameters.VideoSmileCapture;
import com.sonyericsson.android.camera.configuration.parameters.VideoStabilizer;
import com.sonyericsson.android.camera.configuration.parameters.VolumeKey;
import com.sonyericsson.android.camera.configuration.parameters.WhiteBalance;
import com.sonyericsson.android.camera.parameter.dependency.DependencyApplier;
import com.sonyericsson.cameracommon.mediasaving.StorageController;

import lanchon.dexpatcher.annotation.*;

@DexEdit(defaultAction = DexAction.IGNORE)
public class NormalParameters extends MainParameters {

    private ParameterValueHolder<Resolution> mLocalResolution;

    public NormalParameters(CapturingMode capturingMode, boolean bl, StorageController storageController) {
        super(capturingMode, bl, storageController);
    }

    @Override
    public void commit() {

    }

    @Override
    public void set(AutoReview var1) {

    }

    @Override
    public void set(AutoUpload var1) {

    }

    @Override
    public void set(BurstShot var1) {

    }

    @Override
    public void set(CapturingMode var1) {

    }

    @Override
    public void set(DestinationToSave var1) {

    }

    @Override
    public void set(Ev var1) {

    }

    @Override
    public void set(Facing var1) {

    }

    @Override
    public void set(FastCapture var1) {

    }

    @Override
    public void set(Flash var1) {

    }

    @Override
    public void set(FocusMode var1) {

    }

    @Override
    public void set(Geotag var1) {

    }

    @Override
    public void set(GridLine var1) {

    }

    @Override
    public void set(Hdr var1) {

    }

    @Override
    public void set(Iso var1) {

    }

    @Override
    public void set(Metering var1) {

    }

    @Override
    public void set(PhotoLight var1) {

    }

    @Override
    public void set(Resolution var1) {

    }

    @Override
    public void set(Scene var1) {

    }

    @Override
    public void set(SelfTimer var1) {

    }

    @Override
    public void set(ShutterSound var1) {

    }

    @Override
    public void set(SmileCapture var1) {

    }

    @Override
    public void set(Stabilizer var1) {

    }

    @Override
    public void set(SuperResolution var1) {

    }

    @Override
    public void set(TouchBlock var1) {

    }

    @Override
    public void set(TouchCapture var1) {

    }

    @Override
    public void set(VideoCodec var1) {

    }

    @Override
    public void set(VideoHdr var1) {

    }

    @Override
    public void set(VideoSize var1) {

    }

    @Override
    public void set(VideoSmileCapture var1) {

    }

    @Override
    public void set(VideoStabilizer var1) {

    }

    @Override
    public void set(VolumeKey var1) {

    }

    @Override
    public void set(WhiteBalance var1) {

    }

    @DexAdd
    @Override
    public void set(CameraMode cm) {
        DependencyApplier.create(mCapturingModeParams.mCameraMode.get()).reset(mCapturingModeParams);
        super.set(cm);
        DependencyApplier.create(cm).apply(mCapturingModeParams);
    }

    @DexReplace
    protected void updateSelectability() {
        if(this.mCapturingModeParams.mScene.get() != Scene.OFF) {
            DependencyApplier.create(mCapturingModeParams.mScene.get()).apply(mCapturingModeParams);
        }

        DependencyApplier.create(mCapturingModeParams.mResolution.get()).apply(mCapturingModeParams);
        this.updateLocalResolution(mCapturingModeParams.mHdr.get(), mLocalResolution);
        DependencyApplier.create(mCapturingModeParams.mSmileCapture.get()).apply(mCapturingModeParams);
        //
        DependencyApplier.create(mCapturingModeParams.mCameraMode.get()).apply(mCapturingModeParams);
    }
}