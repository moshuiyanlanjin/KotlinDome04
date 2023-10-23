package com.example.kotlindemo04.AOP;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.lf.javademo.AOP.AopFun.IperMission;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import pub.devrel.easypermissions.EasyPermissions;

public class PermissionRequestActivity extends Activity implements EasyPermissions.PermissionCallbacks{

    private static IperMission iperMission;
    private static final String PERMISSION = "permission";
    private static final String REQUUSET_CODE = "requsetCode";

    public static void startPermissionRequest(Context context, String[] permission, int requsetCode, IperMission iperMission){
        iperMission = iperMission;
        Intent intent = new Intent(context, PermissionRequestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle bundle = new Bundle();
        bundle.putStringArray(PERMISSION,permission);
        bundle.putInt(REQUUSET_CODE,requsetCode);
        intent.putExtras(bundle);
        context.startActivity(intent);

        //屏蔽动画
        if(context instanceof Activity){
            ((Activity) context).overridePendingTransition(0,0);
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String[] permission = bundle.getStringArray(PERMISSION);
        int requesetCode = bundle.getInt(REQUUSET_CODE);
        requesetPermission(permission,requesetCode);
    }

    private void requesetPermission(String[] permission, int requesetCode) {
        boolean b = EasyPermissions.hasPermissions(this, permission);
        Log.d("当前申请的权限有：",permission.length + ",是否已经存在：" + b);
        if(b){
            iperMission.onPermissionGranted();
        }else{
            EasyPermissions.requestPermissions(this,"是否请求权限",1,permission);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        //授予权限
        if(requestCode == 1){
            iperMission.onPermissionGranted();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        //权限被拒
        iperMission.onPermissionDenied(requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this);
    }


}
