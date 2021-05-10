package hr.tvz.android.listacosic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countryList;
    RecyclerView recyclerView;
    String[] countriesArray;
    String[] detailsArray;
    int[] images = {R.drawable.croatia, R.drawable.slovenia, R.drawable.italy, R.drawable.serbia, R.drawable.montenegro,
            R.drawable.albania, R.drawable.greece, R.drawable.bosnia, R.drawable.austria, R.drawable.hungary};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        countriesArray = getResources().getStringArray(R.array.countries);
        detailsArray = getResources().getStringArray(R.array.details);

        populateCountryList(countriesArray, detailsArray, images);

        MyAdapter myAdapter = new MyAdapter(this, countryList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Options menu gore desno u activity-u
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.broadcast_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                openDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog(){
        BroadcastDialog broadcastDialog = new BroadcastDialog(this, new Intent());
        broadcastDialog.show(getSupportFragmentManager(), "Broadcast dialog");
    }
    
    private List<Country> populateCountryList(String[] countriesArray, String[] detailsArray, int[] images){
        countryList = new ArrayList<>();
        final int lenght = countriesArray.length;
        for(int i= 0; i < lenght; i++){
            countryList.add(new Country(countriesArray[i], detailsArray[i], images[i]));
            Log.d("INFO", "populateCountryList: ");
            Log.d("INFO", countryList.get(i).getName());
        }

        return countryList;
    }
}