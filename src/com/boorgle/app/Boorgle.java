/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.boorgle.app;

import android.app.Activity;
import android.os.Bundle;
import org.apache.cordova.*;
import android.content.Intent;

public class Boorgle extends DroidGap
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setIntegerProperty("splashscreen", R.drawable.splash);
        super.loadUrl("file:///android_asset/www/index.html", 10000);
    }

    @Override
    public Object onMessage(String id, Object obj) {

        if (id.equals("onPageStarted")) {

            final Intent intent = getIntent();
            if(intent.getDataString()!= "" && intent.getDataString()!= null){
                String url = intent.getDataString();
                this.sendJavascript("handleOpenURL('" + url + "');");
            }

        }
        return super.onMessage(id, obj);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if(intent.getDataString()!= "" && intent.getDataString()!= null){
            String url = intent.getDataString();
            this.sendJavascript("handleOpenURL('" + url + "');");
        }
    }
}
