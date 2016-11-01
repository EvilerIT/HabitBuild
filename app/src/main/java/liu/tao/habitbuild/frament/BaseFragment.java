package liu.tao.habitbuild.frament;

/**
 * Created by Luke on 2016/10/31.
 * 基础Fragment类
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.lang.reflect.Field;


public class BaseFragment extends Fragment {
    protected Handler mHandler = new Handler();
    private boolean detached = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        detached = false;
    }

    /**
     * 这个方法让外部能够访问detached属性
     */
    public boolean isFragmentDetached() {
        return detached;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        detached = true;
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    public void showWithoutAnimations(FragmentActivity activity,
                                      int containerViewId) {
        if (activity == null) {
            if (getActivity() == null) {
                return;
            } else {
                activity = getActivity();
            }
        }
        if (activity.isFinishing()) {
            return;
        }
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(containerViewId, this);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
