package me.devilsen.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import me.devilsen.dialog.R;

/**
 * author : dongSen
 * date : 2017/5/9
 * desc : list bottom sheet decoration
 */
class LineItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable divider;

    /**
     * Custom divider will be used
     */
    LineItemDecoration(Context context) {
        divider = ContextCompat.getDrawable(context, R.drawable.view_bottom_sheet_divider);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + divider.getIntrinsicHeight();

            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

}
