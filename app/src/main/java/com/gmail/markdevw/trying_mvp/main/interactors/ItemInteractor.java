package com.gmail.markdevw.trying_mvp.main.interactors;

import com.gmail.markdevw.trying_mvp.main.presenter.OnSearchFinishedListener;

/**
 * Created by Mark on 11/16/2015.
 */
public interface ItemInteractor {
    public void searchForItems(String search, OnSearchFinishedListener listener);
}
