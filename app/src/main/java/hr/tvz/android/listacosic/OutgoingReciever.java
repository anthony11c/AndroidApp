package hr.tvz.android.listacosic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OutgoingReciever extends BroadcastReceiver {

    public static final String CUSTOM_INTENT = "com.tvz.android.intent.action.TEST";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("*****Broadcast poslan!****************");
        Intent i = new Intent();
        i.setAction(CUSTOM_INTENT);
        context.sendBroadcast(i);
    }
}
