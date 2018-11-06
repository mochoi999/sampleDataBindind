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

        adapter = new RecyclerAdapter(items);
//        RecyclerView recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);

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

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        private List<Item> items;

        public RecyclerAdapter(List<Item> items) {
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // DataBinding
            ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Item item = items.get(position);

            // データセット
            holder.binding.setItem(item);

            // Viewへの反映を即座に行う
            holder.binding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public void replaceData(List<Item> items) {
            setList(items);
        }
        private void setList(List<Item> items) {
            this.items = items;
            notifyDataSetChanged();
        }

         class ViewHolder extends RecyclerView.ViewHolder {

            final ListItemBinding binding;

            public ViewHolder(ListItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

    }
}
