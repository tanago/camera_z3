//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sonyericsson.android.camera.configuration.parameters;

import lanchon.dexpatcher.annotation.*;

@DexReplace
public interface ParameterApplicable {
    void commit();

    void set(AutoReview var1);

    void set(AutoUpload var1);

    void set(BurstShot var1);

    void set(CapturingMode var1);

    void set(DestinationToSave var1);

    void set(Ev var1);

    void set(Facing var1);

    void set(FastCapture var1);

    void set(Flash var1);

    void set(FocusMode var1);

    void set(Geotag var1);

    void set(GridLine var1);

    void set(Hdr var1);

    void set(Iso var1);

    void set(Metering var1);

    void set(PhotoLight var1);

    void set(Resolution var1);

    void set(Scene var1);

    void set(SelfTimer var1);

    void set(ShutterSound var1);

    void set(SmileCapture var1);

    void set(SoftSkin var1);

    void set(Stabilizer var1);

    void set(SuperResolution var1);

    void set(TouchBlock var1);

    void set(TouchCapture var1);

    void set(VideoCodec var1);

    void set(VideoHdr var1);

    void set(VideoSize var1);

    void set(VideoSmileCapture var1);

    void set(VideoStabilizer var1);

    void set(VolumeKey var1);

    void set(WhiteBalance var1);

    @DexAdd
    void set(ShutterSpeed shutterSpeed);
}
