package zzc;
import javax.inject.Inject;

import play.routing.Router;
import play.api.mvc.Handler;
import play.http.*;
import play.mvc.*;
import play.libs.streams.Accumulator;
import play.core.j.JavaHandler;
import play.core.j.JavaHandlerComponents;

public class RequestHandler implements HttpRequestHandler {
    private final Router router;
    private final JavaHandlerComponents handlerComponents;

    @Inject
    public RequestHandler(Router router, JavaHandlerComponents components) {
        this.router = router;
        this.handlerComponents = components;
    }

    public HandlerForRequest handlerForRequest(Http.RequestHeader request) {
        Handler handler = router.route(request).orElseGet(() ->
            EssentialAction.of(req -> Accumulator.done(Results.notFound()))
        );
      //  if (handler instanceof JavaHandler) {
            handler = ((JavaHandler)handler).withComponents(handlerComponents);
            System.out.println("----2"+request.host());
      //  }
        
        System.out.println("---->"+request.host());
        return new HandlerForRequest(request, handler);
    }
}