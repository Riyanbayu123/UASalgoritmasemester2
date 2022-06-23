package model;

import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class JSonAPI {
    public static void main(String[] args) throws IOException {
        String _author;
        String _category;
        String _changelog;
        String _contentRating;
        String _datePublished;
        int _datePublishedIso;
        String _description;
        String _shortDescription;
        String _fileSize;
        String _icon;
        Boolean _inAppBiling;
        String _name;
        int _numDownloads;
        String _operatingSystem;

        ArrayList<GooglePlay> _googleplay= new ArrayList<>();
        try{
            GooglePlay s = new GooglePlay();

            s.getAuthor();
            s.getCategory();
            s.getChangelog();
            s.getContentRating();
            s.getDatePublished();
            s.getDatePublishedIso();
            s.getDescription();
            s.getShortDescription();
            s.getFileSize();
            s.getIcon();
            s.getInAppBiling();
            s.getName();
            s.getNumDownloads();
            s.getOperatingSystem();
            _googleplay.add(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int j =0;j<_googleplay.size();j++){
            System.out.println(_googleplay.get(j).getAuthor()+""+_googleplay.get(j).getCategory()+""+_googleplay.get(j).getChangelog()+""
                    +_googleplay.get(j).getContentRating()+""+_googleplay.get(j).getDatePublished()+""+_googleplay.get(j).getDatePublishedIso()+""+
                    _googleplay.get(j).getDescription()+""+_googleplay.get(j).getFileSize()+""+_googleplay.get(j).getIcon()+""+_googleplay.get(j).getInAppBiling()+""
                    +_googleplay.get(j).getName()+""+_googleplay.get(j).getNumDownloads()+""+_googleplay.get(j).getOperatingSystem());
        }
        JSONArray jsongoogleplay = new JSONArray();
        JSONObject myJObject = new JSONObject();
        myJObject.put("author",_googleplay.get(0).getAuthor());
        myJObject.put("category", _googleplay.get(0).getCategory());
        myJObject.put("address", _googleplay.get(0).getChangelog());
        myJObject.put("phone", _googleplay.get(0).getContentRating());
        jsongoogleplay.put(myJObject);



        System.out.println(jsongoogleplay.toString());

        //Send Students data to database Cloud
        ConnectURI myUriBuilder = new ConnectURI();
        URL myAddress = myUriBuilder.buildurl("#");
        myUriBuilder.postJson(myAddress,jsongoogleplay.toString());

    }
}

