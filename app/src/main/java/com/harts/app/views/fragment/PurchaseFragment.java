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

public class PurchaseFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(PurchaseFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.purchase_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.purchase_history));
        //startPurchaseConfirmedScreen();
        return view;
    }

    @OnClick(R.id.vg_state_container)
    public void onPurchaseConfirmedClick() {
        startPurchaseConfirmedScreen();
    }

    private void startPurchaseConfirmedScreen() {
        PurchaseConfirmedFragment fragment = new PurchaseConfirmedFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, PurchaseConfirmedFragment.class.getName())
                .addToBackStack(BalancePendingFragment.class.getName())
                .commit();
    }
}
