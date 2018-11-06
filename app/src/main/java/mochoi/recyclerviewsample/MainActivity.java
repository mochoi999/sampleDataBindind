package mochoi.recyclerviewsample;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import mochoi.recyclerviewsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    List<Item> items;
    RecyclerAdapter adapter;
    SampleViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =  DataBindingUtil.setContentView(this, R.layout.activity_main);

        vm = new SampleViewModel();
        vm.setListData();
        binding.setVm(vm);

        adapter = new RecyclerAdapter(items);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);

    }

    public void onClickBtn(View v){
        vm.setListXXXData();
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Item> items) {
        RecyclerAdapter adapter = (RecyclerAdapter)     recyclerView.getAdapter();
        if (adapter != null)
        {
            adapter.replaceData(items);
        } else {
            adapter = new RecyclerAdapter(items);
            recyclerView.setAdapter(adapter);
        }
    }

}
