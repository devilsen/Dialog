package me.devilsen.sheet.bottom.listsheet;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.view.View;

import me.devilsen.list.BottomListHelper;
import me.devilsen.list.BottomListInterface;
import me.devilsen.list.ItemClickListener;
import me.devilsen.sheet.bottom.BaseBottomSheet;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
public class ListBottomSheet extends BaseBottomSheet implements BottomListInterface {

    private BottomListHelper bottomListHelper;

    public ListBottomSheet() {
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
    public void add(int id, int order, @StringRes int textRes) {
        bottomListHelper.add(id, order, textRes);
    }

    @Override
    public void dismissDialog() {
        dismiss();
    }


    public static class Builder {

        private final Context context;

        private final FragmentManager manager;

        @MenuRes
        private int xmlRes;

        private ItemClickListener itemClickListener;

        public Builder(Context context, FragmentManager manager) {
            this.context = context;
            this.manager = manager;
        }

        public Builder sheet(@MenuRes int xmlRes) {
            this.xmlRes = xmlRes;
            return this;
        }

        public Builder listener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
            return this;
        }

        public ListBottomSheet build() {
            ListBottomSheet listBottomSheet = new ListBottomSheet();
            listBottomSheet.setData(context, xmlRes);
            listBottomSheet.setItemClickListener(itemClickListener);
            return listBottomSheet;
        }
    }


}
