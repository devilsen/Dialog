package me.devilsen.sheet.bottom.listsheet;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import me.devilsen.dialog.R;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<String> listData;

    ListAdapter() {
        listData = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_bottom_sheet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    void setListData(ArrayList<String> data) {
        listData.clear();
        listData.addAll(data);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_list_bottom_sheet);

            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            if (position > -1) {
                Log.e("test", listData.get(position));
            }
        }
    }
}
