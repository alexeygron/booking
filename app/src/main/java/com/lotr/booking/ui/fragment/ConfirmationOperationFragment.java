package com.lotr.booking.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lotr.booking.R;

import static com.lotr.booking.util.LogUtils.makeLogTag;

public class ConfirmationOperationFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(ConfirmationOperationFragment.class);
    @BindView(R.id.et_sms_code) EditText etSmsCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.confirmation_operation_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.confirmation_operation));
        //startTransactionScreen();
        return view;
    }

    @OnClick(R.id.btn_confirm)
    public void onConfirmClick() {
        startTransactionScreen();
        hideInput(etSmsCode);
    }

    private void startTransactionScreen() {
        MoneyTransactionFragment fragment = new MoneyTransactionFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, MoneyTransactionFragment.class.getName())
                .addToBackStack(MoneyTransactionFragment.class.getName())
                .commit();
    }

    @Override
    public void onStop() {
        super.onStop();
        hideInput(etSmsCode);
    }
}
