package com.lotr.booking.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lotr.booking.R;

import static com.lotr.booking.util.LogUtils.makeLogTag;

public class BalanceSelectAmountFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(BalanceSelectAmountFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.balance_select_amount_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.balance));
        //startConfirmationOperationScreen();
        return view;
    }

    @OnClick(R.id.vg_balance)
    public void onBalanceClick() {
        startConfirmationOperationScreen();
    }

    @OnClick(R.id.btn_further)
    public void onConfirmationClick() {
        startConfirmationOperationScreen();
    }

    private void startConfirmationOperationScreen() {
        ConfirmationOperationFragment fragment = new ConfirmationOperationFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, ConfirmationOperationFragment.class.getName())
                .addToBackStack(ConfirmationOperationFragment.class.getName())
                .commit();
    }
}
