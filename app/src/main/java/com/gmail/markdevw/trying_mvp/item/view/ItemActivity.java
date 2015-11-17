package com.gmail.markdevw.trying_mvp.item.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gmail.markdevw.trying_mvp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mark on 11/16/2015.
 */
public class ItemActivity extends AppCompatActivity {

    private static final String ITEM_TITLE = "item_title";

    public static Intent newIntent(Context context, String title) {
        Intent intent = new Intent(context, ItemActivity.class);
        intent.putExtra(ITEM_TITLE, title);
        return intent;
    }

    @Bind(R.id.activity_item_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        title.setText(getIntent().getExtras().getString(ITEM_TITLE));
    }
}
