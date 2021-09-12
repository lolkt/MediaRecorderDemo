package com.android.media;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.android.media.MediaRecorder.MainService;
import com.android.media.PreviewCallBack.MainService2;
import com.android.media.SurfaceRecord.MainService3;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_PERMISSIONS = 10;

    private static final String[] permissions = new String[]{
            Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListener();
        if (!EasyPermissions.hasPermissions(MainActivity.this, permissions)) {
            EasyPermissions.requestPermissions(MainActivity.this, "请求拍摄", 1, permissions);
            return;
        }
        PathUtils.getInstance().initPath(MainActivity.this);
    }


    private void initListener() {
        findViewById(R.id.tv_11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MainService.isrun) {
                    Intent intent = new Intent(MainActivity.this, MainService.class);
                    startService(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainService.getInstance().showWindow(1);
                    }
                }, 2000);

            }
        });

        findViewById(R.id.tv_12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MainService2.isrun) {
                    Intent intent = new Intent(MainActivity.this, MainService2.class);
                    startService(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainService2.getInstance().showWindow(1);
                    }
                }, 2000);

            }
        });
        findViewById(R.id.tv_13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MainService3.isrun) {
                    Intent intent = new Intent(MainActivity.this, MainService3.class);
                    startService(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainService3.getInstance().showWindow(1);
                    }
                }, 2000);

            }
        });

        findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainService.isrun) {
                    MainService.getInstance().closeCamera();

                    Intent intent = new Intent(MainActivity.this, MainService.class);
                    stopService(intent);
                }

                if (MainService2.isrun) {
                    MainService2.getInstance().closeCamera();

                    Intent intent = new Intent(MainActivity.this, MainService2.class);
                    stopService(intent);
                }
                ShellUtils.execCommand(CameraConstants.KEY_CAMERA_RELEASE, false);
            }
        });
        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainService.isrun) {
                    MainService.getInstance().showWindow(1);
                }
                if (MainService2.isrun) {
                    MainService2.getInstance().showWindow(1);
                }
            }
        });

        findViewById(R.id.tv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class).putExtra("time", System.currentTimeMillis()));
            }
        });

        findViewById(R.id.tv_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!com.android.media.SurfaceView.MainService2.isrun) {
                    Intent intent = new Intent(MainActivity.this, com.android.media.SurfaceView.MainService2.class);
                    startService(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        com.android.media.SurfaceView.MainService2.getInstance().showWindow(1);
                    }
                }, 2000);

            }
        });

    }
}
