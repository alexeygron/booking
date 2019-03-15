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
import com.lotr.booking.data.model.FaqItem;
import com.lotr.booking.data.model.WithdrawalItem;
import com.lotr.booking.ui.adapter.FaqAdapter;
import com.lotr.booking.ui.adapter.WithdrawalHistoryAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import static com.lotr.booking.util.LogUtils.makeLogTag;

public class QuestionsAnswersFragment extends CommonFragment {

    @BindView(R.id.rv_faq_list) RecyclerView rvFaqList;
    private FaqAdapter faqAdapter;

    private static final String LOG_TAG = makeLogTag(QuestionsAnswersFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questions_answers_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.questions_answers));
        setUpList();
        return view;
    }

    private void setUpList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFaqList.setLayoutManager(layoutManager);
        faqAdapter = new FaqAdapter();
        //faqAdapter.setOnClickListener(listItemClickListener);
        rvFaqList.setAdapter(faqAdapter);

        faqAdapter.setData(new ArrayList<FaqItem>(
                Arrays.asList(
                        new FaqItem("Что такое «кэшбэк»?", getString(R.string.text)),
                        new FaqItem("Откуда берется кэшбэк?",  getString(R.string.text)),
                        new FaqItem("А бесплатны ли для покупателя услуги СКИДКА РУ?",  getString(R.string.text)),
                        new FaqItem("Как покупать и получать кэшбэк",  getString(R.string.text)),
                        new FaqItem("А какова минимальная сумма вывода?",  getString(R.string.text)),
                        new FaqItem("А будет ли кэшбэк, если я использую\n" +
                                "карту Кукуруза, Малина, Связной-Клуб,\n" +
                                "Много.ру и другие карты лояльности?",  getString(R.string.text))
                )
        ));
    }

    /*@OnClick(R.id.vg_questions_answers)
    public void onQuestionsAnswersClick() {

    }*/

    private void startPurchaseConfirmedScreen() {
        PurchaseConfirmedFragment fragment = new PurchaseConfirmedFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, PurchaseConfirmedFragment.class.getName())
                .addToBackStack(BalancePendingFragment.class.getName())
                .commit();
    }
}
