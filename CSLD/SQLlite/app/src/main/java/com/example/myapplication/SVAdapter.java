package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SVAdapter extends ArrayAdapter<SinhVien> {

    private Context context;
    private int resource;
    private List<SinhVien> listSv;

    public SVAdapter(Context context, int resource, List<SinhVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSv = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHodel = new ViewHodel();
            viewHodel.tv_id = (TextView)convertView.findViewById(R.id.tvId);
            viewHodel.tv_hoten = (TextView)convertView.findViewById(R.id.tvName);
            viewHodel.tv_lop = (TextView)convertView.findViewById(R.id.tvnameClass);
            viewHodel.tv_diachi = (TextView)convertView.findViewById(R.id.tvAddress);
            viewHodel.tv_sdt = (TextView)convertView.findViewById(R.id.tvPhone);

            convertView.setTag(viewHodel);
        } else {
            viewHodel = (ViewHodel) convertView.getTag();
        }
        SinhVien sinhVien = listSv.get(position);
        viewHodel.tv_id.setText(String.valueOf(sinhVien.getId()));
        viewHodel.tv_hoten.setText(sinhVien.getHoten());
        viewHodel.tv_lop.setText(sinhVien.getLop());
        viewHodel.tv_sdt.setText(sinhVien.getSdt());
        viewHodel.tv_diachi.setText(sinhVien.getDiachi());

        return convertView;
    }

    class ViewHodel {
        // khai bao cac View o trong items_list_sv
        private TextView tv_id, tv_hoten, tv_lop, tv_diachi, tv_sdt;

    }
}
