package hr.tvz.android.listacosic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView countryName, countryDetail;
    ImageView img;
    Button buttonWiki;

    Country selectedCountry;
    String data1, data2;
    int imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        countryName = findViewById(R.id.countryName);
        countryDetail = findViewById(R.id.countryDetail);
        buttonWiki = findViewById(R.id.buttonWiki);
        img = findViewById(R.id.myImageView);
        selectedCountry = getIntent().getParcelableExtra("CountryList");

        getData();
        setData();

        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("selectedCountry", selectedCountry);
                startActivity(intent);
            }
        });

        //Gumb na kojem je postavljen listener, vodi na wikipediju u slučaju klika
        buttonWiki.setOnClickListener(new View.OnClickListener() {
            String url = "https://hr.wikipedia.org/wiki/" + countryName.getText();
            public void onClick(View view) {
                Intent implicit = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(implicit);
            }
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        MojReciever mojReciever = new MojReciever();
        registerReceiver(mojReciever, intentFilter);
    }

    //Dohvaćanje podataka iz intenta
    private void getData(){
        if(getIntent().hasExtra("CountryList")){
            Country country = getIntent().getParcelableExtra("CountryList");
            data1 = country.getName();
            data2 = country.getDetails();
            imageId = country.getImageResource();
            Log.d("ImageId: ", String.valueOf(imageId));
        }else if(getIntent().hasExtra("selectedCountry")){
            Country country = getIntent().getParcelableExtra("selectedCountry");
            data1 = country.getName();
            data2 = country.getDetails();
            imageId = country.getImageResource();
            Log.d("ImageId: ", String.valueOf(imageId));
        }
        else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    //Postavljanje podataka u view-ove
    private void setData(){
        countryName.setText(data1);
        countryDetail.setText(data2);
        img.setImageResource(imageId);
    }
}