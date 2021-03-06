package com.infinite.coltoolbardemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertsimsek on 31/08/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RadioViewHolder> {

    private Context context;

    private List<Radio> radioList;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        radioList = new ArrayList<>();
    }

    public void setRadioList(List<Radio> radioList) {
        this.radioList = radioList;
        notifyDataSetChanged();
    }

    @Override
    public RadioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card, parent, false);
        RadioViewHolder viewHolder = new RadioViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RadioViewHolder holder, final int position) {

        Radio radio = radioList.get(position);
        holder.textViewRadioName.setText(radio.getRadioName());
        holder.textViewRadioDial.setText("(" + radio.getRadioDial() + ")");
        holder.imageViewRadioLogo.setImageResource(radio.getRadioArt());
        holder.textViewRadioTags.setText(holder.getLayoutPosition()+":这是内容.....");
    }

    @Override
    public int getItemCount() {
        return radioList.size();
    }

    public class RadioViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewRadioName;
        public TextView textViewRadioDial;
        public TextView textViewRadioTags;
        public ImageView imageViewRadioLogo;

        public RadioViewHolder(View itemView) {
            super(itemView);
            textViewRadioName = (TextView) itemView.findViewById(R.id.textview_radio_name);
            textViewRadioDial = (TextView) itemView.findViewById(R.id.textview_radio_dial);
            textViewRadioTags = (TextView) itemView.findViewById(R.id.textview_tags);
            imageViewRadioLogo = (ImageView) itemView.findViewById(R.id.imageview_radio_logo);
        }
    }

}
