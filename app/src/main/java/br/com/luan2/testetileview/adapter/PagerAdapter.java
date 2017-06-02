package br.com.luan2.testetileview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.luan2.testetileview.fragment.Fragment1;
import br.com.luan2.testetileview.fragment.Fragment2;


/**
 * Created by Luan Gabriel on 25/10/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    Fragment1 tab1;
    Fragment2 tab2;



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(tab1==null)
                    tab1 = new Fragment1();
                return tab1;
            case 1:
                if(tab2==null)
                    tab2 = new Fragment2();
                return tab2;
            default:
                Fragment1 tab = new Fragment1();
                return tab;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
