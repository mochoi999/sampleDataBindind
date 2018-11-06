package mochoi.recyclerviewsample;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.icu.util.LocaleData;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SampleViewModel {

    public final ObservableField<List<Item>> items = new ObservableField<>();

    public void setListData(){
        //TODO model
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1","memooooo"));
        items.add(new Item("Item2","AAAA"));
        items.add(new Item("Item3",""));
        items.add(new Item("Item4","NNNN"));
        items.add(new Item("Item5",""));
        this.items.set(items);
    }

    public void setListXXXData(){
        //TODO model
        List<Item> items = new ArrayList<>();
        items.add(new Item("ああああ","memooooo"));
        items.add(new Item("ああああいいいい","AAAA"));
        items.add(new Item("ううううう","NNNN"));
        this.items.set(items);
    }
}
