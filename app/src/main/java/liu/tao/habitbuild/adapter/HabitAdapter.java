package liu.tao.habitbuild.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import liu.tao.habitbuild.R;
import liu.tao.habitbuild.activity.HabitDetailActivity;

/**
 * Created by Luke on 2016/11/1.
 * 习惯展示ListView
 */

public class HabitAdapter extends BaseAdapter {
    private ViewHolder viewHolder;
private Context context;
    public HabitAdapter(Context context) {
        this.context = context;
    }

    public HabitAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_habit, null);
            viewHolder = new ViewHolder(convertView);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, HabitDetailActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.habit_name)
        TextView habitName;
        @BindView(R.id.habit_target)
        TextView habitTarget;
        @BindView(R.id.habit_time)
        TextView habitTime;
        @BindView(R.id.habit_check)
        ImageButton habitCheck;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
