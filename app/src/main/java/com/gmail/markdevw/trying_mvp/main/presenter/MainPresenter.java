package com.gmail.markdevw.trying_mvp.main.presenter;

import com.gmail.markdevw.trying_mvp.main.interactors.ItemInteractor;
import com.gmail.markdevw.trying_mvp.main.interactors.MainInteractor;
import com.gmail.markdevw.trying_mvp.main.view.MainView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Mark on 11/16/2015.
 */
public class MainPresenter implements ItemPresenter, OnSearchFinishedListener{

    private WeakReference<MainView> mainView;
    private ItemInteractor itemInteractor;

    public MainPresenter(WeakReference<MainView> mainView) {
        this.mainView = mainView;
        itemInteractor = new MainInteractor();
    }

    @Override
    public void performSearch(String search) {
        if(mainView != null){
            MainView view = mainView.get();
            view.showProgressBar();
            itemInteractor.searchForItems(search, this);
        }
    }

    @Override
    public void onSuccess(List<String> result) {
        if(mainView != null){
            MainView view = mainView.get();
            view.hideProgressBar();
            view.setAdapter(result);
        }
    }

    @Override
    public void onError(String search) {
        if (mainView != null) {
            MainView view = mainView.get();
            view.hideProgressBar();
            view.showError(search);
        }
    }
}
