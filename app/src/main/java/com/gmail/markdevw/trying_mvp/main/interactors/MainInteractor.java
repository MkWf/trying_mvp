package com.gmail.markdevw.trying_mvp.main.interactors;

import android.os.Handler;

import com.gmail.markdevw.trying_mvp.main.presenter.OnSearchFinishedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mark on 11/16/2015.
 */
public class MainInteractor implements ItemInteractor {

    @Override
    public void searchForItems(final String search, final OnSearchFinishedListener listener) {
        int size = 20;
        List<String> fakeItems = new ArrayList<>(size);
        for(int i = 0; i < size + 1; i++){
            int j = i + 1;
            fakeItems.add(search + " item #" + j);
        }

        createRandomDelayedResponse(fakeItems, listener, search);
    }

    private void createRandomDelayedResponse(final List<String> items, final OnSearchFinishedListener listener, final String search){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();
                int val = ran.nextInt(2);

                switch(val){
                    case 0:
                        listener.onSuccess(items);
                        break;
                    case 1:
                        listener.onError(search);
                        break;
                }
            }
        }, 2000);
    }
}
