package nilotpal.saha.smartstudent.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJSONforum {

    public static String[] ids;
    public static String[] query;
    public static String[] answer;

    public static final String JSON_ARRAY = "forum";
    public static final String KEY_ID ="id";
    public static final String KEY_QUERY = "query";
    public static final String KEY_ANS = "answer";

    private JSONArray users = null;

    private String json;

    public ParseJSONforum(String json){
        this.json = json;
    }

    public void parseJSONforum(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            query = new String[users.length()];
            answer = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                query[i] = jo.getString(KEY_QUERY);
                answer[i] = jo.getString(KEY_ANS);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
