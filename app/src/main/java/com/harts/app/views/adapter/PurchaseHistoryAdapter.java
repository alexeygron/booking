package com.harts.app.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.harts.app.R;
import com.harts.app.data.model.PurchaseItem;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryAdapter.ViewHolder> {

    private List<PurchaseItem> data = new ArrayList<>();
    private ClickListener clickListener;

    public PurchaseHistoryAdapter() {
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setData(List<PurchaseItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        PurchaseItem item = data.get(position);
        holder.tvDate.setText(item.getDate());
        holder.tvPrice.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_date) TextView tvDate;
        @BindView(R.id.tv_price) TextView tvPrice;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.container)
        public void onClick() {
            if (clickListener != null) {
                clickListener.onClick(data.get(getAdapterPosition()));
            }
        }
    }

    public interface ClickListener {
        void onClick(PurchaseItem item);
    }
}
