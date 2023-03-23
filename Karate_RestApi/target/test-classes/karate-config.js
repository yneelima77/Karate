function fn() {   
  var env = karate.env; // get java system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev'; // a custom 'intelligent' default
  }
  var config = { // base config JSON
    
    UrlBase: 'https://gorest.co.in',
    tokenID: 'Bearer 1c5b1bef45c28336e41debe1e910f1bb5c905af8c9d1181c92ad62566b724d68'
    //4134efa5f6ab5687726a5c97fa5c47abd22b702ca1cb2bcafa514adaefbe7d2f
  };
  if (env == 'stage') {
    // over-ride only those that need to be
    //config.someUrlBase = 'https://stage-host/v1/auth';
  } else if (env == 'e2e') {
   // config.someUrlBase = 'https://e2e-host/v1/auth';
  }
  // don't waste time waiting for a connection or if servers don't respond within 5 seconds
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  return config;
}