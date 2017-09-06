package nilotpal.saha.smartstudent.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJSONevent {

    public static String[] ids;
    public static String[] sub;
    public static String[] about;
    public static String[] time;

    public static final String JSON_ARRAY = "event";
    public static final String KEY_ID ="id";
    public static final String KEY_SUB = "event";
    public static final String KEY_ABOUT = "about";
    public static final String KEY_TIME = "time";

    private JSONArray users = null;

    private String json;

    public ParseJSONevent(String json){
        this.json = json;
    }

    public void parseJSONevent(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            sub = new String[users.length()];
            about = new String[users.length()];
            time = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                sub[i] = jo.getString(KEY_SUB);
                about[i] = jo.getString(KEY_ABOUT);
                time[i] = jo.getString(KEY_TIME);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
