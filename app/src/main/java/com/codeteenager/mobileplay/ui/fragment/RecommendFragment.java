package com.codeteenager.mobileplay.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codeteenager.mobileplay.R;
import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.presenter.RecommendPresenter;
import com.codeteenager.mobileplay.presenter.contract.RecommendContract;
import com.codeteenager.mobileplay.ui.adapter.RecommendAppAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangrui on 2017/8/31.
 */

public class RecommendFragment extends Fragment implements RecommendContract.View {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ProgressDialog mProgressDialog;
    private RecommendPresenter mPresenter;
    private RecommendAppAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, null);
        ButterKnife.bind(this, view);
        mProgressDialog = new ProgressDialog(getActivity());
        mPresenter = new RecommendPresenter(this);
        initData();
        return view;
    }

    private void initData() {
        mPresenter.requestDatas();
    }

    private void initRecycleView(List<AppInfo> datas) {
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //为RecyclerView设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        //动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecommendAppAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoadding() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoadding() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "服务器开小差" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(List<AppInfo> datas) {
        initRecycleView(datas);
    }
}
