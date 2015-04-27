package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

import com.google.android.apps.p017c.UtilInterpolator;

import java.util.ArrayList;
import java.util.List;

import dev.game.legend.avatar.R;

public class TutorialView extends View {
    private static final Interpolator INTERPOLATOR;
    private static final AccelerateInterpolator ACCELERATE_INTERPOLATOR;
    private List list;
    private int nr1;
    private int nr2;
    private float float1;
    private Bitmap[] bitmap;
    private Paint mPaint;
    private TransitionType f955i;
    private float mFloat2;
    private float mFloat3;
    private float f958l;
    private long f959m;
    private long f960n;
    private boolean f961o;

    static {
        INTERPOLATOR = new UtilInterpolator();
        ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    }

    public TutorialView(Context context) {
        super(context);
        this.nr1 = 0;
        this.nr2 = 0;
        this.f955i = TransitionType.FADING_IN;
        this.f958l = -2.14748365E9f;
        this.f959m = 0;
        this.f960n = 0;
        this.f961o = false;
        m1587a(context, null);
    }

    public TutorialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nr1 = 0;
        this.nr2 = 0;
        this.f955i = TransitionType.FADING_IN;
        this.f958l = -2.14748365E9f;
        this.f959m = 0;
        this.f960n = 0;
        this.f961o = false;
        m1587a(context, attributeSet);
    }

    public TutorialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nr1 = 0;
        this.nr2 = 0;
        this.f955i = TransitionType.FADING_IN;
        this.f958l = -2.14748365E9f;
        this.f959m = 0;
        this.f960n = 0;
        this.f961o = false;
        m1587a(context, attributeSet);
    }

    public void addTransition(float x, float y, DirectionState dmVar, String str, boolean z) {
        this.list.add(new Transition(x, y, dmVar, str, z));
        invalidate();
    }

    public void m1585a(float f, float f2, DirectionState dmVar, String str, boolean z, float f3, int i) {
        Transition transition = new Transition(f, f2, dmVar, str, z);
        transition.height = f3;
        transition.f1634i = i;
        transition.f1633h = i;
        this.list.add(transition);
        invalidate();
    }

    public void m1586a(int i, float f, float f2) {
        Transition transition = (Transition) this.list.get(i);
        transition.f1626a = f;
        transition.y = f2;
        invalidate();
    }

    public void m1587a(Context context, AttributeSet attributeSet) {
        this.float1 = getResources().getDimension(R.dimen.tutorial_arrow_distance);
        this.mFloat2 = getResources().getDimension(R.dimen.tutorial_text_size);
        this.mFloat3 = getResources().getDimension(R.dimen.tutorial_text_baseline);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf"));
        this.mPaint.setTextSize(this.mFloat2);
        this.mPaint.setColor(Constants.ANDROID_COLOR.intValue());
        this.list = new ArrayList();
        this.bitmap = new Bitmap[DirectionState.values().length];
        for (int i = 0; i < DirectionState.values().length; i++) {
            this.bitmap[i] = BitmapFactory.decodeResource(getResources(), DirectionState.values()[i].mCurrent);
        }
    }

    public void m1588a(boolean z) {
        if (!z && (this.f955i == TransitionType.OUT || this.f955i == TransitionType.FADING_OUT)) {
            return;
        }
        if (!z || (this.f955i != TransitionType.FADING_IN && this.f955i != TransitionType.IN)) {
            if (z) {
                if (this.nr2 > this.nr1) {
                    this.nr1 = this.nr2;
                    this.f958l = -2.14748365E9f;
                }
                this.f955i = TransitionType.FADING_IN;
            } else {
                this.f955i = TransitionType.FADING_OUT;
            }
            this.f960n = System.currentTimeMillis();
            invalidate();
        }
    }

    public boolean m1589a() {
        if (this.nr1 == this.list.size() - 1) {
            return true;
        }
        this.nr2 = this.nr1 + 1;
        m1588a(false);
        invalidate();
        return false;
    }

    public void m1590b() {
        if (this.list.size() > 0) {
            Transition c0222do = (Transition) this.list.get(this.nr1);
            c0222do.f1634i--;
            if (c0222do.f1634i == 0) {
                c0222do.hidden = true;
                invalidate();
            }
        }
    }

    public boolean m1591c() {
        return this.list.size() > 0 ? ((Transition) this.list.get(this.nr2)).hidden : false;
    }

    public boolean hasMoreSteps() {
        if (this.list.size() <= 0) {
            return false;
        }
        Transition c0222do = (Transition) this.list.get(this.nr2);
        return c0222do.hidden || (c0222do.f1633h > c0222do.f1634i);
    }

    public boolean isCurrentStepVisible() {
        return ((Transition) this.list.get(this.nr2)).hidden;
    }

    public int getStepCount() {
        return this.list.size();
    }

    public int getStepIndex() {
        return this.nr2;
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        float f = 0.0f;
        super.onDraw(canvas);
        if (this.f959m == 0) {
            this.f959m = System.currentTimeMillis();
        }
        if (!this.list.isEmpty()) {
            float a;
            Transition transition;
            Bitmap bitmap;
            float a2;
            float f2;
            float height;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f960n;
            if (this.f955i == TransitionType.FADING_IN) {
                if (j2 > 1800) {
                    this.f955i = TransitionType.IN;
                }
            } else if (this.f955i == TransitionType.FADING_OUT && j2 > 300) {
                this.f955i = TransitionType.OUT;
            }
            if (this.f955i == TransitionType.OUT && this.nr2 > this.nr1) {
                this.nr1 = this.nr2;
                this.f958l = -2.14748365E9f;
                if (!this.f961o) {
                    this.f955i = TransitionType.FADING_IN;
                    this.f960n = currentTimeMillis;
                    if (this.f955i == TransitionType.FADING_IN) {
                        a = by.m1899a((float) j, 0.0f, 1800.0f, 0.0f, 1.0f, INTERPOLATOR);
                    } else if (this.f955i != TransitionType.FADING_OUT) {
                        a = by.m1899a((float) j, 0.0f, 300.0f, 1.0f, 0.0f, ACCELERATE_INTERPOLATOR);
                    } else {
                        a = 1.0f;
                    }
                    transition = (Transition) this.list.get(this.nr1);
                    if (this.f955i != TransitionType.OUT) {
                        canvas.save();
                        bitmap = this.bitmap[transition.f1629d.ordinal()];
                        a2 = (by.m1900a(System.currentTimeMillis() - this.f959m, 1250.0f) * this.float1) / 3.0f;
                        switch (DirectionConvertor.mState[transition.f1629d.ordinal()]) {
                            case cm.HListView_android_divider /*1*/:
                                f2 = (transition.f1626a + this.float1) + a2;
                                f = transition.y - (((float) bitmap.getHeight()) / 2.0f);
                                break;
                            case cm.HListView_hlv_dividerWidth /*2*/:
                                f2 = ((transition.f1626a - this.float1) - ((float) bitmap.getWidth())) + a2;
                                f = transition.y - (((float) bitmap.getHeight()) / 2.0f);
                                break;
                            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                                f2 = transition.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                                f = (transition.y + this.float1) + a2;
                                break;
                            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                                f2 = transition.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                                f = ((transition.y - this.float1) - ((float) bitmap.getHeight())) + a2;
                                break;
                            case cm.HListView_hlv_overScrollHeader /*5*/:
                                f2 = (transition.f1626a + this.float1) + a2;
                                f = (transition.y + this.float1) + a2;
                                break;
                            default:
                                f2 = 0.0f;
                                break;
                        }
                        a2 = (((float) bitmap.getWidth()) / 2.0f) + f2;
                        height = (((float) bitmap.getHeight()) / 2.0f) + f;
                        if (a < 1.0f) {
                            canvas.scale(a, a, a2, height);
                        }
                        canvas.drawBitmap(bitmap, f2, f, this.mPaint);
                        canvas.restore();
                        canvas.save();
                        if (this.f958l == -2.14748365E9f) {
                            this.f958l = (((float) getWidth()) - this.mPaint.measureText(transition.mtext)) / 2.0f;
                        }
                        f = (float) (getWidth() / 2);
                        f2 = (((float) getHeight()) - this.mFloat3) - transition.height;
                        if (a < 1.0f) {
                            canvas.scale(a, a, f, f2);
                        }
                        canvas.drawText(transition.mtext, this.f958l, (((float) getHeight()) - this.mFloat3) - transition.height, this.mPaint);
                        canvas.restore();
                    }
                    invalidate();
                }
            }
            j = j2;
            if (this.f955i == TransitionType.FADING_IN) {
                a = by.m1899a((float) j, 0.0f, 1800.0f, 0.0f, 1.0f, INTERPOLATOR);
            } else if (this.f955i != TransitionType.FADING_OUT) {
                a = 1.0f;
            } else {
                a = by.m1899a((float) j, 0.0f, 300.0f, 1.0f, 0.0f, ACCELERATE_INTERPOLATOR);
            }
            transition = (Transition) this.list.get(this.nr1);
            if (this.f955i != TransitionType.OUT) {
                canvas.save();
                bitmap = this.bitmap[transition.f1629d.ordinal()];
                a2 = (by.m1900a(System.currentTimeMillis() - this.f959m, 1250.0f) * this.float1) / 3.0f;
                switch (DirectionConvertor.mState[transition.f1629d.ordinal()]) {
                    case cm.HListView_android_divider /*1*/:
                        f2 = (transition.f1626a + this.float1) + a2;
                        f = transition.y - (((float) bitmap.getHeight()) / 2.0f);
                        break;
                    case cm.HListView_hlv_dividerWidth /*2*/:
                        f2 = ((transition.f1626a - this.float1) - ((float) bitmap.getWidth())) + a2;
                        f = transition.y - (((float) bitmap.getHeight()) / 2.0f);
                        break;
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        f2 = transition.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                        f = (transition.y + this.float1) + a2;
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        f2 = transition.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                        f = ((transition.y - this.float1) - ((float) bitmap.getHeight())) + a2;
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        f2 = (transition.f1626a + this.float1) + a2;
                        f = (transition.y + this.float1) + a2;
                        break;
                    default:
                        f2 = 0.0f;
                        break;
                }
                a2 = (((float) bitmap.getWidth()) / 2.0f) + f2;
                height = (((float) bitmap.getHeight()) / 2.0f) + f;
                if (a < 1.0f) {
                    canvas.scale(a, a, a2, height);
                }
                canvas.drawBitmap(bitmap, f2, f, this.mPaint);
                canvas.restore();
                canvas.save();
                if (this.f958l == -2.14748365E9f) {
                    this.f958l = (((float) getWidth()) - this.mPaint.measureText(transition.mtext)) / 2.0f;
                }
                f = (float) (getWidth() / 2);
                f2 = (((float) getHeight()) - this.mFloat3) - transition.height;
                if (a < 1.0f) {
                    canvas.scale(a, a, f, f2);
                }
                canvas.drawText(transition.mtext, this.f958l, (((float) getHeight()) - this.mFloat3) - transition.height, this.mPaint);
                canvas.restore();
            }
            invalidate();
        }
    }

    public void setHidden(boolean z) {
        this.f961o = z;
        if (z && (this.f955i == TransitionType.IN || this.f955i == TransitionType.FADING_IN)) {
            m1588a(false);
        } else if (!z) {
            if (this.f955i == TransitionType.OUT || this.f955i == TransitionType.FADING_OUT) {
                m1588a(true);
            }
        }
    }
}
