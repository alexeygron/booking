package com.harts.app.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.harts.app.R;

import static com.harts.app.util.LogUtils.makeLogTag;

public class DashboardFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(DashboardFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, true, getString(R.string.my_dashboard));
        //startPurchaseHistoryScreen();
        //startBalanceScreen();
        //startWithdrawalMoneyHistoryScreen();
        //startHelpScreen();
        return view;
    }

    @OnClick(R.id.vg_balance)
    public void onBalanceClick() {
        startBalanceScreen();
    }

    @OnClick(R.id.vg_booking_history)
    public void onBookingHistoryClick() {
        startPurchaseHistoryScreen();
    }

    @OnClick(R.id.vg_withdrawal_history)
    public void onWithdrawalHistoryClick() {
        startWithdrawalMoneyHistoryScreen();
    }

    @OnClick(R.id.vg_support)
    public void onSupportClick() {

    }

    @OnClick(R.id.vg_notifications)
    public void onNotificationsClick() {

    }

    @OnClick(R.id.vg_help)
    public void onHelpClick() {
        startHelpScreen();
    }

    @OnClick(R.id.vg_my_country)
    public void onMyCountryClick() {

    }

    @OnClick(R.id.vg_personal_data)
    public void onPersonalDataClick() {

    }

    private void startBalanceScreen() {
        BalancePendingFragment fragment = new BalancePendingFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, BalancePendingFragment.class.getName())
                .addToBackStack(BalancePendingFragment.class.getName())
                .commit();
    }

    private void startPurchaseHistoryScreen() {
        PurchaseHistoryFragment fragment = new PurchaseHistoryFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, PurchaseHistoryFragment.class.getName())
                .addToBackStack(PurchaseHistoryFragment.class.getName())
                .commit();
    }

    private void startWithdrawalMoneyHistoryScreen() {
        WithdrawalMoneyHistoryFragment fragment = new WithdrawalMoneyHistoryFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, WithdrawalMoneyHistoryFragment.class.getName())
                .addToBackStack(WithdrawalMoneyHistoryFragment.class.getName())
                .commit();
    }

    private void startHelpScreen() {
        HelpFragment fragment = new HelpFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, HelpFragment.class.getName())
                .addToBackStack(HelpFragment.class.getName())
                .commit();
    }
}
