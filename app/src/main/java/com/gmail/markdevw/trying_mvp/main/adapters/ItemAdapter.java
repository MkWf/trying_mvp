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

    public ItemAdapter(){
        items = new ArrayList<>();
    }

    @Override
    public ItemAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search, viewGroup, false);

        return new ItemAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ItemAdapterViewHolder itemAdapterViewHolder, int index) {
        itemAdapterViewHolder.update(items.get(index));
    }

    @Override
    public int getItemCount() {
        if(items != null){
            return items.size();
        }else{
            return 0;
        }
    }

    public void setItems(List<String> data) {
        items.addAll(data);
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
