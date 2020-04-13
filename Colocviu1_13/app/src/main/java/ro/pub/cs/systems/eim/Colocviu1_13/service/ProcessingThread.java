package ro.pub.cs.systems.eim.Colocviu1_13.service;

import android.content.Context;
import android.content.Intent;

import java.sql.Date;

import ro.pub.cs.systems.eim.Colocviu1_13.general.Constants;

public class ProcessingThread extends Thread {
    private Context context = null;
    private String history;

    public ProcessingThread(Context context, String history) {
        this.context = context;
        this.history = history;
    }

    @Override
    public void run() {
            sleep();
            sendMessage();
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.SERVICE_ACTION);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                new Date(System.currentTimeMillis()) + " " + history);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
