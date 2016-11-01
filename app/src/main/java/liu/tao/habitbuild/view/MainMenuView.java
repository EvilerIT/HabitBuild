package liu.tao.habitbuild.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import liu.tao.habitbuild.R;

public class MainMenuView extends LinearLayout implements View.OnClickListener {
    private View container;
    private Context context;
    private View bookshelf;
    private View select;
    private View setting;

    private int currentIndex = 1;

    private OnSelectedChangeListener listener;
    private IMenuItemClickListener menuItemClickListener;

    private List<View> menuItems = new ArrayList<View>();


    public MainMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MainMenuView(Context context) {
        super(context);
        this.context = context;
        init();
    }


    private void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        container = inflater.inflate(R.layout.layout_menu, null);
        addView(container, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        bookshelf = findViewById(R.id.bookshelf);
        select = findViewById(R.id.select);
        setting = findViewById(R.id.setting);
        bookshelf.setOnClickListener(this);
        select.setOnClickListener(this);
        setting.setOnClickListener(this);
        menuItems.add(bookshelf);
        menuItems.add(select);
        menuItems.add(setting);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        for (int index = 0; index < menuItems.size(); index++) {
            if (menuItems.get(index).getId() == id) {
                setSelectedIndex(index);
            }
        }
    }


    public void setSelectedIndex(int index) {
        if (index < 0)
            index = 0;
        if (index >= menuItems.size())
            index = menuItems.size();
        for (int i = 0; i < menuItems.size(); i++) {
            if (i == index) {
                menuItems.get(i).setSelected(true);
            } else {
                menuItems.get(i).setSelected(false);
            }
        }
        if (index != -1) {
            currentIndex = index;
            onSelectedChange(index);
        }
    }


    private void onSelectedChange(int index) {
        if (listener != null)
            listener.OnSelectedChange(index);
    }


    public int getSelectedIndex() {
        return currentIndex;
    }


    public void setCurrentIndex(int index) {
        currentIndex = index;
    }


    public void setOnSelectedChangeListener(OnSelectedChangeListener listener) {
        this.listener = listener;
    }


    public interface OnSelectedChangeListener {
        public void OnSelectedChange(int index);
    }

    public void setOnMenuItemClickListener(IMenuItemClickListener listener) {
        this.menuItemClickListener = listener;
    }

    public interface IMenuItemClickListener {
        public void onMenuItemClick(int index);
    }

}
