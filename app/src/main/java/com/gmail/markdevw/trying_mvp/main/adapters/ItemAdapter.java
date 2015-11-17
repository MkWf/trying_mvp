package com.gmail.markdevw.trying_mvp.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.markdevw.trying_mvp.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mark on 11/16/2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    public static interface Delegate {
        public void onItemClicked(ItemAdapter itemAdapter, String item);
    }

    private WeakReference<Delegate> delegate;
    private List<String> items;

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

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.item_title)
        TextView title;
        
        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void update(String item) {
            title.setText(item);
        }

        @Override
        public void onClick(View v) {
            getDelegate().onItemClicked(ItemAdapter.this, title.getText().toString());
        }
    }

    public Delegate getDelegate() {
        if (delegate == null) {
            return null;
        }
        return delegate.get();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = new WeakReference<Delegate>(delegate);
    }
}
