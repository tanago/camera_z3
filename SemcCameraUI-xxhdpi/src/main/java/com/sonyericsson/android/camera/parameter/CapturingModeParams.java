/*
 * Decompiled with CFR 0_118.
 */
package com.sonyericsson.android.camera.parameter;

import com.sonyericsson.android.camera.ActionMode;
import com.sonyericsson.android.camera.configuration.Configurations;
import com.sonyericsson.android.camera.configuration.parameters.BurstShot;
import com.sonyericsson.android.camera.configuration.parameters.CameraMode;
import com.sonyericsson.android.camera.configuration.parameters.CapturingMode;
import com.sonyericsson.android.camera.configuration.parameters.Ev;
import com.sonyericsson.android.camera.configuration.parameters.Facing;
import com.sonyericsson.android.camera.configuration.parameters.FocusMode;
import com.sonyericsson.android.camera.configuration.parameters.Hdr;
import com.sonyericsson.android.camera.configuration.parameters.Iso;
import com.sonyericsson.android.camera.configuration.parameters.Metering;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValue;
import com.sonyericsson.android.camera.configuration.parameters.ParameterValueHolder;
import com.sonyericsson.android.camera.configuration.parameters.Resolution;
import com.sonyericsson.android.camera.configuration.parameters.Scene;
import com.sonyericsson.android.camera.configuration.parameters.SelfTimer;
import com.sonyericsson.android.camera.configuration.parameters.ShutterSpeed;
import com.sonyericsson.android.camera.configuration.parameters.SmileCapture;
import com.sonyericsson.android.camera.configuration.parameters.SoftSkin;
import com.sonyericsson.android.camera.configuration.parameters.Stabilizer;
import com.sonyericsson.android.camera.configuration.parameters.SuperResolution;
import com.sonyericsson.android.camera.configuration.parameters.VideoCodec;
import com.sonyericsson.android.camera.configuration.parameters.VideoHdr;
import com.sonyericsson.android.camera.configuration.parameters.VideoSize;
import com.sonyericsson.android.camera.configuration.parameters.VideoSmileCapture;
import com.sonyericsson.android.camera.configuration.parameters.VideoStabilizer;
import com.sonyericsson.android.camera.configuration.parameters.WhiteBalance;
import com.sonyericsson.android.camera.parameter.ParameterUtil;
import com.sonyericsson.android.camera.util.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lanchon.dexpatcher.annotation.*;

@DexEdit(defaultAction = DexAction.IGNORE)
public class CapturingModeParams {
    public static final String TAG = "CapturingModeParams";
    private ActionMode mActionMode;
    public ParameterValueHolder<BurstShot> mBurst;
    public ParameterValueHolder<CapturingMode> mCapturingMode;
    private Configurations mConfig;
    public ParameterValueHolder<Ev> mEv;
    public ParameterValueHolder<Facing> mFacing;
    public ParameterValueHolder<FocusMode> mFocusMode;
    public ParameterValueHolder<Hdr> mHdr;
    private boolean mIsOneShot;
    private boolean mIsOneShotVideo;
    public ParameterValueHolder<Iso> mIso;
    public ParameterValueHolder<Metering> mMetering;
    public ParameterValueHolder<Resolution> mResolution;
    public ParameterValueHolder<Scene> mScene;
    public ParameterValueHolder<SelfTimer> mSelfTimer;
    public ParameterValueHolder<SmileCapture> mSmileCapture;
    public ParameterValueHolder<SoftSkin> mSoftSkin;
    public ParameterValueHolder<Stabilizer> mStabilizer;
    public ParameterValueHolder<SuperResolution> mSuperResolution;
    public ParameterValueHolder<VideoCodec> mVideoCodec;
    public ParameterValueHolder<VideoHdr> mVideoHdr;
    public ParameterValueHolder<VideoSize> mVideoSize;
    public ParameterValueHolder<VideoSmileCapture> mVideoSmileCapture;
    public ParameterValueHolder<VideoStabilizer> mVideoStabilizer;
    public ParameterValueHolder<WhiteBalance> mWhiteBalance;
    @DexAdd
    public ParameterValueHolder<ShutterSpeed> mShutterSpeed;
    @DexAdd
    public ParameterValueHolder<CameraMode> mCameraMode;


    @DexReplace
    public CapturingModeParams(CapturingMode mode) {
        this.mCapturingMode = new ParameterValueHolder(mode);
        if(mode == CapturingMode.VIDEO) {
            this.mScene = new ParameterValueHolder(Scene.AUTO);
        } else {
            this.mScene = new ParameterValueHolder(Scene.OFF);
        }

        if(mode.getCameraId() == 1) {
            this.mFacing = new ParameterValueHolder(Facing.FRONT);
        } else {
            this.mFacing = new ParameterValueHolder(Facing.BACK);
        }

        this.mEv = new ParameterValueHolder(Ev.ZERO);
        this.mWhiteBalance = new ParameterValueHolder(WhiteBalance.AUTO);
        this.mResolution = new ParameterValueHolder(Resolution.getDefaultValue(mode));
        this.mSelfTimer = new ParameterValueHolder(SelfTimer.OFF);
        this.mSmileCapture = new ParameterValueHolder(SmileCapture.OFF);
        this.mFocusMode = new ParameterValueHolder(FocusMode.getDefaultValue(mode));
        this.mHdr = new ParameterValueHolder(Hdr.HDR_OFF);
        this.mCameraMode = new ParameterValueHolder(CameraMode.AUTO);
        this.mIso = new ParameterValueHolder(Iso.ISO_400);
        this.mShutterSpeed = new ParameterValueHolder(ShutterSpeed.SHUTTER_SPEED7);
        this.mMetering = new ParameterValueHolder(Metering.getDefaultValue(mode));
        this.mSoftSkin = new ParameterValueHolder(SoftSkin.ON);
        if(mode != CapturingMode.SCENE_RECOGNITION && mode != CapturingMode.SUPERIOR_FRONT) {
            this.mStabilizer = new ParameterValueHolder(Stabilizer.OFF);
        } else {
            this.mStabilizer = new ParameterValueHolder(Stabilizer.AUTO);
        }

        this.mBurst = new ParameterValueHolder(BurstShot.OFF);
        this.mSuperResolution = new ParameterValueHolder(SuperResolution.OFF);
        this.mVideoSize = new ParameterValueHolder(VideoSize.FULL_HD);
        this.mVideoSmileCapture = new ParameterValueHolder(VideoSmileCapture.OFF);
        this.mVideoHdr = new ParameterValueHolder(VideoHdr.OFF);
        if(mode == CapturingMode.SUPERIOR_FRONT || mode == CapturingMode.FRONT_PHOTO || mode == CapturingMode.FRONT_VIDEO)
            this.mVideoStabilizer=new ParameterValueHolder(VideoStabilizer.STEADY_SHOT);
        else this.mVideoStabilizer=new ParameterValueHolder(VideoStabilizer.INTELLIGENT_ACTIVE);

        this.mVideoCodec = new ParameterValueHolder(VideoCodec.H264);

    }

    public ActionMode getActionMode() {
        return this.mActionMode;
    }

    public Configurations getConfig() {
        return this.mConfig;
    }

    @DexReplace
    public void init(boolean isOneShot, boolean isOneShotVideo, Configurations config, SharedPreferencesUtil sharedPrefs) {
        this.mIsOneShot = isOneShot;
        this.mIsOneShotVideo = isOneShotVideo;
        CapturingMode capturingMode = this.mCapturingMode.get();
        this.mActionMode = new ActionMode(isOneShot, capturingMode.getType(), capturingMode.getCameraId());
        this.mConfig = config;
        this.mCapturingMode.setOptions(new CapturingMode[]{capturingMode});
        this.mScene.setOptions(Scene.getOptions(capturingMode));
        this.mFacing.setOptions(Facing.getOptions());
        this.mEv.setOptions(Ev.getOptions(capturingMode));
        this.mWhiteBalance.setOptions(WhiteBalance.getOptions(capturingMode));
        this.mResolution.setOptions(Resolution.getOptions(capturingMode));
        this.mSelfTimer.setOptions(SelfTimer.getOptions());
        this.mSmileCapture.setOptions(SmileCapture.getOptions(capturingMode));
        this.mFocusMode.setOptions(FocusMode.getOptions(capturingMode));
        this.mHdr.setOptions(Hdr.getOptions(capturingMode));
        this.mCameraMode.setOptions(CameraMode.values());
        this.mIso.setOptions(Iso.getOptions(capturingMode, this.mResolution.get()));
        this.mShutterSpeed.setOptions(ShutterSpeed.getOptions(capturingMode));
        this.mMetering.setOptions(Metering.getOptions(capturingMode));
        this.mSoftSkin.setOptions(SoftSkin.getOptions(capturingMode));
        this.mStabilizer.setOptions(Stabilizer.getOptions(capturingMode));
        this.mBurst.setOptions(BurstShot.getOptions(this.mIsOneShot, capturingMode));
        this.mSuperResolution.setOptions(SuperResolution.getOptions(capturingMode, this.mIsOneShotVideo));
        this.mVideoSize.setOptions(VideoSize.getOptions(this.mActionMode, config));
        this.mVideoSmileCapture.setOptions(VideoSmileCapture.getOptions(this.mIsOneShot, capturingMode));
        this.mVideoHdr.setOptions(VideoHdr.getOptions(capturingMode));
        this.mVideoStabilizer.setOptions(VideoStabilizer.getOptions(capturingMode.getCameraId()));
        this.mVideoCodec.setOptions(VideoCodec.getOptions(capturingMode));
        Iterator iterator = this.values().iterator();
        while (iterator.hasNext()) {
            ParameterUtil.updateDefaultValue((ParameterValueHolder)iterator.next());
        }
    }

    public boolean isOneShotVideo() {
        return this.mIsOneShotVideo;
    }

    @DexReplace
    public List values() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mCapturingMode);
        arrayList.add(this.mScene);
        arrayList.add(this.mFacing);
        arrayList.add(this.mEv);
        arrayList.add(this.mWhiteBalance);
        arrayList.add(this.mResolution);
        arrayList.add(this.mSelfTimer);
        arrayList.add(this.mSmileCapture);
        arrayList.add(this.mFocusMode);
        arrayList.add(this.mHdr);
        arrayList.add(this.mCameraMode);
        arrayList.add(this.mIso);
        arrayList.add(this.mShutterSpeed);
        arrayList.add(this.mMetering);
        arrayList.add(this.mSoftSkin);
        arrayList.add(this.mStabilizer);
        arrayList.add(this.mBurst);
        arrayList.add(this.mSuperResolution);
        arrayList.add(this.mVideoSize);
        arrayList.add(this.mVideoSmileCapture);
        arrayList.add(this.mVideoHdr);
        arrayList.add(this.mVideoStabilizer);
        arrayList.add(this.mVideoCodec);
        return arrayList;
    }

}

