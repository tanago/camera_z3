//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.controller;

import android.graphics.Rect;
import android.hardware.Camera.CameraInfo;
import android.location.Location;
import android.os.Handler;
import com.sonyericsson.android.camera.CameraActivity;
import com.sonyericsson.android.camera.CameraSize;
import com.sonyericsson.android.camera.ControllerManager;
import com.sonyericsson.android.camera.NavigatorContents;
import com.sonyericsson.android.camera.configuration.Configurations;
import com.sonyericsson.android.camera.configuration.ParameterKey;
import com.sonyericsson.android.camera.configuration.ParameterSelectability;
import com.sonyericsson.android.camera.configuration.parameters.AutoReview;
import com.sonyericsson.android.camera.configuration.parameters.AutoUpload;
import com.sonyericsson.android.camera.configuration.parameters.BurstShot;
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
import com.sonyericsson.android.camera.configuration.parameters.VideoSize.VideoProfile;
import com.sonyericsson.android.camera.controller.AutoZoom;
import com.sonyericsson.android.camera.controller.ControllerEvent;
import com.sonyericsson.android.camera.controller.ControllerEventSource;
import com.sonyericsson.android.camera.controller.ControllerMessage;
import com.sonyericsson.android.camera.controller.EventDispatcher;
import com.sonyericsson.android.camera.controller.Executor;
import com.sonyericsson.android.camera.controller.FaceDetect;
import com.sonyericsson.android.camera.controller.ImageQualityControl;
import com.sonyericsson.android.camera.controller.ObjectTracking;
import com.sonyericsson.android.camera.controller.SceneRecognition;
import com.sonyericsson.android.camera.controller.Selftimer;
import com.sonyericsson.android.camera.controller.Shooting;
import com.sonyericsson.android.camera.controller.TouchFocus;
import com.sonyericsson.android.camera.controller.VideoDevice;
import com.sonyericsson.android.camera.device.CameraDevice;
import com.sonyericsson.android.camera.device.CameraDeviceException;
import com.sonyericsson.android.camera.mediasaving.BurstSavingTaskManager;
import com.sonyericsson.android.camera.parameter.ParameterManager;
import com.sonyericsson.android.camera.parameter.Parameters;
import com.sonyericsson.android.camera.util.MaxVideoSize;
import com.sonyericsson.android.camera.util.capability.HardwareCapability;
import com.sonyericsson.android.camera.view.CameraWindow;
import com.sonyericsson.android.camera.view.TransitionAnimationController.ModeTaransitionAnimationCallback;
import com.sonyericsson.cameracommon.mediasaving.CameraStorageManager;
import com.sonyericsson.cameracommon.mediasaving.StoreDataResult;
import com.sonyericsson.cameracommon.mediasaving.SavingTaskManager.SavedFileType;
import com.sonyericsson.cameracommon.mediasaving.takenstatus.PhotoSavingRequest;
import com.sonyericsson.cameracommon.mediasaving.takenstatus.TakenStatusCommon;
import com.sonyericsson.cameracommon.mediasaving.takenstatus.TakenStatusPhoto;
import com.sonyericsson.cameracommon.mediasaving.takenstatus.TakenStatusVideo;
import com.sonyericsson.cameracommon.mediasaving.takenstatus.VideoSavingRequest;
import com.sonyericsson.cameracommon.mediasaving.takenstatus.SavingRequest.StoreDataCallback;
import com.sonyericsson.cameracommon.status.EachCameraStatusPublisher;
import com.sonyericsson.cameracommon.status.eachcamera.VideoNoiseReduction;
import com.sonyericsson.cameracommon.status.eachcamera.VideoRecordingFps;
import com.sonyericsson.cameracommon.status.eachcamera.VideoResolution;
import com.sonyericsson.cameracommon.status.eachcamera.VideoStabilizerStatus;
import com.sonyericsson.cameracommon.utility.CameraLogger;
import com.sonyericsson.cameracommon.utility.ClassDefinitionChecker;
import com.sonyericsson.cameracommon.utility.MeasurePerformance;
import com.sonyericsson.cameracommon.utility.PositionConverter;
import com.sonyericsson.cameracommon.utility.RecordingUtil;
import com.sonyericsson.cameracommon.utility.RotationUtil;
import com.sonyericsson.cameracommon.utility.MeasurePerformance.PerformanceIds;
import com.sonymobile.cameracommon.media.utility.AudioResourceChecker;
import com.sonymobile.cameracommon.vanilla.evf.Evf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import lanchon.dexpatcher.annotation.*;

@DexEdit(defaultAction = DexAction.IGNORE)
public abstract class CameraFunctions implements StoreDataCallback {
    public static final String TAG = "CameraFunctions";
    protected boolean mAnimationProgress = false;
    protected final AutoZoom mAutoZoom;
    protected final CameraActivity mCameraActivity;
    protected final CameraDevice mCameraDevice;
    protected final CameraWindow mCameraWindow;
    protected final ControllerManager mControllerManager;
    protected Selftimer mCurrentSelfTimer;
    protected final EventDispatcher mEventDispatcher;
    protected final FaceDetect mFaceDetect;
    protected final ImageQualityControl mImageQualityControl;
    protected boolean mIsDragging = false;
    protected boolean mIsIconReleaseAnimationProgress = false;
    protected boolean mIsModeChangeAnimationProgress = false;
    private boolean mIsSwipeAnimationProgress = false;
    protected boolean mIsVideoSmileCapturing;
    protected NavigatorContents mNavigatorContents;
    protected final ObjectTracking mObjectTracking;
    protected final ParameterManager mParameterManager;
    protected final BurstSavingTaskManager mSavingTaskManager;
    protected final SceneRecognition mSceneRecognition;
    protected final Selftimer mSelfTimer;
    protected final CameraFunctions.SettingsController mSettingsController = new CameraFunctions.SettingsController();
    protected final Shooting mShooting;
    protected final CameraStorageManager mStorageManager;
    protected final TouchFocus mTouchFocus;
    protected final VideoDevice mVideoDevice;
    protected final Selftimer mVideoSelfTimer;

    @DexIgnore
    public CameraFunctions(CameraActivity var1, EventDispatcher var2) {
        this.mCameraActivity = var1;
        this.mCameraDevice = var1.getCameraDevice();
        this.mCameraWindow = var1.getContentView();
        this.mControllerManager = var1.getControllerManager();
        this.mParameterManager = var1.getParameterManager();
        this.mSavingTaskManager = (BurstSavingTaskManager)var1.getSavingTaskManager();
        this.mStorageManager = var1.getStorageManager();
        this.mEventDispatcher = var2;
        this.mAutoZoom = new AutoZoom(this);
        this.mFaceDetect = new FaceDetect(this);
        this.mObjectTracking = new ObjectTracking(this);
        this.mSelfTimer = new Selftimer(this, 1);
        this.mVideoSelfTimer = new Selftimer(this, 2);
        this.mSceneRecognition = new SceneRecognition(this);
        this.mTouchFocus = new TouchFocus(this);
        this.mShooting = new Shooting(this);
        this.mVideoDevice = new VideoDevice(this);
        this.mImageQualityControl = new ImageQualityControl(this);
    }

    @DexEdit(defaultAction = DexAction.IGNORE)
    class SettingsController implements ParameterApplicable {
        SettingsController() {
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
        public void set(SoftSkin var1) {

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
        public void set(ShutterSpeed shutterSpeed) {
            CameraFunctions.this.mCameraDevice.setShutterSpeed(shutterSpeed);
        }
    }
}
