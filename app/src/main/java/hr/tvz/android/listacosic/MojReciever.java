package hr.tvz.android.listacosic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MojReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Action: " + intent.getAction(), Toast.LENGTH_LONG).show();
    }
}
