package liu.tao.habitbuild.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import liu.tao.habitbuild.R;

/**
 * Created by Luke on 2016/11/1.
 * 首页日期显示View
 */

public class WeekShowView extends LinearLayout {
    private Context context;
    private List<TextView> listTextView = new ArrayList<>();
    private List<TextView> listWeek = new ArrayList<>();

    public WeekShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public WeekShowView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_week, null);
        initViews(view);
        addView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        updateView();
    }

    private void initViews(View view) {
        listTextView.clear();
        listTextView.add((TextView) view.findViewById(R.id.monday_txview));
        listTextView.add((TextView) view.findViewById(R.id.tuesday_txview));
        listTextView.add((TextView) view.findViewById(R.id.wednesday_txview));
        listTextView.add((TextView) view.findViewById(R.id.thursday_txview));
        listTextView.add((TextView) view.findViewById(R.id.friday_txview));
        listTextView.add((TextView) view.findViewById(R.id.staursday_txview));
        listTextView.add((TextView) view.findViewById(R.id.sunday_txview));

        listWeek.clear();
        listWeek.add((TextView) view.findViewById(R.id.monday));
        listWeek.add((TextView) view.findViewById(R.id.tuesday));
        listWeek.add((TextView) view.findViewById(R.id.wednesday));
        listWeek.add((TextView) view.findViewById(R.id.thursday));
        listWeek.add((TextView) view.findViewById(R.id.friday));
        listWeek.add((TextView) view.findViewById(R.id.staursday));
        listWeek.add((TextView) view.findViewById(R.id.sunday));

    }

    private void updateView() {
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        listTextView.get(currentDay - 2).setTextColor(context.getResources().getColor(R.color.main_line));
        listWeek.get(currentDay - 2).setTextColor(context.getResources().getColor(R.color.main_line));
        for (int index = 1; index <= listTextView.size(); index++) {
            listTextView.get(index - 1).setText(String.valueOf(getDate(index - currentDay + 1)));
        }
    }

    public int getDate(int index) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, index);
        return calendar.get(Calendar.DATE);
    }
}
