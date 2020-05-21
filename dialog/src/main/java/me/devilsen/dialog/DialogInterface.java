package me.devilsen.dialog;

import androidx.fragment.app.FragmentManager;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
interface DialogInterface {

    float getDimAmount();

    int getHeight();

    boolean getCancelOutside();

    String getFragmentTag();

    BaseDialog setCancelOutside(boolean cancel);

    BaseDialog setTag(String tag);

    BaseDialog setDimAmount(float dim);

    BaseDialog setHeight(int heightPx);

    void show(FragmentManager fragmentManager);

}
