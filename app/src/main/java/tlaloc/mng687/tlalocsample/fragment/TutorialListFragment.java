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
import tlaloc.mng687.tlalocsample.model.Tutorial;

/**
 * Created by mng687 on 2/21/15.
 */
public class TutorialListFragment extends ListFragment {
    private ArrayList<Tutorial> mTutorials;

    public ArrayList<Tutorial> getTutorials() {
        return mTutorials;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setTutorials(ArrayList<Tutorial> mTutorials) {
        this.mTutorials = mTutorials;
    }

    public static TutorialListFragment newInstance(ArrayList<Tutorial> tips) {
        TutorialListFragment fragment = new TutorialListFragment();
        fragment.setTutorials(tips);
        return fragment;
    }

    public static TutorialListFragment newInstance(Tutorial[] tutorials) {
        return newInstance(new ArrayList<>(Arrays.asList(tutorials)));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.list_item, R.id.tv_1, getTutorials()));

        return v;
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
                                ((Tutorial) getListAdapter().getItem(position)).getTutorial_contents()
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
