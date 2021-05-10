package hr.tvz.android.listacosic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {

    Country country;
    ImageView img;
    int imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        img = findViewById(R.id.countryPicture);
        country = getIntent().getParcelableExtra("selectedCountry");
        imageId = country.getImageResource();
        Log.d("Id fotke", String.valueOf(imageId));
        img.setImageResource(imageId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//        intent.putExtra("selectedCountry", country);
//        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//        intent.putExtra("selectedCountry", country);
//        startActivity(intent);
    }
}