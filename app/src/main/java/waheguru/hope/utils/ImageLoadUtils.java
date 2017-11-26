package waheguru.hope.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import waheguru.hope.R;

/**
 * Created by jaswinderwadali on 20/11/17.
 */

public class ImageLoadUtils {
    private static ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance

    public static void init(Context context) {
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        imageLoader.init(configuration);
    }

    static public void loadImage(String imageUri, ImageView imageView) {
        imageLoader.displayImage(imageUri, imageView, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
            }
        });
    }

    static public void loadRoundImage(String imageUri, ImageView imageView) {
        DisplayImageOptions userimgoptions = new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(70))
                .showImageOnLoading(android.R.color.transparent)
                .showImageForEmptyUri(R.drawable.theme_button)
                .showImageOnFail(R.drawable.theme_button).cacheInMemory(true)
                .cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        imageLoader.displayImage(imageUri, imageView, userimgoptions);
    }
}
