package com.mm.planjson;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Current schedule");

        //navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //tablayout
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        ArrayList<String> weekDays = new ArrayList<>();
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Thursday");
        weekDays.add("Friday");

        prepareViewPager(viewPager, weekDays);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> weekDays) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        DayOfWeekFragment fragment = new DayOfWeekFragment();

        for (int i = 0; i < weekDays.size(); i++) {
            Bundle bundle = new Bundle();
            switch (i) {
                case 0: {
                    bundle.putString("adapter", "0");
                    break;
                }
                case 1: {
                    bundle.putString("adapter", "1");
                    break;
                }
                case 2: {
                    bundle.putString("adapter", "2");
                    break;
                }
                case 3: {
                    bundle.putString("adapter", "3");
                    break;
                }
                case 4: {
                    bundle.putString("adapter", "4");
                    break;
                }
            }
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, weekDays.get(i));
            fragment = new DayOfWeekFragment();
        }
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.nav_message:
                onBackPressed();
                break;
            case R.id.nav_chat:

                break;
            case R.id.nav_profile:

                break;
            case R.id.nav_exams:

                break;
            case R.id.nav_notes:

                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {
            arrayList.add(title);
            fragmentList.add(fragment);
        }

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }
}