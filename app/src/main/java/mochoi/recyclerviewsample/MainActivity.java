package mochoi.recyclerviewsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mochoi.recyclerviewsample.databinding.ActivityMainBinding;
import mochoi.recyclerviewsample.databinding.ListItemBinding;

public class MainActivity extends AppCompatActivity {
    List<Item> items;
    RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =  DataBindingUtil.setContentView(this, R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new Item("Item1","memooooo"));
        items.add(new Item("Item2","AAAA"));
        items.add(new Item("Item3",""));
        items.add(new Item("Item4","NNNN"));
        items.add(new Item("Item5",""));

        SampleViewModel vm = new SampleViewModel();
//        vm.items = items;
        binding.setVm(vm);

        adapter = new RecyclerAdapter(items);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);

    }

    public void onClickBtn(View v){
        items = new ArrayList<>();
        items.add(new Item("ああああ","memooooo"));
        items.add(new Item("ああああいいいい","AAAA"));
        items.add(new Item("ううううう","NNNN"));
        adapter.replaceData(items);
    }


}
