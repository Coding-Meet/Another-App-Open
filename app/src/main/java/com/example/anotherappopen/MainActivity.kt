package com.example.anotherappopen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shareAppBtn = findViewById<Button>(R.id.shareAppBtn)
        shareAppBtn.setOnClickListener {
            shareUrl()
        }

        val instagramProBtn = findViewById<Button>(R.id.instProOpenBtn)
        instagramProBtn.setOnClickListener {
            val profilePath = "https://instagram.com/codingmeet26"
            val instaPackageName = "com.instagram.android"
            toAnotherAppOpen(profilePath,instaPackageName)
        }

        val playstoreAppBtn = findViewById<Button>(R.id.playstoreAppBtn)
        playstoreAppBtn.setOnClickListener {
            // here something went wrong because app is not published
            val playStoreAppPath = "https://play.google.com/store/apps/details?id=$packageName"
            val playStorePackageName = "com.android.vending"
            toAnotherAppOpen(playStoreAppPath,playStorePackageName)
        }

        val githubProOpenBtn = findViewById<Button>(R.id.githubProOpenBtn)
        githubProOpenBtn.setOnClickListener {
            val githubProfilePath = "https://github.com/Coding-Meet"
            val githubAppPackageName = "com.github.android"
            toAnotherAppOpen(githubProfilePath,githubAppPackageName)
        }
    }

    private fun toAnotherAppOpen(profilePath: String, openAppPackageName: String) {
        val uri = Uri.parse(profilePath)
        try{
            startActivity(Intent(Intent.ACTION_VIEW,uri).setPackage(openAppPackageName))
        }catch (e:Exception){
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }
    }

    private fun shareUrl() {
        val packageName = packageName /// here your package Name
        val playStoreUrl = "https://play.google.com/store/apps/details?id=$packageName"
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT,playStoreUrl)
        startActivity(Intent.createChooser(sendIntent,"Share Via"))
    }
}