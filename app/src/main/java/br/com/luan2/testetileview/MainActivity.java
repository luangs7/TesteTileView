 package br.com.luan2.testetileview;

 import android.os.Bundle;

import com.qozix.tileview.TileView;

 public class MainActivity extends TileViewActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TileView tileView = getTileView();
        tileView.setSize(2000, 3000 );  // the original size of the untiled image
        tileView.addDetailLevel( 1.000f, "tiles/plans/1000/%d_%d.jpg");
        tileView.addDetailLevel( 0.500f, "tiles/plans/500/%d_%d.jpg");
        tileView.addDetailLevel( 0.250f, "tiles/plans/250/%d_%d.jpg");
        tileView.addDetailLevel( 0.125f, "tiles/plans/125/%d_%d.jpg");
//        tileView.addDetailLevel( 0.500f, "tiles/codebox/1000/%d_%d.jpg");
        tileView.setScaleLimits( 0, 5 );
        tileView.setScale(0);

    }
}
