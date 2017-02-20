/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Peretz.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.example.jokes.Joker;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.Peretz.example.com",
    ownerName = "backend.myapplication.Peretz.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "getJokeApi")
    public MyBean getJokeApi() {
        MyBean response = new MyBean();
        response.setData(new Joker().getJoke());

        return response;
    }

}
