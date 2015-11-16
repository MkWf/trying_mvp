package com.gmail.markdevw.trying_mvp.main.view;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gmail.markdevw.trying_mvp.R;
import com.gmail.markdevw.trying_mvp.main.adapters.ItemAdapter;
import com.gmail.markdevw.trying_mvp.main.presenter.ItemPresenter;
import com.gmail.markdevw.trying_mvp.main.presenter.MainPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.rv_activity_main)
    RecyclerView mRecyclerView;

    @Bind(R.id.tb_activity_main)
    Toolbar mToolbar;

    @Bind(R.id.pb_item_search)
    ProgressBar mProgressBar;

    private ItemPresenter itemPresenter;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        itemPresenter = new MainPresenter(this);
        itemAdapter = new ItemAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(itemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
            itemPresenter.performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setAdapter(List<String> result) {
        itemAdapter.setItems(result);
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String search) {
        Toast.makeText(this, "Failed to retrieve items for " + search, Toast.LENGTH_LONG).show();
    }
}
