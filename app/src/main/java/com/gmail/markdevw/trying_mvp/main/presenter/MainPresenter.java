package com.gmail.markdevw.trying_mvp.main.presenter;

import com.gmail.markdevw.trying_mvp.main.interactors.ItemInteractor;
import com.gmail.markdevw.trying_mvp.main.view.MainView;

import java.util.List;

/**
 * Created by Mark on 11/16/2015.
 */
public class MainPresenter implements ItemPresenter, OnSearchFinishedListener{

    private MainView mainView;
    private ItemInteractor itemInteractor;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void performSearch(String search) {
        mainView.showProgressBar();
        itemInteractor.searchForItems(search, this);
    }

    @Override
    public void onSuccess(List<String> result) {
        mainView.hideProgressBar();
        mainView.setAdapter(result);
    }

    @Override
    public void onError() {
        mainView.hideProgressBar();
    }
}
