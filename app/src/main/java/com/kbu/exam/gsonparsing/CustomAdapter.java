package com.kbu.exam.gsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Users> {
    Context context;
    ArrayList<Users> users;

    public CustomAdapter(@NonNull Context context, ArrayList<Users> users) {
        super(context, R.layout.item, users);
        this.context = context;
        this.users = users;
    }


    @Override
    public Users getItem(int i) {
        return users.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, viewGroup, false);
        }
        holder.imageView = (ImageView) view.findViewById(R.id.item1);
        holder.idView = (TextView) view.findViewById(R.id.item2);
        holder.nameView = (TextView) view.findViewById(R.id.item3);
        holder.emailView = (TextView) view.findViewById(R.id.item4);
        ImageThread thread = new ImageThread(context, users.get(i).getImageUrl());
        thread.start();
        try {
            thread.join();
            holder.imageView.setImageBitmap(thread.getBitmap());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        holder.idView.setText(users.get(i).id);
        holder.nameView.setText(users.get(i).name);
        holder.emailView.setText(users.get(i).email);
        return view;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView idView;
        TextView nameView;
        TextView emailView;
    }
}
