package hbisoft.com.surfaceviewpinchzoom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lucem.lib.ZoomableTextureView;

import java.io.IOException;

public class MainActivity extends Activity implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener{

    String path = "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4";
    private MediaPlayer mediaPlayerTexture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ZoomableTextureView textureView = (ZoomableTextureView) findViewById(R.id.textureView);
        textureView.setSurfaceTextureListener(this);
    }

    private void prepareTextureView(SurfaceTexture surface) {
        Surface s = new Surface(surface);
        mediaPlayerTexture = new MediaPlayer();
        mediaPlayerTexture.setSurface(s);
        try {
            mediaPlayerTexture.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayerTexture.prepareAsync();
        mediaPlayerTexture.setOnPreparedListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        prepareTextureView(surfaceTexture);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }

    /**
     * MediaPlayer
     **/
    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayerTexture != null) {
            mediaPlayerTexture.release();
            mediaPlayerTexture = null;
        }
    }
}
