package me.devilsen.dialog.bottom;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.view.View;

import me.devilsen.list.BottomListHelper;
import me.devilsen.list.BottomListInterface;
import me.devilsen.list.ItemClickListener;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
public class ListBottomDialog extends BaseBottomDialog implements BottomListInterface {

    private BottomListHelper bottomListHelper;

    public ListBottomDialog() {
        bottomListHelper = new BottomListHelper(this);
    }

    @Override
    public int getLayoutRes() {
        return bottomListHelper.getLayoutRes();
    }

    @Override
    public void bindView(View view) {
        bottomListHelper.bindView(getContext(), view);
    }

    @Override
    public void setData(Context context, @MenuRes int xmlRes) {
        bottomListHelper.setData(context, xmlRes);
    }

    @Override
    public void setItemClickListener(ItemClickListener itemClickListener) {
        bottomListHelper.setItemClickListener(itemClickListener);
    }

    @Override
    public void add(int id, int order, int textRes) {
        bottomListHelper.add(id, order, textRes);
    }

    @Override
    public void dismissDialog() {
        dismiss();
    }


}
