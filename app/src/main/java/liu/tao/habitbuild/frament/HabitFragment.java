package liu.tao.habitbuild.frament;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import liu.tao.habitbuild.R;
import liu.tao.habitbuild.activity.HabitDetailActivity;
import liu.tao.habitbuild.adapter.HabitAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HabitFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @BindView(R.id.habit_listview)
    ListView habitListview;

    private HabitAdapter habitAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habit, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (habitAdapter == null) {
            habitAdapter = new HabitAdapter(getContext());
        }
        habitListview.setAdapter(habitAdapter);
        habitListview.setOnItemClickListener(this);
    }

    public HabitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(getContext(), HabitDetailActivity.class);
        this.startActivity(intent);
    }
}
