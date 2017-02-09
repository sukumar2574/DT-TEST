package com.example.sukumar.dttest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sukumar.dttest.R;
import com.example.sukumar.dttest.activity.DetailsActivity;
import com.example.sukumar.dttest.model.XMLDataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sukumar on 2/9/2017.
 */

public class DataAdapter<T extends XMLDataModel> extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<T> applications;
    private String PRODUCTNAME = "PRODUCT_NAME";
    private String CATEGORYNAME = "CATEGORY_NAME";
    private String NUMRATINGS = "NUMBER_RATINGS";
    private String RATING = "RATING";
    private String MINVERSION = "MIN_OS_VERSION";
    private String DESCRIPTION = "PRODUCT_DESCRIPTION";


    public DataAdapter(Context context, int resource, List<T> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Log.d(TAG, "getView: called with null convertView");
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Log.d(TAG, "getView: provided a convertView");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final XMLDataModel currentApp = applications.get(position);

        viewHolder.productName.setText(currentApp.getProductName());
        Picasso.with(getContext()).load(currentApp.getThumbNailURL()).into(viewHolder.thumbNail);
        Picasso.with(getContext()).load(currentApp.getRatingImageURL()).into(viewHolder.ratingImg);
        viewHolder.adView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra(PRODUCTNAME, currentApp.getProductName());
                intent.putExtra(CATEGORYNAME, currentApp.getCategoryName());
                intent.putExtra(MINVERSION, currentApp.getMinOSVersion());
                intent.putExtra(RATING, currentApp.getRating());
                intent.putExtra(DESCRIPTION, currentApp.getDescription());
                intent.putExtra(NUMRATINGS, currentApp.getNumOfRatings());
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView productName;
        ImageView thumbNail, ratingImg;
        RelativeLayout adView;

        ViewHolder(View v) {
            productName = (TextView) v.findViewById(R.id.product_name);
            thumbNail = (ImageView) v.findViewById(R.id.thumb_nail);
            ratingImg = (ImageView) v.findViewById(R.id.rating_img);
            adView = (RelativeLayout) v.findViewById(R.id.ad_view);


        }
    }
}
