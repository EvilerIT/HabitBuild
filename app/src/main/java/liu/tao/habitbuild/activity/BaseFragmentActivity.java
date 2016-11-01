package liu.tao.habitbuild.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RefWatcher refWatcher = QiyiReaderApplication.getRefWatcher(this);
//        refWatcher.watch(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (grantResults.length == 0) {
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
