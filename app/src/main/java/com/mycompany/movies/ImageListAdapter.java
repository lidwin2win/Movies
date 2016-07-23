package com.mycompany.movies;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lidwin on 18/7/16.
 */public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] imageUrls;
    private String[] words;
    private String[] words2;

   // ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();


    public ImageListAdapter(Context context,String[] titles, String[] posters) {
        super(context, R.layout.list_view,titles);

        this.context = context;
        this.imageUrls = posters;
        this.words =titles;
        //this.words2 = words2;

        inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_view, parent, false);
        }
        // LayoutInflater inflater = context.getLayoutInflater();
        // View rowView= inflater.inflate(R.layout.listview_item_image, null, true);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txt);
        ImageView image = (ImageView)convertView.findViewById(R.id.img) ;
        //TextView txtTitle2 = (TextView) convertView.findViewById(R.id.txt2);




        Glide
                .with(context)
                .load(imageUrls[position])
                .into(image);


        txtTitle.setText(words[position]);
       // txtTitle2.setText(words2[position]);



        return convertView;

    }
}