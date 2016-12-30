package com.rakshith.staggeredgridsample.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rakshith.staggeredgridsample.MainActivity;
import com.rakshith.staggeredgridsample.Model.StaggeredGridModel;
import com.rakshith.staggeredgridsample.R;
import com.rakshith.staggeredgridsample.listners.ItemTouchHelperAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by rakshith on 12/29/16.
 */
public class StaggereGridViewAdapter extends RecyclerView.Adapter<StaggereGridViewAdapter.StaggeredViewHolder> implements ItemTouchHelperAdapter {

    List<StaggeredGridModel> staggeredGridModels;
    Activity activity;

    public StaggereGridViewAdapter(Activity mActivity, List<StaggeredGridModel> staggeredGridList) {
        staggeredGridModels = staggeredGridList;
        activity = mActivity;
    }

    @Override
    public StaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.sample_row, null);
        return new StaggeredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StaggeredViewHolder holder, int position) {
        StaggeredGridModel staggeredGridModel = staggeredGridModels.get(position);
        holder.tvTitle.setText(staggeredGridModel.getTitle());
        holder.ivImage.setImageResource(staggeredGridModel.getImage());
    }

    @Override
    public int getItemCount() {
        return staggeredGridModels.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(staggeredGridModels, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(staggeredGridModels, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        staggeredGridModels.remove(position);
        notifyItemRemoved(position);
    }

    public class StaggeredViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivImage;

        public StaggeredViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.sample_row_tv_title);
            ivImage = (ImageView) itemView.findViewById(R.id.sample_row_iv_image);
        }
    }
}

