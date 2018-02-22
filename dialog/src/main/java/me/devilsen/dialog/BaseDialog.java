package me.devilsen.dialog;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
public abstract class BaseDialog extends DialogFragment implements DialogInterface {

    private static final String TAG = "base_dialog";

    private static final String KEY_LAYOUT_RES = "bottom_layout_res";
    private static final String KEY_HEIGHT = "bottom_height";
    private static final String KEY_DIM = "bottom_dim";
    private static final String KEY_CANCEL_OUTSIDE = "bottom_cancel_outside";

    protected static final float DEFAULT_DIM = 0.4f;

    private boolean mIsCancelOutside = true;

    private String mTag = TAG;

    private float mDimAmount = DEFAULT_DIM;

    private int mHeight = -1;

    @LayoutRes
    protected int mLayoutRes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(getCancelOutside());

        View v = inflater.inflate(getLayoutRes(), container, false);
        bindView(v);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mLayoutRes = savedInstanceState.getInt(KEY_LAYOUT_RES);
            mHeight = savedInstanceState.getInt(KEY_HEIGHT);
            mDimAmount = savedInstanceState.getFloat(KEY_DIM);
            mIsCancelOutside = savedInstanceState.getBoolean(KEY_CANCEL_OUTSIDE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_LAYOUT_RES, mLayoutRes);
        outState.putInt(KEY_HEIGHT, mHeight);
        outState.putFloat(KEY_DIM, mDimAmount);
        outState.putBoolean(KEY_CANCEL_OUTSIDE, mIsCancelOutside);

        super.onSaveInstanceState(outState);
    }

    @LayoutRes
    public abstract int getLayoutRes();

    public abstract void bindView(View v);

    @Override
    public float getDimAmount() {
        return mDimAmount;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    @Override
    public boolean getCancelOutside() {
        return mIsCancelOutside;
    }

    @Override
    public String getFragmentTag() {
        return mTag;
    }

    @Override
    public BaseDialog setCancelOutside(boolean cancel) {
        mIsCancelOutside = cancel;
        return this;
    }

    @Override
    public BaseDialog setTag(String tag) {
        mTag = tag;
        return this;
    }

    @Override
    public BaseDialog setDimAmount(float dim) {
        mDimAmount = dim;
        return this;
    }

    @Override
    public BaseDialog setHeight(int heightPx) {
        mHeight = heightPx;
        return this;
    }

    @Override
    public void show(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            Log.e(TAG, "the fragmentManager is null!");
            return;
        }
        show(fragmentManager, getFragmentTag());
    }
}