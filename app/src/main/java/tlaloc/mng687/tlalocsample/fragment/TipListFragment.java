package tlaloc.mng687.tlalocsample.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import tlaloc.mng687.tlalocsample.R;
import tlaloc.mng687.tlalocsample.model.Tip;

/**
 * Created by mng687 on 2/21/15.
 */
public class TipListFragment extends ListFragment {
    private ArrayList<Tip> mTips;

    public ArrayList<Tip> getTips() {
        return mTips;
    }

    public void setTips(ArrayList<Tip> mTips) {
        this.mTips = mTips;
    }

    public static TipListFragment newInstance(ArrayList<Tip> tips) {
        TipListFragment fragment = new TipListFragment();
        fragment.setTips(tips);
        return fragment;
    }

    public static TipListFragment newInstance(Tip[] tips) {
        return newInstance(new ArrayList<>(Arrays.asList(tips)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.list_item, R.id.tv_1, getTips()));
        return v;
    }


}
