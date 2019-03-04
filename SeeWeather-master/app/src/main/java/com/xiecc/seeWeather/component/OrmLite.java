package com.xiecc.seeWeather.component;

import com.litesuits.orm.LiteOrm;
import com.xiecc.seeWeather.BuildConfig;
import com.xiecc.seeWeather.base.BaseApplication;
import com.xiecc.seeWeather.common.C;

public class OrmLite {

    static LiteOrm sLiteOrm;

    public static LiteOrm getInstance() {
        getOrmHolder();
        return sLiteOrm;
    }

    private static OrmLite getOrmHolder() {
        return OrmHolder.sInstance;
    }

    private OrmLite() {
        if (sLiteOrm == null) {
            sLiteOrm = LiteOrm.newSingleInstance(BaseApplication.getAppContext(), C.ORM_NAME);
        }
        sLiteOrm.setDebugged(BuildConfig.DEBUG);
    }

    private static class OrmHolder {
        private static final OrmLite sInstance = new OrmLite();
    }
}
