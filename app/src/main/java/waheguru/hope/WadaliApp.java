package waheguru.hope;

import android.app.Application;

import waheguru.hope.utils.ImageLoadUtils;

/**
 * Created by jaswinderwadali on 20/11/17.
 */

public class WadaliApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoadUtils.init(this);
    }
}
