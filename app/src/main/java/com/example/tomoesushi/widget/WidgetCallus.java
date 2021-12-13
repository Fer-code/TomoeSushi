package com.example.tomoesushi.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.example.tomoesushi.R;
import com.example.tomoesushi.activities.CadastroActivity;

public class WidgetCallus extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {

            Uri uri = Uri.parse("tel: 11 983676652");
            Intent it = new Intent(Intent.ACTION_DIAL, uri);
            PendingIntent pendingIntent= PendingIntent.getActivity(context, 0, it, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_call);
            views.setOnClickPendingIntent(R.id.call, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
