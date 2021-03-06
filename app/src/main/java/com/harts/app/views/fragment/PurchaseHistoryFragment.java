package com.harts.app.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.harts.app.R;
import com.harts.app.data.model.PurchaseItem;
import com.harts.app.views.adapter.PurchaseHistoryAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import static com.harts.app.util.LogUtils.makeLogTag;

public class PurchaseHistoryFragment extends CommonFragment {

    @BindView(R.id.rv_purchase_list) RecyclerView rvPurchaseList;
    PurchaseHistoryAdapter listAdapter;

    private static final String LOG_TAG = makeLogTag(PurchaseHistoryFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.purchase_history_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.purchase_history));
        setUpList();
        //startPurchaseScreen();
        return view;
    }

    private void setUpList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvPurchaseList.setLayoutManager(layoutManager);
        listAdapter = new PurchaseHistoryAdapter();
        listAdapter.setOnClickListener(listItemClickListener);
        rvPurchaseList.setAdapter(listAdapter);

        listAdapter.setData(new ArrayList<PurchaseItem>(
                Arrays.asList(
                        new PurchaseItem("21.01.2019 / 04:58", "11.79$"),
                        new PurchaseItem("23.01.2019 / 04:58", "8.82$"),
                        new PurchaseItem("24.01.2019 / 04:58", "116 200 \u20BD"),
                        new PurchaseItem("21.01.2019 / 04:58", "11.79$"),
                        new PurchaseItem("23.01.2019 / 04:58", "8.82$"),
                        new PurchaseItem("24.01.2019 / 04:58", "116 200 \u20BD"),
                        new PurchaseItem("21.01.2019 / 04:58", "11.79$"),
                        new PurchaseItem("23.01.2019 / 04:58", "8.82$"),
                        new PurchaseItem("24.01.2019 / 04:58", "116 200 \u20BD"),
                        new PurchaseItem("21.01.2019 / 04:58", "11.79$"),
                        new PurchaseItem("23.01.2019 / 04:58", "8.82$"),
                        new PurchaseItem("24.01.2019 / 04:58", "116 200 \u20BD")
                )
        ));
    }

    PurchaseHistoryAdapter.ClickListener listItemClickListener = item -> {
        startPurchaseScreen();
    };

    private void startPurchaseScreen() {
        PurchaseFragment fragment = new PurchaseFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, PurchaseFragment.class.getName())
                .addToBackStack(BalancePendingFragment.class.getName())
                .commit();
    }
}
