package nilotpal.saha.smartstudent.app;

/**
 * Created by Nilotpal on 4/15/2017.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import nilotpal.saha.smartstudent.R;

public class ForumListView extends ArrayAdapter<String>{

    private String[] ids;
    private String[] query;
    private String[] answer;
    private Activity context;

    public ForumListView(Activity context, String[] ids, String[] query, String[] answer) {
        super(context, R.layout.forum_listview, ids);
        this.context = context;
        this.ids = ids;
        this.query = query;
        this.answer = answer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.forum_listview, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.txtForumId);
        TextView textViewquery = (TextView) listViewItem.findViewById(R.id.txtForumQuery);
        TextView textViewAns = (TextView) listViewItem.findViewById(R.id.txtForumAns);

        textViewId.setText(ids[position]+")");
        textViewquery.setText(query[position]);
        textViewAns.setText("Answer:"+answer[position]);

        return listViewItem;
    }
}
