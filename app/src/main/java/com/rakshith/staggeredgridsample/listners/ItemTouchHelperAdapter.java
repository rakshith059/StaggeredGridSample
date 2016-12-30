package com.rakshith.staggeredgridsample.listners;

/**
 * Created by rakshith on 12/29/16.
 */
public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
