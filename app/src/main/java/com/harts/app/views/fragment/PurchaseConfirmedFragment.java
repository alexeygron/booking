package com.harts.app.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.harts.app.R;

import static com.harts.app.util.LogUtils.makeLogTag;

public class PurchaseConfirmedFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(PurchaseConfirmedFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.purchase_confirmed_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.confirmed));
        return view;
    }

}
