package com.rakshith.staggeredgridsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.rakshith.staggeredgridsample.Adapter.StaggereGridViewAdapter;
import com.rakshith.staggeredgridsample.Model.SimpleItemTouchHelperCallback;
import com.rakshith.staggeredgridsample.Model.StaggeredGridModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvStaggeredView;
    StaggeredGridLayoutManager gridLayoutManager;
    List<StaggeredGridModel> staggeredGridList = new ArrayList<>();

    ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvStaggeredView = (RecyclerView) findViewById(R.id.activity_main_rv_staggeredview);
        rvStaggeredView.setHasFixedSize(true);

        gridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        rvStaggeredView.setLayoutManager(gridLayoutManager);

        getStaggeredList();

        StaggereGridViewAdapter staggereGridViewAdapter = new StaggereGridViewAdapter(this, staggeredGridList);
        rvStaggeredView.setAdapter(staggereGridViewAdapter);


        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(staggereGridViewAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rvStaggeredView);
    }

    private void getStaggeredList() {
        staggeredGridList.add(new StaggeredGridModel("Alkane", R.drawable.potraitimage1));
        staggeredGridList.add(new StaggeredGridModel("Ethane", R.drawable.sunset));
        staggeredGridList.add(new StaggeredGridModel("Alkyne", R.drawable.potraitimage1));
        staggeredGridList.add(new StaggeredGridModel("Benzene", R.drawable.winter));
        staggeredGridList.add(new StaggeredGridModel("Phenol", R.drawable.sunset));
        staggeredGridList.add(new StaggeredGridModel("Amino Acid", R.drawable.potraitimage1));
        staggeredGridList.add(new StaggeredGridModel("Amide", R.drawable.potraitimage1));
        staggeredGridList.add(new StaggeredGridModel("Carbonxylic", R.drawable.winter));
    }
}
