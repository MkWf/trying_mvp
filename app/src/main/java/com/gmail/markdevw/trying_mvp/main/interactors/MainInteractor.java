package com.gmail.markdevw.trying_mvp.main.interactors;

import com.gmail.markdevw.trying_mvp.main.presenter.OnSearchFinishedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 11/16/2015.
 */
public class MainInteractor implements ItemInteractor {

    @Override
    public void searchForItems(String search, OnSearchFinishedListener listener) {
        int size = 20;
        List<String> fakeItems = new ArrayList<>(size);
        for(int i = 0; i < size + 1; i++){
            fakeItems.add(search + " item #" + i++);
            listener.onSuccess(fakeItems);
        }
    }
}
