package com.example.kali.just_testing;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kali on 10/10/17.
 */

public class WordAdapter extends ArrayAdapter<Word>{
    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemview = convertView;
        if(listitemview == null){
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.listview, parent, false);
        }
        Word pos = getItem(position);
        TextView nameTextView = (TextView) listitemview.findViewById(R.id.firstword);
        nameTextView.setText(pos.getAlarmName());
        TextView noTextView = (TextView) listitemview.findViewById(R.id.secondword);
        noTextView.setText(pos.getAlarmNo() );

        return listitemview;
    }
}
