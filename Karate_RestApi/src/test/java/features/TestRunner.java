package features;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
	Karate GetapiTest() {
		return Karate.run("GETApi").relativeTo(getClass());
	}
	
	Karate PostAPi() {
		return Karate.run("POSTApi").relativeTo(getClass());
	}
	
	Karate PutApi() {
		return Karate.run("PUTcall").relativeTo(getClass());
	}
	
	Karate DeleteApi() {
		return Karate.run("DeleteApi").relativeTo(getClass());
	}
}
