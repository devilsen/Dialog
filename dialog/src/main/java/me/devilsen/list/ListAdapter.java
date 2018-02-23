package me.devilsen.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.devilsen.dialog.R;

/**
 * desc :
 * date : 2018/2/22
 *
 * @author : dongSen
 */
class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ActionMenu menus;

    private ItemClickListener itemClickListener;

    private DismissListener dismissListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_bottom_sheet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem item = menus.getItem(position);

        if (item == null) {
            return;
        }

        holder.textView.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return menus == null ? 0 : menus.size();
    }

    void setListData(ActionMenu data) {
        menus = data;
    }

    void setItemClickListener(ItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    void setOnDismissListener(DismissListener dismissListener) {
        this.dismissListener = dismissListener;
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

            if (position > -1 && itemClickListener != null) {
                itemClickListener.OnItemClickListener(menus.getItem(position));
            }

            if (position > -1 && dismissListener != null) {
                dismissListener.onDismiss();
            }
        }
    }
}
