package hr.tvz.android.listacosic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class BroadcastDialog extends AppCompatDialogFragment {

    Context context;
    Intent intent;

    public BroadcastDialog(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Broadcast")
                .setMessage("Pošalji broadcast ili ne!")
                .setPositiveButton("Pošalji", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        OutgoingReciever outgoingReciever = new OutgoingReciever();
                        outgoingReciever.onReceive(context , intent);
                    }
                }).setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }
}
