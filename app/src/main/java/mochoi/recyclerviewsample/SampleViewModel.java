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

public class SampleViewModel {//extends BaseObservable {

    public final ObservableField<List<Item>> items = new ObservableField<>();
//    public List<Item> items = new ArrayList<>();

    public void setItems(List<Item> items){
        this.items.set(items);
    }

    @BindingAdapter("app:items")
    public static void setItems(RecyclerView listView, List<Item> items) {
        RecyclerAdapter adapter = (RecyclerAdapter)     listView.getAdapter();
        if (adapter != null)
        {
            Log.d("TEST","replaceData(items)@@@@@@@@@@");
//            for (Item i:
//                    items) {
//                Log.d("TEST","---"+i.name);
//            }

            adapter.replaceData(items);
        } else {
            Log.d("TEST","NULL@@@@@@@@@@");
            adapter = new RecyclerAdapter(items);
            listView.setAdapter(adapter);
        }
    }
}
