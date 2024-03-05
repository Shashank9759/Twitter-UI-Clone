 package com.example.twitterclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

 class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
    lateinit var drawablelayout :DrawerLayout

     lateinit var naviview : NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawablelayout= findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
       setSupportActionBar(toolbar)
        naviview=findViewById(R.id.nav_view)
        naviview.setNavigationItemSelectedListener(this)

       val toggle= ActionBarDrawerToggle(this, drawablelayout,toolbar, R.string.open_nav, R.string.close_nav)

      drawablelayout.addDrawerListener(toggle)
       toggle.syncState()

     if(savedInstanceState==null){
         fragmentsettoactivity(profile())
         naviview.setCheckedItem(R.id.profile)
     }

    }

     override fun onNavigationItemSelected(item: MenuItem): Boolean {
         when(item.itemId){
             R.id.profile->fragmentsettoactivity(profile())
             R.id.bookmarks->fragmentsettoactivity(bookmarks())
             R.id.list->fragmentsettoactivity(lists())
             R.id.spaces->fragmentsettoactivity(spaces())
             R.id.monization->fragmentsettoactivity(monetisation())

         }
         drawablelayout.closeDrawer(GravityCompat.START)
         return true
     }



     fun fragmentsettoactivity(fragment:Fragment){
         val fragmentmanager = supportFragmentManager
         val transition = fragmentmanager.beginTransaction()
         transition.replace(R.id.fragment_container,fragment).commit()
     }
     override fun onBackPressed() {
         if (drawablelayout.isDrawerOpen(GravityCompat.START)) {
             drawablelayout.closeDrawer(GravityCompat.START)
         } else {
             onBackPressedDispatcher.onBackPressed()
         }
     }
 }