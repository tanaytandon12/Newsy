package com.hauzkhasb2.newsy.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hauzkhasb2.newsy.R;
import com.hauzkhasb2.newsy.adapter.NavDrawerAdapter;
import com.hauzkhasb2.newsy.model.NavDrawerItem;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity {

    private CharSequence mTitle;
    public static final String DRAWER_DEFAULT_IMAGE = "https://lh3.googleusercontent.com/-23FytD3dZos/AAAAAAAAAAI/AAAAAAAAAJA/Tl2ayYFIDlg/s120-c/photo.jpg";
    private ArrayList<NavDrawerItem> navDrawerItemList;
    private NavDrawerAdapter adapterNavDrawer;
    private RecyclerView rvNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpNavDrawer();

        mTitle = getTitle();

    }


    private void setUpNavDrawer() {
        navDrawerItemList = new ArrayList<>();
        // drawer header item
        navDrawerItemList.add(new NavDrawerItem("John Snow", DRAWER_DEFAULT_IMAGE, true, false));
        // drawer list items
        navDrawerItemList.add(new NavDrawerItem("All", false));
        navDrawerItemList.add(new NavDrawerItem("Around me", "(new)", true));
        navDrawerItemList.add(new NavDrawerItem("Entertainment", false));
        navDrawerItemList.add(new NavDrawerItem("Politics", false));
        navDrawerItemList.add(new NavDrawerItem("Sports", false));
        navDrawerItemList.add(new NavDrawerItem("Business", false));
        navDrawerItemList.add(new NavDrawerItem("Technology", false));
        navDrawerItemList.add(new NavDrawerItem("Start Ups", false));
        navDrawerItemList.add(new NavDrawerItem("Trending", false));
        navDrawerItemList.add(new NavDrawerItem("Fashion", false));

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        rvNavDrawer = (RecyclerView) findViewById(R.id.rv_nav_drawer);
        rvNavDrawer.setHasFixedSize(true);
        adapterNavDrawer = new NavDrawerAdapter(HomeActivity.this, navDrawerItemList, onDrawerItemClickListener);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvNavDrawer.setLayoutManager(llm);
        rvNavDrawer.setAdapter(adapterNavDrawer);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, mDrawerLayout, tb, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private View.OnClickListener onDrawerItemClickListener = new View.OnClickListener() {
        public void onClick(View view) {

        }
    };

}
