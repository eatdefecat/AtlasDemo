package com.android.dzatlas;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.middlewarelibrary.BaseActivity;
import com.android.middlewarelibrary.NetUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 加载远程bundle，LoadingBundle打包的时候不编译进apk中
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(v.getContext(), "com.android.loadingbundle.LoadingActivity");
                startActivity(intent);
            }
        });

        // 插件更新
        findViewById(R.id.click2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        Updater.update(getBaseContext());
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                }.execute();
            }
        });

        // 加载homebundle已编译在apk中
        findViewById(R.id.click3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(v.getContext(), "com.android.homebundle.HomeActivity");
                startActivity(intent);
            }
        });

        Toast.makeText(this, NetUtils.getCode(), Toast.LENGTH_LONG).show();
    }
}
