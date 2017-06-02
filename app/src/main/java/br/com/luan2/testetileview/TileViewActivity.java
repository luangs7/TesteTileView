package br.com.luan2.testetileview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qozix.tileview.TileView;

/**
 * Created by luan2 on 01/06/2017.
 */

public class TileViewActivity extends AppCompatActivity {
    private TileView tileView;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        tileView = new TileView( this );

        /**
         * Set an id. This is necessary to enable the save state mechanism of Android.
         * It is retrieved from a resource value, but it can also be generated with
         * {@code View.generateViewId()}.
         */
        tileView.setId( R.id.tileview_id );
        tileView.setSaveEnabled( true );

        setContentView( tileView );
    }

    @Override
    public void onPause() {
        super.onPause();
        tileView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        tileView.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tileView.destroy();
        tileView = null;
    }

    public TileView getTileView(){
        return tileView;
    }

    /**
     * This is a convenience method to scrollToAndCenter after layout (which won't happen if called directly in onCreate
     * see https://github.com/moagrius/TileView/wiki/FAQ
     */
    public void frameTo( final double x, final double y ) {
        getTileView().post( new Runnable() {
            @Override
            public void run() {
                getTileView().scrollToAndCenter( x, y );
            }
        });
    }
}
