package com.rakshith.staggeredgridsample.Model;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.rakshith.staggeredgridsample.Adapter.StaggereGridViewAdapter;
import com.rakshith.staggeredgridsample.listners.ItemTouchHelperAdapter;

/**
 * Created by rakshith on 12/30/16.
 */
public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    ItemTouchHelperAdapter itemTouchHelperAdapter;

    public SimpleItemTouchHelperCallback(StaggereGridViewAdapter staggereGridViewAdapter) {
        itemTouchHelperAdapter = staggereGridViewAdapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags , swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        itemTouchHelperAdapter.onItemMove(source.getAdapterPosition() , target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        itemTouchHelperAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

}
