package com.google.android.apps.androidify.a;

public enum h {
    HEAD_ROTATE("head-rotation"),
    HEAD_POSITION_X("head-position", 0, true),
    HEAD_POSITION_Y("head-position", 1, true),
    BODY_ROTATE("body-rotation"),
    BODY_POSITION_X("body-position", 0, true),
    BODY_POSITION_Y("body-position", 1, true),
    MASTER_ROTATE("master-rotation"),
    MASTER_POSITION_X("master-position", 0, true),
    MASTER_POSITION_Y("master-position", 1, true),
    MASTER_SCALE("master-scale", 0, false),
    LEFT_SHOULDER_ROTATE("armLeft-rotation"),
    LEFT_SHOULDER_POSITION_X("armLeft-position", 0, true),
    LEFT_SHOULDER_POSITION_Y("armLeft-position", 1, true),
    RIGHT_SHOULDER_ROTATE("armRight-rotation"),
    RIGHT_SHOULDER_POSITION_X("armRight-position", 0, true),
    RIGHT_SHOULDER_POSITION_Y("armRight-position", 1, true),
    LEFT_ELBOW_ROTATE("not used"),
    RIGHT_ELBOW_ROTATE("not used"),
    LEFT_HIP_ROTATE("legLeft-rotation"),
    LEFT_HIP_POSITION_X("legLeft-position", 0, true),
    LEFT_HIP_POSITION_Y("legLeft-position", 1, true),
    RIGHT_HIP_ROTATE("legRight-rotation"),
    RIGHT_HIP_POSITION_X("legRight-position", 0, true),
    RIGHT_HIP_POSITION_Y("legRight-position", 1, true),
    LEFT_KNEE_ROTATE("not used"),
    RIGHT_KNEE_ROTATE("not used"),
    LEFT_FOOT_ROTATE("footLeft-rotation"),
    RIGHT_FOOT_ROTATE("footRight-rotation"),
    LEFT_ANTENNA_ROTATE("antennaLeft-rotation"),
    RIGHT_ANTENNA_ROTATE("antennaRight-rotation"),
    LEFT_EYE_SCALE("eyeLeft-scale", 1, false),
    RIGHT_EYE_SCALE("eyeRight-scale", 1, false),
    LEFT_EYE_ROTATION("eyeLeft-rotation", 0, false),
    RIGHT_EYE_ROTATION("eyeRight-rotation", 0, false),
    EYES_POSITION_X("eyes-position", 0, true),
    EYES_POSITION_Y("eyes-position", 1, true),
    BLINK_LEFT_SCALE("blinkLeft-scale", 1, false),
    BLINK_RIGHT_SCALE("blinkRight-scale", 1, false),
    BLINK_LEFT_POSITION_X("blinkLeft-position", 0, true),
    BLINK_LEFT_POSITION_Y("blinkLeft-position", 1, true),
    BLINK_RIGHT_POSITION_X("blinkRight-position", 0, true),
    BLINK_RIGHT_POSITION_Y("blinkRight-position", 1, true),
    PROP_ROTATE("prop-rotation"),
    PROP_POSITION_X("prop-position", 0, true),
    PROP_POSITION_Y("prop-position", 1, true),
    PROP_SCALE_X("prop-scale", 0, false),
    PROP_SCALE_Y("prop-scale", 1, false);
    
    public String V;
    public int W;
    public boolean X;
    public double Y;
    public float Z;

    static {
        MASTER_POSITION_X.Y = -960.0d;
        MASTER_POSITION_Y.Y = -540.0d;
        HEAD_POSITION_Y.Y = 170.1999969482422d;
        LEFT_SHOULDER_POSITION_X.Y = 182.8000030517578d;
        LEFT_SHOULDER_POSITION_Y.Y = 152.39999389648438d;
        RIGHT_SHOULDER_POSITION_X.Y = -182.8000030517578d;
        RIGHT_SHOULDER_POSITION_Y.Y = 152.39999389648438d;
        BODY_POSITION_X.Y = -0.6000000238418579d;
        BODY_POSITION_Y.Y = 4.0d;
        LEFT_HIP_POSITION_X.Y = 7.300000190734863d;
        LEFT_HIP_POSITION_Y.Y = -13.800000190734863d;
        RIGHT_HIP_POSITION_X.Y = -8.399999618530273d;
        RIGHT_HIP_POSITION_Y.Y = -13.800000190734863d;
        EYES_POSITION_Y.Y = 60.0d;
        LEFT_EYE_SCALE.Z = 100.0f;
        RIGHT_EYE_SCALE.Z = 100.0f;
        BLINK_LEFT_SCALE.Z = 100.0f;
        BLINK_RIGHT_SCALE.Z = 100.0f;
        PROP_SCALE_Y.Z = 100.0f;
        PROP_SCALE_X.Z = 100.0f;
        MASTER_SCALE.Z = 100.0f;
    }

    private h(String str) {
        this.W = 0;
        this.X = false;
        this.Y = 0.0d;
        this.Z = 0.0f;
        this.V = str;
    }

    private h(String str, int i, boolean z) {
        this.W = 0;
        this.X = false;
        this.Y = 0.0d;
        this.Z = 0.0f;
        this.V = str;
        this.W = i;
        this.X = z;
    }
}
