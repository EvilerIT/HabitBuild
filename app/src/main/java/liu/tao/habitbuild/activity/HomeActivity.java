package liu.tao.habitbuild.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import liu.tao.habitbuild.R;
import liu.tao.habitbuild.frament.BaseFragment;
import liu.tao.habitbuild.frament.HabitFragment;
import liu.tao.habitbuild.frament.MineFragment;
import liu.tao.habitbuild.frament.SettingFragment;
import liu.tao.habitbuild.view.MainMenuView;


public class HomeActivity extends BaseFragmentActivity implements MainMenuView.OnSelectedChangeListener {
    @BindView(R.id.text_navi_title)
    TextView textNaviTitle;
    @BindView(R.id.btn_navi_back)
    ImageButton btnNaviBack;
    @BindView(R.id.btn_navi_search)
    ImageButton btnNaviSearch;
    @BindView(R.id.share)
    TextView share;
    @BindView(R.id.relativeLayout)
    RelativeLayout layoutNavi;
    @BindView(R.id.mainframe)
    FrameLayout mainframe;
    @BindView(R.id.layout_menu)
    MainMenuView layoutMenu;
    private List<BaseFragment> fragments = new ArrayList<>();
    private HabitFragment habitFragment;
    private MineFragment mineFragment;
    private SettingFragment settingFragment;

    private final int SELECTED_INDEX_HABIT = 0;
    private final int SELECTED_INDEX_MINE = SELECTED_INDEX_HABIT + 1;
    private final int SELECTED_INDEX_SETTING = SELECTED_INDEX_MINE + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        layoutMenu.setOnSelectedChangeListener(this);
        OnSelectedChange(SELECTED_INDEX_HABIT);
    }

    private void showFragment(BaseFragment fragment) {
        if (fragment.isFragmentDetached()) {
            return;
        }
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        for (BaseFragment bFragment : fragments) {
            if (bFragment == fragment) {
                ft.show(bFragment);
            } else {
                ft.hide(bFragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    @Override
    public void OnSelectedChange(int index) {
        switch (index) {
            case SELECTED_INDEX_HABIT:
                if (habitFragment == null) {
                    habitFragment = new HabitFragment();
                    fragments.add(habitFragment);
                    habitFragment.showWithoutAnimations(this, R.id.mainframe);
                }
                showFragment(habitFragment);
                break;
            case SELECTED_INDEX_MINE:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    fragments.add(mineFragment);
                    mineFragment.showWithoutAnimations(this, R.id.mainframe);
                }
                showFragment(mineFragment);
                break;
            case SELECTED_INDEX_SETTING:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    fragments.add(settingFragment);
                    settingFragment.showWithoutAnimations(this, R.id.mainframe);
                }
                showFragment(settingFragment);
                break;
        }
    }
}
