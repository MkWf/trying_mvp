package com.gmail.markdevw.trying_mvp.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.markdevw.trying_mvp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mark on 11/16/2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    List<String> items;

    @Override
    public ItemAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search, viewGroup, false);

        items = new ArrayList<>();

        return new ItemAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ItemAdapterViewHolder itemAdapterViewHolder, int index) {
        itemAdapterViewHolder.update(items.get(index));
    }

    @Override
    public int getItemCount() {
       return items.size();
    }

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_title)
        TextView title;
        
        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void update(String item) {
            title.setText(item);
        }
    }
}
