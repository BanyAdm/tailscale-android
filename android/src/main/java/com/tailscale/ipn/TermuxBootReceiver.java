package com.tailscale.ipn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.util.Log;

public class TermuxBootReceiver extends BroadcastReceiver {

    private static final String TAG = "TS:TermuxBoot";

    @Override
    public void onReceive(Context ctx, Intent intent) {
        Log.i(TAG, "Boot received: " + intent.getAction());
        App app = App.get();
        if (VpnService.prepare(ctx) != null) {
            Log.i(TAG, "VPN permission not granted, skipping auto-reconnect");
            return;
        }
        app.startVPN();
    }
}
