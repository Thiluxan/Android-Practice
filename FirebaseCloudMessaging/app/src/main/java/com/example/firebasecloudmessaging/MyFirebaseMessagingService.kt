package com.example.firebasecloudmessaging

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        Log.d("TAG","New Token: $p0")
    }
}