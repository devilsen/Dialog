package me.devilsen.list;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;

/**
 * desc :
 * date : 2018/2/23
 *
 * @author : dongSen
 */
public interface BottomListInterface {

    void setData(Context context, @MenuRes int xmlRes);

    void setItemClickListener(ItemClickListener itemClickListener);

    void add(int id, int order,@StringRes int textRes);

    void dismissDialog();

}
