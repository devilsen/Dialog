package me.devilsen.dialog.bottom;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.view.View;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */

public class BottomDialog extends BaseBottomDialog {

    private FragmentManager mFragmentManager;

    private ViewListener mViewListener;

    public static BottomDialog create(FragmentManager manager) {
        BottomDialog dialog = new BottomDialog();
        dialog.setFragmentManager(manager);
        return dialog;
    }

    @Override
    public void bindView(View v) {
        if (mViewListener != null) {
            mViewListener.bindView(v);
        }
    }

    @Override
    public int getLayoutRes() {
        return mLayoutRes;
    }

    public BottomDialog setFragmentManager(FragmentManager manager) {
        mFragmentManager = manager;
        return this;
    }

    public BottomDialog setViewListener(ViewListener listener) {
        mViewListener = listener;
        return this;
    }

    public BottomDialog setLayoutRes(@LayoutRes int layoutRes) {
        mLayoutRes = layoutRes;
        return this;
    }

    public interface ViewListener {
        void bindView(View v);
    }

    public BaseBottomDialog show() {
        show(mFragmentManager);
        return this;
    }
}