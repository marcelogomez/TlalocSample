package tlaloc.mng687.tlalocsample.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.Arrays;

import tlaloc.mng687.tlalocsample.R;
import tlaloc.mng687.tlalocsample.model.Quiz;

/**
 * Created by mng687 on 2/21/15.
 */
public class QuizListFragment extends ListFragment {
    private ArrayList<Quiz> mQuizzes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.list_item, R.id.tv_1, getQuizzes()));
        return v;
    }

    public static QuizListFragment newInstance(ArrayList<Quiz> quizzes) {
        QuizListFragment fragment = new QuizListFragment();
        fragment.setQuizzes(quizzes);

        return fragment;
    }

    public static QuizListFragment newInstance(Quiz[] quizzes) {
        return newInstance(new ArrayList<>(Arrays.asList(quizzes)));
    }

    public ArrayList<Quiz> getQuizzes() {
        return mQuizzes;
    }

    public void setQuizzes(ArrayList<Quiz> mQuizzes) {
        this.mQuizzes = mQuizzes;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListFragment fragment = new ListFragment();
                fragment.setListAdapter(new ArrayAdapter<>(
                                getActivity(),
                                R.layout.list_item, R.id.tv_1,
                                ((Quiz) getListAdapter().getItem(position)).getQuestions()
                        )
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}
