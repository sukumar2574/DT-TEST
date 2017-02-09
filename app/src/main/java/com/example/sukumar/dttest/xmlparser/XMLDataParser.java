package com.example.sukumar.dttest.xmlparser;

import com.example.sukumar.dttest.model.XMLDataModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Sukumar on 2/9/2017.
 */

public class XMLDataParser {

    private ArrayList<XMLDataModel> applications;

    public XMLDataParser() {
        applications = new ArrayList<>();
    }

    public ArrayList<XMLDataModel> getApplications() {
        return applications;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        XMLDataModel ad = null;
        boolean inEntry = false;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlData));
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("ad")) {
                            inEntry = true;
                            ad = new XMLDataModel();
                        } else if (parser.getName().equals("averageRatingImageURL")) {
                            if (ad != null) {
                                ad.setRatingImageURL(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("minOSVersion")) {
                            if (ad != null) {
                                ad.setMinOSVersion(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("categoryName")) {
                            if (ad != null) {
                                ad.setCategoryName(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("numberOfRatings")) {
                            if (ad != null) {
                                ad.setNumOfRatings(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("rating")) {
                            if (ad != null) {
                                ad.setRating(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("productDescription")) {
                            if (ad != null) {
                                ad.setDescription(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("productThumbnail")) {
                            if (ad != null) {
                                ad.setThumbNailURL(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("productThumbnail")) {
                            if (ad != null) {
                                ad.setThumbNailURL(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("productName")) {
                            if (ad != null) {
                                ad.setProductName(parser.nextText().trim());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("ad")) {
                            applications.add(ad);
                            inEntry = false;
                        }
                        break;
                    default:
                        break;
                }
                event = parser.next();
            }
            return inEntry;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();

        }
        return status;
    }
}
