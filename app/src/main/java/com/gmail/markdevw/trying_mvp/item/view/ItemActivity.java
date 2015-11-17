package com.gmail.markdevw.trying_mvp.item.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Mark on 11/16/2015.
 */
public class ItemActivity extends AppCompatActivity {

    public static Intent newIntent(Context context, String title) {
        Intent intent = new Intent(context, ItemActivity.class);
        intent.putExtra("item_title", title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
