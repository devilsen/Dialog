package me.devilsen.sheet.bottom.listsheet;

import android.support.annotation.MenuRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import me.devilsen.dialog.R;
import me.devilsen.sheet.bottom.BaseBottomSheet;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
public class ListBottomSheet extends BaseBottomSheet {

    private ListAdapter listAdapter;

//    private final ActionMenu menu;

    @Override
    public int getLayoutRes() {
        return R.layout.layout_list_bottom_sheet;
    }

    @Override
    public void bindView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_list_bottom_sheet);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new LineItemDecoration(getContext()));

        recyclerView.setAdapter(listAdapter);
    }

    public void setData(ArrayList<String> data) {
        if (listAdapter == null) {
            listAdapter = new ListAdapter();
        }

        listAdapter.setListData(data);
    }

    public void test(@MenuRes int xmlRes){
//        new MenuInflater(getContext()).inflate(xmlRes, );
    }
}
