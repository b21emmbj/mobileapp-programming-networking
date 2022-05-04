
# Rapport



För att hämta data från webtjänsten så krävs koden som finns i figur 1. 
Här parsas JSON_URL till en gson-lista och definieras till variabeln "emma" som är en array bestående av Mountain.    
Figur 1 Kod
```
private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
private List<Mountain> listOfMountain;
    protected void onCreate(Bundle savedInstanceState) {
        ...
        new JsonTask(this).execute(JSON_URL);
        ...
   public void onPostExecute(String json) {

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Mountain>>() {}.getType();
        ArrayList<Mountain> emma = gson.fromJson(json, type);
        listOfMountain.addAll(emma);
        adapter.notifyDataSetChanged();
```


I denna kod som finns i figur 2 så sätts kopplingen mellan recyclerView och datan (som kommer från webtjänsten) med en adapter.  
Figur 2 Kod
```
 protected void onCreate(Bundle savedInstanceState) {
        recyclerView = findViewById(R.id.my_recycler);
        listOfMountain = new ArrayList<Mountain>();
        adapter = new Myadapter(listOfMountain);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
```

I figur 3 presenteras kod som jag har i 
Figur 3 Kod
```
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.name.setText(mountains.get(position).getName());
        holder.location.setText(mountains.get(position).getLocation());
        holder.size.setText(String.valueOf(mountains.get(position).getSize()));
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }
```



![](Screenshot.png)


