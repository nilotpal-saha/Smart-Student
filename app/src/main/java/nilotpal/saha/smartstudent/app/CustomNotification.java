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

public class CustomNotification extends ArrayAdapter<String>{

    private String[] ids;
    private String[] sub;
    private String[] about;
    private String[] time;
    private Activity context;

    public CustomNotification(Activity context, String[] ids, String[] sub, String[] about, String[] time) {
        super(context, R.layout.custom_listview, ids);
        this.context = context;
        this.ids = ids;
        this.sub = sub;
        this.about = about;
        this.time = time;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.custom_listview, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.txtId);
        TextView textViewSub = (TextView) listViewItem.findViewById(R.id.txtSub);
        TextView textViewAbout = (TextView) listViewItem.findViewById(R.id.txtAbout);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.txtTime);

        textViewId.setText(ids[position] + ")");
        textViewSub.setText(sub[position]);
        textViewAbout.setText(about[position]);
        textViewTime.setText(time[position]);

        return listViewItem;
    }
}
