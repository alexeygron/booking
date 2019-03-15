package com.lotr.booking.ui.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lotr.booking.R;
import com.lotr.booking.R2;
import com.lotr.booking.data.model.FaqItem;
import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

import static com.lotr.booking.util.Helpers.isNumberEven;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

    private List<FaqItem> items;
    private Resources res;

    public void setData(List<FaqItem> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_list_item, parent, false);
        res = v.getResources();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        FaqItem item = items.get(position);

        holder.container.setBackgroundColor(isNumberEven(position) ? res.getColor(R.color.lightGray) : res.getColor(R.color.white));
        holder.expandable_text.setBackgroundColor(isNumberEven(position) ? res.getColor(R.color.white) : res.getColor(R.color.lightGray));

        holder.tvTitle.setText(item.getTitle());
        holder.expandable_text.setText(item.getText());

        holder.container.setOnClickListener(v -> holder.expandableLayout.toggle());

        holder.expandableLayout.setOnExpansionUpdateListener((expansionFraction, state) -> {
            if (state == 2) {
                holder.iv_arrow.setImageResource(R.drawable.ic_arrow_up);
            } else if (state == 1) {
                holder.iv_arrow.setImageResource(R.drawable.ic_arrow_down);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.tvTitle) TextView tvTitle;
        @BindView(R2.id.expandable_text) TextView expandable_text;
        @BindView(R2.id.iv_arrow) ImageView iv_arrow;
        @BindView(R2.id.expandable_layout) ExpandableLayout expandableLayout;
        @BindView(R2.id.container) ViewGroup container;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
