package com.harts.app.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.harts.app.R;
import com.harts.app.data.model.WithdrawalItem;

import static com.harts.app.util.LogUtils.makeLogTag;

public class WithdrawalTargetFragment extends CommonFragment {

    private WithdrawalItem withdrawalItem;
    private static final String LOG_TAG = makeLogTag(WithdrawalTargetFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.withdrawal_target_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, withdrawalItem.getDate());
        return view;
    }

    public void setWithdrawalItem(WithdrawalItem withdrawalItem) {
        this.withdrawalItem = withdrawalItem;
    }
}
