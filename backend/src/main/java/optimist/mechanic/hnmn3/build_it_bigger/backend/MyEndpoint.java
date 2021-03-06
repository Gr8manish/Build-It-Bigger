/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package optimist.mechanic.hnmn3.build_it_bigger.backend;

import com.example.JavaJokesClass;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.build_it_bigger.hnmn3.mechanic.optimist",
    ownerName = "backend.build_it_bigger.hnmn3.mechanic.optimist",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi Whats Up?, " + name);

        return response;
    }

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "gceJokes")
    public Joke gceJokes() {
        Joke response = new Joke();
        String[] jokes = new JavaJokesClass().getJokes();
        response.setJokes(jokes);
        return response;
    }

}
