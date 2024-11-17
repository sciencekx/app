package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private int lastFragmentIndex;
    private Map<MenuItem, Integer> menuIndexMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化碎片
        fragments = new Fragment[4];
        fragmentManager = getSupportFragmentManager();

        fragments[0] = new ChatFragment();
        fragments[1] = new ContactsFragment();
        fragments[2] = new DiscoverFragment();
        fragments[3] = new MeFragment();

        // 加载默认碎片
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragments[0]);
        transaction.commit();
        lastFragmentIndex = 0;

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 初始化菜单项到索引的映射
        menuIndexMap = new HashMap<>();
        menuIndexMap.put(bottomNavigationView.getMenu().getItem(0), 0); // navigation_chat
        menuIndexMap.put(bottomNavigationView.getMenu().getItem(1), 1); // navigation_contacts
        menuIndexMap.put(bottomNavigationView.getMenu().getItem(2), 2); // navigation_discover
        menuIndexMap.put(bottomNavigationView.getMenu().getItem(3), 3); // navigation_me

        // 处理导航栏点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item){
                        // 使用映射表获取选择的碎片索引
                        Integer index = menuIndexMap.get(item);

                        // 切换碎片
                        if(index != null && lastFragmentIndex != index){
                            switchFragment(lastFragmentIndex, index);
                            lastFragmentIndex = index;
                        }
                        return true;
                    }
                }
        );
    }

    private void switchFragment(int fromIndex, int toIndex){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragments[fromIndex]);
        if(!fragments[toIndex].isAdded()){
            transaction.add(R.id.container, fragments[toIndex]);
        }
        transaction.show(fragments[toIndex]).commitAllowingStateLoss();
    }
}
