package com.zebra.zdsDemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.zebra.zds.ZdsIconButton;
import com.zebra.zds.ZdsSystemBanner;
import com.zebra.zds.ZdsToolbar;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mActionDrawerToggle;
    private DrawerLayout drawerLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        ZdsToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup Collapsing toolbar layout
        mCollapsingToolbarLayout = findViewById(R.id.collapsingToolbar);

        // Setup drawer toggle
        drawerLayout = findViewById(R.id.drawer_layout);
        mActionDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                View view = MainActivity.this.getWindow().getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    view.clearFocus();
                }
            }
        };

        drawerLayout.addDrawerListener(mActionDrawerToggle);
        mActionDrawerToggle.syncState();

        // Setup navigation
        View mNavigation = findViewById(R.id.nav_host_fragment);
        NavController navController = Navigation.findNavController(mNavigation);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Setup drawer navigation
        NavigationView navView = findViewById(R.id.navigation_view);
        navView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.buttonsFragment:
                    navController.navigate(R.id.buttonsFragment);
                    break;

                case R.id.iconButtonsFragment:
                    navController.navigate(R.id.iconButtonsFragment);
                    break;

                case R.id.FABFragment:
                    navController.navigate(R.id.FABFragment);
                    break;

                case R.id.textInputFragment:
                    navController.navigate(R.id.textInputFragment);
                    break;

                case R.id.switchFragment:
                    navController.navigate(R.id.switchFragment);
                    break;

                case R.id.radioFragment:
                    navController.navigate(R.id.radioFragment);
                    break;

                case R.id.checkboxFragment:
                    navController.navigate(R.id.checkboxFragment);
                    break;

                case R.id.progressIndicatorsFragment:
                    navController.navigate(R.id.progressIndicatorsFragment);
                    break;

                case R.id.toolbarFragment:
                    navController.navigate(R.id.toolbarFragment);
                    break;

                case R.id.tabsFragment:
                    navController.navigate(R.id.tabsFragment);
                    break;

                case R.id.listFragment:
                    navController.navigate(R.id.listFragment);
                    break;

                case R.id.dialogsFragment:
                    navController.navigate(R.id.dialogsFragment);
                    break;

                case R.id.dropdownFragment:
                    navController.navigate(R.id.dropdownFragment);
                    break;

                case R.id.searchFragment:
                    navController.navigate(R.id.searchFragment);
                    break;

                case R.id.snackbarFragment:
                    navController.navigate(R.id.snackbarFragment);
                    break;

                case R.id.bannerFragment:
                    navController.navigate(R.id.bannerFragment);
                    break;

                case R.id.selectInputFragment:
                    navController.navigate(R.id.selectInputFragment);
                    break;

            }

            mActionDrawerToggle.syncState();
            drawerLayout.closeDrawers();
            mCollapsingToolbarLayout.setTitle(Objects.requireNonNull(getSupportActionBar()).getTitle());
            return true;
        });

        // Setup Navigation view header and footer
        ((TextView) navView.getHeaderView(0).findViewById(R.id.title)).setText("Title");
        ((TextView) navView.getHeaderView(0).findViewById(R.id.subtitle)).setText("Subtitle");
        ((TextView) findViewById(R.id.footer_subtitle)).setText("version " + BuildConfig.VERSION_NAME);

        ((AppCompatImageView) navView.getHeaderView(0).findViewById(R.id.image)).setImageResource(R.drawable.ic_baseline_emoji_emotions_24);
        ((ZdsIconButton) navView.getHeaderView(0).findViewById(R.id.action)).setIconTint(ColorStateList.valueOf(Color.WHITE));
        ((ZdsIconButton) navView.getHeaderView(0).findViewById(R.id.action)).setIconResource(R.drawable.ic_baseline_settings_24);

        setMenuCounter(navView, R.id.buttonsFragment, 24);

        // Setup support action bar
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        }

        getBanner().setOnClickListener(v -> hideBanner());
    }

    private void setMenuCounter(NavigationView navigationView, @IdRes int itemId, int count) {
        TextView view = (TextView) navigationView.getMenu().findItem(itemId).getActionView();
        view.setText(count > 0 ? String.valueOf(count) : null);
        view.setVisibility(count > 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        View mNavigation = findViewById(R.id.nav_host_fragment);
        NavController navController = Navigation.findNavController(mNavigation);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mActionDrawerToggle.syncState();
        drawerLayout.closeDrawers();
        mCollapsingToolbarLayout.setTitle(Objects.requireNonNull(getSupportActionBar()).getTitle());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mActionDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mActionDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (item.getItemId() == R.id.action_change_theme) {
            int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            switch (currentNightMode) {
                case Configuration.UI_MODE_NIGHT_NO:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    break;
                case Configuration.UI_MODE_NIGHT_YES:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    break;
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ZdsSystemBanner getBanner() {
        return findViewById(R.id.systemBanner);
    }

    public void showBanner() {
        ZdsSystemBanner.Style style = getBanner().getStyle();
        int statusBarColor = R.color.zebra_black_toolbar;
        switch(style) {
            case DEFAULT:
                statusBarColor = R.color.zebra_blue_enabled;
                break;
            case POSITIVE:
                statusBarColor = R.color.zebra_green_system_banner;
                break;
            case WARNING:
                statusBarColor = R.color.zebra_yellow_system_banner;
                break;
            case NEGATIVE:
                statusBarColor = R.color.zebra_red_enabled;
                break;
        }
        getWindow().setStatusBarColor(ContextCompat.getColor(this, statusBarColor));

        getBanner().setVisibility(View.VISIBLE);
        ((MotionLayout) findViewById(R.id.mainLayout)).transitionToEnd();
    }

    public void hideBanner() {
        ((MotionLayout) findViewById(R.id.mainLayout)).transitionToStart();
        getBanner().setVisibility(View.GONE);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.zebra_black_toolbar));
    }
}
