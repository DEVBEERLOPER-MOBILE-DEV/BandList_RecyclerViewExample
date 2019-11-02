# BandList_RecyclerViewExample

RecyclerView Android

## 1.	Crear un proyecto

## 2.	Adiciónar las dependencias al gradle

`dependencies {
    implementation 'com.android.support:recyclerview-v7:28.0.0'
}`

## 3.	Adicionar el recycler view al layout del activity en donde se incluira el recycler view

`<android.support.v7.widget.RecyclerView
    android:id="@+id/bandsRecyclerView"
    android:scrollbars="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>`

## 4.	Obtener el objeto RecyclerView en el activity que controla el layout 

` 
private RecyclerView bandsRecyclerView;


@Override

protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_main);
    
    bandsRecyclerView = findViewById(R.id.bandsRecyclerView);
}
`

## 5.	Crear un atributo de tipo RecyclerView.Adapter

`
private RecyclerView.Adapter myBandAdapter;

`

## 6.	Crear un atributo de tipo RecyclerView.LayoutManager

`
private RecyclerView.LayoutManager layoutManager;

`

## 7.	Inicializar en el onCreate el LayoutManager y asignárselo al recyclerview

`
layoutManager = new LinearLayoutManager(this);

bandsRecyclerView.setLayoutManager(layoutManager);

`

## 8.	Crear una clase modelo con sus atributos, getters y setters y sus contructores

`
package model;

public class Band {

    private String bandName;
    private String bandGenre;
    private String bandDescription;
    private int bandMusicNumber;

    public Band() {
    }

    public Band(String bandName, String bandGenre, String bandDescription, int bandMusicNumber) {
        this.bandName = bandName;
        this.bandGenre = bandGenre;
        this.bandDescription = bandDescription;
        this.bandMusicNumber = bandMusicNumber;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBandGenre() {
        return bandGenre;
    }

    public void setBandGenre(String bandGenre) {
        this.bandGenre = bandGenre;
    }

    public String getBandDescription() {
        return bandDescription;
    }

    public void setBandDescription(String bandDescription) {
        this.bandDescription = bandDescription;
    }

    public int getBandMusicNumber() {
        return bandMusicNumber;
    }

    public void setBandMusicNumber(int bandMusicNumber) {
        this.bandMusicNumber = bandMusicNumber;
    }
}

`

## 9.	Crear un nuevo layout con los campos TextView para publicar la información del modelo. Use los views que requiera según su diseño


`
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <TextView
        android:id="@+id/bandName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        />
    <TextView
        android:id="@+id/bandGenre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        />
    <TextView
        android:id="@+id/bandDescription"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        />
    <TextView
        android:id="@+id/bandMusiciansNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        />

</LinearLayout>

`

## 10. Crear una clase que hereda de ViewHolder que contenga los mismos atributos del layout creado anteriormente, creele un constructor que reviba un parametro de tipo View y haga el mapeo de ese view a los atributos de la clase.

`

package co.devbeerloper.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 *Holder of the view
 */
public class BandViewHolder extends RecyclerView.ViewHolder  {

    public TextView name;
    public TextView description;
    public TextView genre;
    public TextView musiciansNumber;

    public BandViewHolder(View bandView) {
        super(bandView);
        
        this.name = (TextView) bandView.findViewById(R.id.bandName);;
        this.description = (TextView) bandView.findViewById(R.id.bandDescription);
        this.genre = (TextView) bandView.findViewById(R.id.bandGenre);
        this.musiciansNumber = (TextView) bandView.findViewById(R.id.bandMusiciansNumber);
    }
}

`

## 11.Crear una clase adaptador que herede de RecyclerView.Adapter parametrizada con objetos del tipo del ViewHolder creado anteriormente. 
### 11.1 En esta clase crear un atributo de tipo lista de los objetos del modelo. Crear un constructor que reciba un parametro y con este llene el atributo creado.
### 11.2 Implemente los metodos onCreateViewHolder, onBindViewHolder y getItemCount del padre. 
### 11.3 En el metodo onCreateViewHolder obtener el contexto del viewGroup entrante como parámetro, obtener el Inflater para llenar el view, usar el inflater con el layout creado y obtener el view creado, crer un nuevo objeto del viewHolder creado, y enviarle como parametro el view creado con el inflater. Retornar el objeto viewholder creado.
### 11.4 En el metodo onBindViewHolder obtener el objeto de la lista con el indice que ingresac mo parámetro al metodo. Obtener uno a uno los views del viewholder y llenarlos con la información del objeto de la posicion obtenida.
### 11.5 En el metodo getItemCount retornar el tamaño de la lista que se tiene como atributo.

`

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

`

## 12. En la actividad que muestra la lista, se debe crear un metodo que invoque la lectura de los datos a mostrar y los almacene en un atributo, posteriormente se debe crear un objeto del tipo de adaptador que se creo anteriormente y enviarle la información leida. Al RecyclerView adicionarle el objeto adaptador creado. 
