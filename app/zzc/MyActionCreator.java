package zzc;

import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Result;
import java.util.concurrent.CompletionStage;
import java.lang.reflect.Method;
import zzc.Log4jTest;
public class MyActionCreator implements play.http.ActionCreator {
    @Override
    public Action createAction(Http.Request request, Method actionMethod) {
        return new Action.Simple() {
//            @Override
//            public CompletionStage<Result> call(Http.Request req) {
//                return delegate.call(req);
//            }
        	
        	
			@Override
			public CompletionStage<Result> call(Context ctx) {
				// TODO Auto-generated method stub
				System.out.println("MyActionCreator"+ctx.request());

				Log4jTest.logger1.debug("我是logger1，debug");
				
				return delegate.call(ctx);
			}
        };
    }
}