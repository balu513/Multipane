package com.demo.appsforbb.multipane;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private FrameLayout frameleft;
    private FrameLayout frameright;
    boolean isLandscape;
    private AlphaFragment alphaFragment;
    private BetaFragment betaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameleft = (FrameLayout) findViewById(R.id.framelayout_left);
        frameright = (FrameLayout) findViewById(R.id.framelayout_right);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (frameright == null)
            isLandscape = false;
        else
            isLandscape = true;

        replaceFragments();
    }

    private void replaceFragments() {
        alphaFragment = new AlphaFragment();
        betaFragment = new BetaFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        if (isLandscape) {
            Toast.makeText(getApplicationContext(), "LAND SCAPE", Toast.LENGTH_SHORT).show();
            bundle.putBoolean("isLand", true);
            alphaFragment.setArguments(bundle);
            ft.replace(R.id.framelayout_left, alphaFragment, "LIST FRAGMENT");
            ft2.replace(R.id.framelayout_right, betaFragment, "DETAIL FRAGMENT");
            ft.commit();
        } else {
            Toast.makeText(getApplicationContext(), "POTRAIT", Toast.LENGTH_SHORT).show();
            bundle.putBoolean("isLand", false);
            alphaFragment.setArguments(bundle);
            ft.replace(R.id.framelayout_left, alphaFragment, "LIST FRAGMENT");
            ft.commit();

        }

    }
    public void replaceFragment(Fragment fragment,Bundle bundle)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(bundle);
        ft.replace(R.id.framelayout_right,fragment);
        ft.commit();
    }
}
