package br.com.luan2.testetileview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.qozix.tileview.TileView;
import com.qozix.tileview.markers.MarkerLayout;

import br.com.luan2.testetileview.R;


public class Fragment1 extends Fragment implements View.OnClickListener {

    protected View rootView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_1, container,false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
    TileView tileView;

    private void initView(View rootView) {

        tileView = new TileView( getActivity() );
        LinearLayout.LayoutParams tileViewLayout = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, 0, 1 );
        tileView.setSize( 3100, 2600 );
        tileView.addDetailLevel( 1.000f, "tiles/codebox/1000/tile-%d_%d.png");
        tileView.addDetailLevel( 0.500f, "tiles/codebox/500/tile-%d_%d.png");
        tileView.addDetailLevel( 0.250f, "tiles/codebox/250/tile-%d_%d.png");
        tileView.addDetailLevel( 0.125f, "tiles/codebox/125/tile-%d_%d.png");
        tileView.setScaleLimits( 0, 5 );
        tileView.defineBounds( 0, 0, 1, 1 );
        tileView.setScale(0);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ((LinearLayout) rootView).addView(tileView, lp);

        tileView.setMarkerAnchorPoints( -0.5f, -0.5f );

        addPin( 0.555, 0.222 );


        frameTo( 0.5, 0.5 );


    }

    public TileView getTileView(){
        return tileView;
    }


    public void frameTo( final double x, final double y ) {
        getTileView().post( new Runnable() {
            @Override
            public void run() {
                getTileView().scrollToAndCenter( x, y );
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    private void addPin( double x, double y ) {
        ImageView imageView = new ImageView( getActivity() );
        imageView.setImageResource( R.drawable.push_pin );
        getTileView().addMarker( imageView, x, y, null, null );
    }

    private MarkerLayout.MarkerTapListener mMarkerTapListener = new MarkerLayout.MarkerTapListener() {
        @Override
        public void onMarkerTap( View v, int x, int y ) {
            Toast.makeText( getContext(), "You tapped a pin", Toast.LENGTH_LONG ).show();
        }
    };
}
