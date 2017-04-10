package com.example.poornima.globetrot2;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;


public class BaseActivity extends AppCompatActivity {


    protected FrameLayout frameLayout;
    protected ListView mDrawerList;
    protected String[] listArray = {"Home Screen","Hotels","Places","Restaurants","Info","Weather","Translate","Favourites","Log Out"};
    protected char[] inList = {'a','b','c','d'};
    protected static int position;
    private static boolean isLaunch = true;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_base_layout);

        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, listArray));
        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                openActivity(position);
            }
        });




        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                        /* nav drawer image to replace 'Up' caret */
                R.string.open_drawer,       /* "open drawer" description for accessibility */
                R.string.close_drawer)      /* "close drawer" description for accessibility */ {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(getTitle());
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Navigation");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        if (isLaunch) {
            isLaunch = false;
            openActivity(0);
        }
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        //actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
    }

    protected void openActivity(int position) {


        mDrawerLayout.closeDrawer(mDrawerList);
        BaseActivity.position = position;

        switch (position) {
            case 0:
                if(HomeScreen.active==true)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
                        mDrawerLayout.closeDrawer(mDrawerList);
                    }
                }
                else
                {
                    startActivity(new Intent(this, HomeScreen.class));
                }
                break;
            case 1:
                startActivity(new Intent(this, Place.class));
                break;
            case 2:
                startActivity(new Intent(this, Hotel.class));
                break;
            case 3:
                startActivity(new Intent(this, Restaurant.class));
                break;
            case 4:
                startActivity(new Intent(this, Info.class));
                break;
            case 5:
                startActivity(new Intent(this, Weather.class));
                break;
            case 6:
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("ai.api.sample");
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    i.addCategory(Intent.CATEGORY_LAUNCHER);

                    Log.e("asdasdasd", "openctivity: working translat" );
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("KFKFKKNFKJFKNFKJF", "openActivity: "+e.toString() );

                }
                break;
            case 7:
                startActivity(new Intent(this, Favourites.class));
                break;
            case 8:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LoginAcitvity.class));
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

        return super.onPrepareOptionsMenu(menu);
    }

    boolean twice = false;

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);

        }
        else
        {
            position = 0;
            super.onBackPressed();
        }
        mDrawerList.setItemChecked(position, true);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}