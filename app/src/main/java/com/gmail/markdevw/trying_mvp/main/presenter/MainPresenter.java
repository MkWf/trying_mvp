package com.gmail.markdevw.trying_mvp.main.presenter;

import com.gmail.markdevw.trying_mvp.main.view.MainView;

/**
 * Created by Mark on 11/16/2015.
 */
public class MainPresenter implements ItemPresenter{

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void searchForItems(String search) {

    }
}
