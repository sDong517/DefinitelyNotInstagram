package com.example.definitelynotinstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("061HW9gusGTVnOg9FYM79DahypCmpT6dkDxInrTc")
                .clientKey("PHJYm8rMLY0wIcRh5ocqD4sAc2JpCmmmkE4cENAF")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
