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

public class HelpFragment extends CommonFragment {

    private static final String LOG_TAG = makeLogTag(HelpFragment.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpToolbar(view, R.id.toolbar, false, getString(R.string.help));
        return view;
    }

    @OnClick(R.id.vg_questions_answers)
    public void onQuestionsAnswersClick() {
        startQuestionsAnswerScreen();
    }

    @OnClick(R.id.vg_legal_information)
    public void onLegalInformationClick() {
        startQuestionsAnswerScreen();
    }

    @OnClick(R.id.vg_about_company)
    public void onAboutCompanyClick() {
        startQuestionsAnswerScreen();
    }

    @OnClick(R.id.vg_start_information)
    public void onStartInformationClick() {
        startQuestionsAnswerScreen();
    }

    private void startQuestionsAnswerScreen() {
        QuestionsAnswersFragment fragment = new QuestionsAnswersFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, QuestionsAnswersFragment.class.getName())
                .addToBackStack(QuestionsAnswersFragment.class.getName())
                .commit();
    }
}
