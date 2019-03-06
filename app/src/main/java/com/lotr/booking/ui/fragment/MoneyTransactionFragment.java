package com.lotr.booking.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lotr.booking.R;

import static com.lotr.booking.util.LogUtils.makeLogTag;

public class MoneyTransactionFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(MoneyTransactionFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.money_transaction_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.money_transaction));
        return view;
    }

    @OnClick(R.id.btn_return_to_dashboard)
    public void onReturnToDashboardClick() {
        startDashboardScreen();
    }

    private void startDashboardScreen() {
        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
