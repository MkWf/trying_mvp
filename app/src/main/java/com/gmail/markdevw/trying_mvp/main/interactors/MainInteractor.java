package com.gmail.markdevw.trying_mvp.main.interactors;

import com.gmail.markdevw.trying_mvp.main.presenter.OnSearchFinishedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mark on 11/16/2015.
 */
public class MainInteractor implements ItemInteractor {

    @Override
    public void searchForItems(String search, OnSearchFinishedListener listener) {
        int size = 20;
        List<String> fakeItems = new ArrayList<>(size);
        for(int i = 0; i < size + 1; i++){
            fakeItems.add(search + " item #" + i+1);
        }

        //50-50 chance of "retrieving" items or displaying an error to test both scenarios
        Random ran = new Random();
        int val = ran.nextInt(2);

        switch(val){
            case 0:
                listener.onSuccess(fakeItems);
                break;
            case 1:
                listener.onError(search);
                break;
        }

    }
}
