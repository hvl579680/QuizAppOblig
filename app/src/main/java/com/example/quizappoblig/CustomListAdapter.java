package com.example.quizappoblig;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<CatObject> {

    public CustomListAdapter (Context context, ArrayList<CatObject> catObject) {
        super(context, 0, catObject);
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }

        CatObject catObject = getItem(position);

        TextView catName = (TextView) view.findViewById(R.id.catName);
        ImageView catPic = (ImageView) view.findViewById(R.id.list_image);
        catPic.setTag(position);

        catName.setText(catObject.getCatName());
        catPic.setImageResource(catObject.getImageName());

        return view;






/*        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_row, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.catName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imageid[position]);
        return rowView;*/
    }
}
