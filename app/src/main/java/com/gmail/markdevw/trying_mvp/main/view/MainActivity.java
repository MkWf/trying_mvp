package com.gmail.markdevw.trying_mvp.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.gmail.markdevw.trying_mvp.R;
import com.gmail.markdevw.trying_mvp.main.presenter.ItemPresenter;
import com.gmail.markdevw.trying_mvp.main.presenter.MainPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.rv_activity_main)
    RecyclerView mRecyclerView;

    @Bind(R.id.tb_activity_main)
    Toolbar mToolbar;

    private ItemPresenter itemPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        itemPresenter = new MainPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
