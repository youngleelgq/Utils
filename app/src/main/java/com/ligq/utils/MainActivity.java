package com.ligq.utils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.SpriteFactory;
import com.github.ybq.android.spinkit.Style;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.greendao.gen.UserDao;

import java.util.List;
import java.util.Random;

/**
 * @author young
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private UserDao mUserDao = GreenDaoHelper.getDaoSession().getUserDao();
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.show_pop);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPop();
            }
        });

        initViews();
    }

    private void initViews() {
        Button insert = findViewById(R.id.insert);
        final Button delete = findViewById(R.id.delete);
        final Button update = findViewById(R.id.update);
        final Button query = findViewById(R.id.query);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryData();
            }
        });
    }

    private void queryData() {
        List<User> users = mUserDao.queryBuilder().build().list();
        for (User user : users) {
            Log.i(TAG, "queryData: user=" + user.toString());
        }
        showToast("query success");
    }

    private void updateData() {
        User user = new User((long) 4, "lisa", 23, "female","laa");
        mUserDao.update(user);
        showToast("update data success");
    }

    private void deleteData() {
        List<User> user2 = mUserDao.queryBuilder().where(UserDao.Properties.Id.eq(6)).build().list();
        for (User user : user2) {
            Log.i(TAG, "queryData: user=" + user.toString());
            mUserDao.delete(user);
        }
        showToast("delete success");
    }

    private void insertData() {
        Random random = new Random();
        int age = random.nextInt(30);
        mUserDao.insert(new User(null, "张三" + age, age, "male","guaua"));
        showToast("insert success");
    }

    private void showPop() {
        //设置contentView
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_pop, null);
        SpinKitView spinKitView = contentView.findViewById(R.id.spin_kit);
        Style style = Style.values()[7];
        Sprite drawable = SpriteFactory.create(style);
        spinKitView.setIndeterminateDrawable(drawable);
        PopupWindow mPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setContentView(contentView);

        mPopWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
    }

    @SuppressLint("ShowToast")
    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
