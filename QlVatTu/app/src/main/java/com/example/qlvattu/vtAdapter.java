package com.example.qlvattu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class vtAdapter extends ArrayAdapter<vatTu> {
    private Context context;
    private int resource;
    private List<vatTu> listVt;

    public vtAdapter(Context context, int resource, List<vatTu> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listVt = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.itemlist, parent, false);
            viewHodel = new ViewHodel();
            viewHodel.tv_id = (TextView)convertView.findViewById(R.id.tv_maVt);
            viewHodel.tv_ten = (TextView)convertView.findViewById(R.id.tv_tenVt);
            viewHodel.tv_unit = (TextView)convertView.findViewById(R.id.tv_Unit);
            viewHodel.tv_gia = (TextView)convertView.findViewById(R.id.tv_Price);
            viewHodel.tv_manu = (TextView)convertView.findViewById(R.id.tv_manu);

            convertView.setTag(viewHodel);
        } else {
            viewHodel = (ViewHodel) convertView.getTag();
        }
        vatTu sinhVien = listVt.get(position);
        viewHodel.tv_id.setText(String.valueOf(sinhVien.getId()));
        viewHodel.tv_ten.setText(sinhVien.getName());
        viewHodel.tv_unit.setText(sinhVien.getUnit());
        viewHodel.tv_gia.setText(sinhVien.getPrice());
        viewHodel.tv_manu.setText(sinhVien.getManu());

        return convertView;
    }

    class ViewHodel {
        // khai bao cac View o trong items_list_sv
        private TextView tv_id, tv_ten, tv_unit, tv_gia, tv_manu;

    }
}
