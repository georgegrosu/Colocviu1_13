package ro.pub.cs.systems.eim.Colocviu1_13.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import ro.pub.cs.systems.eim.Colocviu1_13.general.Constants;

public class Colocviu1_13Service extends Service {
    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String history = intent.getStringExtra(Constants.HISTORY);
        processingThread = new ProcessingThread(this, history);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
