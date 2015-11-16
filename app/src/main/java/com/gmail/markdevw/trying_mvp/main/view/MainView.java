package com.gmail.markdevw.trying_mvp.main.view;

import java.util.List;

/**
 * Created by Mark on 11/16/2015.
 */
public interface MainView {
    public void showProgressBar();
    public void hideProgressBar();
    public void setAdapter(List<String> result);
    public void showError(String search);
}
