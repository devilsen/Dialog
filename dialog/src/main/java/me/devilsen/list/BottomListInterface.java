package me.devilsen.list;

import android.content.Context;
import android.support.annotation.MenuRes;

/**
 * desc :
 * date : 2018/2/23
 *
 * @author : dongSen
 */
public interface BottomListInterface {

    void setData(Context context, @MenuRes int xmlRes);

    void setItemClickListener(ItemClickListener itemClickListener);

    void dismissDialog();

}
