package co.devbeerloper.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Band;

public class MyBandAdapter extends RecyclerView.Adapter <BandViewHolder>{

    private ArrayList<Band> bandsList;

    /**
     * Constructor of the adapter class
     * @param bandsList
     */
    public MyBandAdapter(ArrayList<Band> bandsList) {
        this.bandsList = bandsList;
    }


    @NonNull
    @Override
    public BandViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.band_custom_layout, viewGroup, false);

        BandViewHolder bandViewHolder = new BandViewHolder(contactView);

        return bandViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BandViewHolder viewHolder, int i) {

        Band bandTmp = bandsList.get(i);

        TextView nameTv = viewHolder.name;
        nameTv.setText(bandTmp.getBandName());

        TextView descriptionTv = viewHolder.description;
        descriptionTv.setText(bandTmp.getBandDescription());

        TextView genreTv = viewHolder.genre;
        genreTv.setText(bandTmp.getBandGenre());

        TextView musiciansNumberTv = viewHolder.musiciansNumber;
        musiciansNumberTv.setText(bandTmp.getBandMusicNumber()+"");

    }

    @Override
    public int getItemCount() {
        return bandsList.size();
    }
}
