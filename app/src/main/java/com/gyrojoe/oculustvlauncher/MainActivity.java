package com.gyrojoe.oculustvlauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String targetPackage = this.getString(R.string.target_package);

        Intent targetIntent;
        PackageManager pm = this.getPackageManager();
        targetIntent = pm.getLaunchIntentForPackage(targetPackage);
        if (targetIntent == null)
        {
            targetIntent = pm.getLeanbackLaunchIntentForPackage(targetPackage);
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setComponent(new ComponentName("com.oculus.vrshell", "com.oculus.vrshell.MainActivity"));
        intent.setData(Uri.parse("com.oculus.tv"));
        intent.putExtra("uri", targetIntent.getComponent().flattenToString());

        this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.finish();
    }
}
