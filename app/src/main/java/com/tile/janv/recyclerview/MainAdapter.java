package com.tile.janv.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    // A good online example
    // https://www.binpress.com/tutorial/android-l-recyclerview-and-cardview-tutorial/156

    private List<CharacterDescription> mDataList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MainViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView vImage;
        public TextView vName;
        public TextView vDescription;

        public MainViewHolder(View v) {
            super(v);
            vImage =  (ImageView) v.findViewById(R.id.card_image);
            vName =  (TextView) v.findViewById(R.id.card_name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MainAdapter(List<CharacterDescription> mDataList) {
        this.mDataList = mDataList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new MainViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        CharacterDescription description = mDataList.get(position);
        holder.vImage.setImageResource(description.id);
        holder.vName.setText(description.name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}
