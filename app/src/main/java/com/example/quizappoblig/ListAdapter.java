package com.example.quizappoblig;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    private final String[] catRace;
    private final int[] images;

    public ListAdapter(Context context, String[] catRace, int[] images) {
        // super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.catRace = catRace;
        this.images = images;
    }

    @Override
    public int getCount() {
        return catRace.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder.catRace = (TextView) convertView.findViewById(R.id.catRace);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.catRace.setText(catRace[position]);
        viewHolder.icon.setImageResource(images[position]);

        return convertView;
    }

    private static class ViewHolder {
        TextView catRace;
        ImageView icon;
    }
}
