package vn.daikon.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import vn.daikon.myapplication.R;
import vn.daikon.myapplication.model.Product;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Product> list;
    public ListViewAdapter(List list){
        this.list = (ArrayList) list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.listview_product, null);
        } else viewProduct = convertView;
        Product product = (Product) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.tv_1)).setText(product.name);
        ((TextView) viewProduct.findViewById(R.id.tv_2)).setText(product.age);
        return viewProduct;
    }
}
