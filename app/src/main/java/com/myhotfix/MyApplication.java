package com.myhotfix;

import android.app.Application;

import com.myhotfix.util.Util;
import com.taobao.hotfix.HotFixManager;
import com.taobao.hotfix.PatchLoadStatusListener;
import com.taobao.hotfix.util.PatchStatusCode;

/**@title MyApplication 初始化阿里百川HotFix
 * @author Eric
 * @date 2016/12/5
 **/
public class MyApplication extends Application {
    private String appVersion;
    private String appId = "80795-1";
    @Override
    public void onCreate() {
        appVersion = Util.getVersionName(getApplicationContext());
        HotFixManager.getInstance().initialize(this, appVersion, appId, true, new PatchLoadStatusListener() {
            @Override
            public void onload(int mode, int code, String info, int handlePatchVersion) {
                // 补丁加载回调通知
                if (code == PatchStatusCode.CODE_SUCCESS_LOAD) {
                    // TODO: 10/24/16 表明补丁加载成功
                } else if (code == PatchStatusCode.CODE_ERROR_NEEDRESTART) {
                    // TODO: 10/24/16 表明新补丁生效需要重启. 业务方可自行实现逻辑, 提示用户或者强制重启, 可以监听应用进入后台事件, 然后应用自杀
                } else {
                    // TODO: 10/25/16 其它信息
                }
            }
        });
        HotFixManager.getInstance().queryNewHotPatch();
        // TODO: 10/25/16 .....
    }
}
