package co.devbeerloper.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import model.Band;
import providers.ReadInformation;

public class MainActivity extends AppCompatActivity {

    private RecyclerView bandsRecyclerView;
    private RecyclerView.Adapter myBandAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Band> bandsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bandsRecyclerView= findViewById(R.id.bandsRecyclerView);

        //READ BANDS LIST
        fillDataSetOfBands ();

        layoutManager = new LinearLayoutManager(this);
        bandsRecyclerView.setLayoutManager(layoutManager);


        myBandAdapter = new MyBandAdapter(bandsList);
        bandsRecyclerView.setAdapter(myBandAdapter);

    }


    public void fillDataSetOfBands () {

        ReadInformation readerOfInfo = new ReadInformation();
        bandsList = readerOfInfo.getAllBandsInTown ();
    }


}
