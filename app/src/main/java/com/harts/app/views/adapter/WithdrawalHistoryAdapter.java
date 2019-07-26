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
import com.harts.app.data.model.WithdrawalItem;

import java.util.ArrayList;
import java.util.List;

public class WithdrawalHistoryAdapter extends RecyclerView.Adapter<WithdrawalHistoryAdapter.ViewHolder> {

    private List<WithdrawalItem> data = new ArrayList<>();
    private ClickListener clickListener;

    public WithdrawalHistoryAdapter() {
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setData(List<WithdrawalItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.withdrawall_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        WithdrawalItem item = data.get(position);
        holder.tvDate.setText(item.getDate());
        holder.tvScore.setText(item.getSum());
        holder.tvTarget.setText(item.getTarget());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_date) TextView tvDate;
        @BindView(R.id.tv_score) TextView tvScore;
        @BindView(R.id.tv_target) TextView tvTarget;

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
        void onClick(WithdrawalItem item);
    }
}
