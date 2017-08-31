package com.codeteenager.mobileplay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codeteenager.mobileplay.ui.bean.FragmentInfo;
import com.codeteenager.mobileplay.ui.fragment.CategoryFragment;
import com.codeteenager.mobileplay.ui.fragment.GamesFragment;
import com.codeteenager.mobileplay.ui.fragment.RankingFragment;
import com.codeteenager.mobileplay.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrui on 2017/8/31.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mFragments = new ArrayList<>(4);

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {
        mFragments.add(new FragmentInfo("推荐", RecommendFragment.class));
        mFragments.add(new FragmentInfo("排行", RankingFragment.class));
        mFragments.add(new FragmentInfo("游戏", GamesFragment.class));
        mFragments.add(new FragmentInfo("分类", CategoryFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
