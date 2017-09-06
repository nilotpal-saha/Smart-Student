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

public class EventCustomNotification extends ArrayAdapter<String>{

    private String[] ids;
    private String[] event;
    private String[] about;
    private String[] time;
    private Activity context;

    public EventCustomNotification(Activity context, String[] ids, String[] event, String[] about, String[] time) {
        super(context, R.layout.event_custom_listview, ids);
        this.context = context;
        this.ids = ids;
        this.event = event;
        this.about = about;
        this.time = time;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.event_custom_listview, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.txtEventId);
        TextView textViewEvent = (TextView) listViewItem.findViewById(R.id.txtEventName);
        TextView textViewAbout = (TextView) listViewItem.findViewById(R.id.txtEventAbout);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.txtEventTime);

        textViewId.setText(ids[position] + ")");
        textViewEvent.setText(event[position]);
        textViewAbout.setText(about[position]);
        textViewTime.setText(time[position]);

        return listViewItem;
    }
}
