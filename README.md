# BandList_RecyclerViewExample


RecyclerView Android

# 1.	Crear un proyecto

# 2.	Adiciónar las dependencias al gradle

`dependencies {
    implementation 'com.android.support:recyclerview-v7:28.0.0'
}`

# 3.	Adicionar el recycler view al layout 

`<android.support.v7.widget.RecyclerView
    android:id="@+id/bandsRecyclerView"
    android:scrollbars="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>`

# 4.	Obtener el objeto RecyclerView en el controlador del layout
private RecyclerView bandsRecyclerView;

`
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    bandsRecyclerView = findViewById(R.id.bandsRecyclerView);
}
`

# 5.	Crear un atributo de tipo RecyclerView.Adapter

`
private RecyclerView.Adapter myBandAdapter;
`

# 6.	Crear un atributo de tipo RecyclerView.LayoutManager

`
private RecyclerView.LayoutManager layoutManager;
`

# 7.	Inicializar en el onCreate el LayoutManager y asignárselo al recyclerview

`
layoutManager = new LinearLayoutManager(this);
bandsRecyclerView.setLayoutManager(layoutManager);
`
