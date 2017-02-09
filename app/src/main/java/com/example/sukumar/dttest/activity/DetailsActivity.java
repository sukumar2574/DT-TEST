package com.example.sukumar.dttest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sukumar.dttest.R;

/**
 * Created by Sukumar on 2/9/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    String PRODUCTNAME = "PRODUCT_NAME";
    String CATEGORYNAME = "CATEGORY_NAME";
    String NUMRATINGS = "NUMBER_RATINGS";
    String RATING = "RATING";
    String MINVERSION = "MIN_OS_VERSION";
    String DESCRIPTION = "PRODUCT_DESCRIPTION";

    TextView productName, rating, numRating, productDescription, productCategory, minVersion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_screen);
        Bundle extras = getIntent().getExtras();
        productName = (TextView) findViewById(R.id.product_name);
        rating = (TextView) findViewById(R.id.product_rating);
        numRating = (TextView) findViewById(R.id.product_number_ratings);
        productDescription = (TextView) findViewById(R.id.product_description);
        productCategory = (TextView) findViewById(R.id.product_category);
        minVersion = (TextView) findViewById(R.id.min_version);

        productName.setText(extras.get(PRODUCTNAME).toString());
        rating.setText(extras.get(RATING).toString());
        numRating.setText(extras.get(NUMRATINGS).toString());
        productDescription.setText(extras.get(DESCRIPTION).toString());
        productCategory.setText(extras.get(CATEGORYNAME).toString());
        if (extras.get(MINVERSION) != null) {
            minVersion.setText(extras.get(MINVERSION).toString());
        } else {
            minVersion.setText(R.string.not_available);
        }

    }
}
