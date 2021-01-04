package com.Dsi32g6.Covid19Application.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;
import com.Dsi32g6.Covid19Application.R;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private final Context context;
    private final List<AppItem> items;

    public ItemAdapter(Context context, List<AppItem> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.article, null);
        TextView tvName = (TextView) v.findViewById(R.id.tv_itemname);
        TextView tvPrenom = (TextView) v.findViewById(R.id.tv_itemprenom);
        TextView tvCin = (TextView) v.findViewById(R.id.tv_itemcin);
        TextView etat = (TextView) v.findViewById(R.id.etat);

        TextView tvprice = (TextView) v.findViewById(R.id.tv_itemprice);

        tvCin.setText(items.get(position).getCin());
        tvName.setText(items.get(position).getName());
        tvPrenom.setText(items.get(position).getPrenom());
        etat.setText(items.get(position).getEtat());
        tvprice.setText("Date de Test : "+items.get(position).getMin_price());
        int id = context.getResources().getIdentifier( items.get(position).getPhoto(), "drawable", context.getPackageName());
        System.err.println("PHOTO ID : "+ id);






        return v;
    }
}
