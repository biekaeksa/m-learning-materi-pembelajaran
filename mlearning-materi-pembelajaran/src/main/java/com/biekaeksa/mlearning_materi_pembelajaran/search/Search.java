package com.biekaeksa.mlearning_materi_pembelajaran.search;

import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class Search<T> implements Filterable {
    private List<T> originalList;
    private List<T> filteredList;

    public Search(List<T> originalList, List<T> filteredList) {
        this.originalList = originalList;
        this.filteredList = filteredList;
    }

    public Search() {
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    filteredList = originalList;
                }else {
                    ArrayList<T> filterList = new ArrayList<>();
                    for (T t : originalList){
                        if (((String)t).toLowerCase().contains(charString) ||
                                ((String)t).toUpperCase().contains(charString)||
                                ((String)t).contains(charString)){
                            filterList.add(t);
                        }
                    }
                    filteredList = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<T>)results.values;
            }
        };
    }

    public List<T> getFilteredList(){
        return filteredList;
    }
}
