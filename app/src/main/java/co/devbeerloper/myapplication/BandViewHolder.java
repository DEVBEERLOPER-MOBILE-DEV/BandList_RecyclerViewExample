package co.devbeerloper.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Holder of the view
 */
public class BandViewHolder extends RecyclerView.ViewHolder  {

    public TextView name;
    public TextView description;
    public TextView genre;
    public TextView musiciansNumber;


    public BandViewHolder(View bandView) {
        super(bandView);

        this.name = (TextView) itemView.findViewById(R.id.bandName);;
        this.description = (TextView) itemView.findViewById(R.id.bandDescription);
        this.genre = (TextView) itemView.findViewById(R.id.bandGenre);
        this.musiciansNumber = (TextView) itemView.findViewById(R.id.bandMusiciansNumber);
    }


}
