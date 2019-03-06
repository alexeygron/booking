package com.lotr.booking.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lotr.booking.R;
import com.lotr.booking.data.model.PurchaseItem;
import com.lotr.booking.data.model.WithdrawalItem;
import com.lotr.booking.ui.adapter.PurchaseHistoryAdapter;
import com.lotr.booking.ui.adapter.WithdrawalHistoryAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import static com.lotr.booking.util.LogUtils.makeLogTag;

public class WithdrawalMoneyHistoryFragment extends CommonFragment {

    @BindView(R.id.rv_purchase_list) RecyclerView rvPurchaseList;
    WithdrawalHistoryAdapter listAdapter;

    private static final String LOG_TAG = makeLogTag(WithdrawalMoneyHistoryFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.withdrawal_money_history_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.withdrawal_money_history));
        setUpList();
        //startPurchaseScreen();
        return view;
    }

    private void setUpList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvPurchaseList.setLayoutManager(layoutManager);
        listAdapter = new WithdrawalHistoryAdapter();
        listAdapter.setOnClickListener(listItemClickListener);
        rvPurchaseList.setAdapter(listAdapter);

        listAdapter.setData(new ArrayList<WithdrawalItem>(
                Arrays.asList(
                        new WithdrawalItem("05.02.2019", "100.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("24.01.2019", "600.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("28.06.2018", "551.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("05.02.2019", "100.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("24.01.2019", "600.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("28.06.2018", "551.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("24.01.2019", "600.00 \u20BD", "Visa / Mastercard"),
                        new WithdrawalItem("28.06.2018", "551.00 \u20BD", "Visa / Mastercard")
                )
        ));
    }

    WithdrawalHistoryAdapter.ClickListener listItemClickListener = this::startPurchaseScreen;

    private void startPurchaseScreen(WithdrawalItem item) {
        WithdrawalTargetFragment fragment = new WithdrawalTargetFragment();
        fragment.setWithdrawalItem(item);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, WithdrawalTargetFragment.class.getName())
                .addToBackStack(WithdrawalTargetFragment.class.getName())
                .commit();
    }
}
