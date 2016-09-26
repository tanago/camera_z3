//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.parameter;

import com.sonyericsson.android.camera.configuration.Configurations;
import com.sonyericsson.android.camera.configuration.ParameterCategory;
import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.sonyericsson.android.camera.configuration.ParameterSelectability;
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
import com.sonyericsson.android.camera.configuration.parameters.ParameterApplicable;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValue;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValueHolder;
import com.sonyericsson.android.camera.configuration.parameters.PhotoLight;
import com.sonyericsson.android.camera.configuration.parameters.Resolution;
import com.sonyericsson.android.camera.configuration.parameters.Scene;
import com.sonyericsson.android.camera.configuration.parameters.SelfTimer;
import com.sonyericsson.android.camera.configuration.parameters.ShutterSound;
import com.sonyericsson.android.camera.configuration.parameters.ShutterSpeed;
import com.sonyericsson.android.camera.configuration.parameters.SmileCapture;
import com.sonyericsson.android.camera.configuration.parameters.SoftSkin;
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
import com.sonyericsson.android.camera.parameter.CapturingModeParams;
import com.sonyericsson.android.camera.parameter.CommonParams;
import com.sonyericsson.android.camera.parameter.FrontPhotoParameters;
import com.sonyericsson.android.camera.parameter.FrontVideoParameters;
import com.sonyericsson.android.camera.parameter.NormalParameters;
import com.sonyericsson.android.camera.parameter.ParameterUtil;
import com.sonyericsson.android.camera.parameter.SceneRecognitionParameters;
import com.sonyericsson.android.camera.parameter.SuperiorFrontParameters;
import com.sonyericsson.android.camera.parameter.VideoParameters;
import com.sonyericsson.android.camera.parameter.dependency.DependencyApplier;
import com.sonyericsson.android.camera.util.SharedPreferencesUtil;
import com.sonyericsson.cameracommon.mediasaving.StorageController;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexAdd;
import lanchon.dexpatcher.annotation.DexEdit;

@DexEdit(defaultAction = DexAction.IGNORE)
public abstract class Parameters implements ParameterApplicable {
    public static final String TAG = "Parameters";
    public final CapturingMode capturingMode;
    public final boolean isOneShotVideo;
    protected CapturingModeParams mCapturingModeParams;
    protected Map<ParameterKey, ParameterValueHolder<?>> mHolders;
    protected StorageController mStorageController;

    public Parameters(CapturingMode var1, boolean var2, StorageController var3) {
        this.capturingMode = var1;
        this.isOneShotVideo = var2;
        this.mHolders = new EnumMap(ParameterKey.class);
        this.mStorageController = var3;
    }

    @DexAdd
    @Override
    public void set(ShutterSpeed shutterSpeed) {
        mCapturingModeParams.mShutterSpeed.set(shutterSpeed);
    }
    @DexAdd
    public ShutterSpeed getShutterSpeed(){
        return mCapturingModeParams.mShutterSpeed.get();
    }

    @DexAdd
    public void set(CameraMode cameraMode){
        mCapturingModeParams.mCameraMode.set(cameraMode);
    }

    @DexAdd
    public CameraMode getCameraMode(){
        return mCapturingModeParams.mCameraMode.get();

    }

    public abstract SoftSkin getSoftSkin();

    public abstract void updatePhotoLight();

    public void updateLocalResolution(Hdr var1, ParameterValueHolder<Resolution> var2) { }
}
