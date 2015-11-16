package com.gmail.markdevw.trying_mvp.main.presenter;

import java.util.List;

/**
 * Created by Mark on 11/16/2015.
 */
public interface OnSearchFinishedListener {
    public void onSuccess(List<String> result);
    public void onError(String search);
}
