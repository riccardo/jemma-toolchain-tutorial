# jemma-toolchain-tutorial

Step-by-step tutorial covering the main aspects and key choices of the maven-based toolchain chosen in JEMMA.

## Contents

- [Step 0: Overall project structure and main commands](../../wiki/Step-00)
- [Step 1: Providing declarative services](../../wiki/Step-01)
- [Step 2: Consuming declarative services](../../wiki/Step-02)
- [Step 3: Adding the Web Console](../../wiki/Step-03)
- [Step 4: Configuration Admin](../../wiki/Step-04)
- [Step 5: Adding logging with pax-logging and slf4j](../../wiki/Step-05)
- [Step 6: Adding some unit tests](../../wiki/Step-06)
- [Step 7: Expose a rest service](../../wiki/Step-07)


## TODO List

- increase version of jetty and webconsole

- check if pax confman has a way to avoid re-loading properties on re-start withouth clean (i.e. "how can I keep my previous run-time conf rather than reloading at startup ??")
- how to re-route logging to logging service on the webconsole ?



### Notes da AbstractHttpServiceTest (jersey example osgi http service)

-- Bundle list B -- 
  [0] org.apache.felix.framework                                             | 4.2.1                | STARTED  | System Bundle
  [1] org.ops4j.pax.exam                                                     | 3.3.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.exam_3.3.0.jar
  [2] org.ops4j.pax.exam.inject                                              | 3.3.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.exam.inject_3.3.0.jar
  [3] org.ops4j.pax.exam.extender.service                                    | 3.3.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.exam.extender.service_3.3.0.jar
  [4] osgi.cmpn                                                              | 4.2.0.200908310645   | STARTED  | file:/tmp/1399628957760-0/bundles/osgi.cmpn_4.2.0.200908310645.jar
  [5] org.ops4j.pax.logging.pax-logging-api                                  | 1.6.4                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.logging.pax-logging-api_1.6.4.jar
  [6] org.ops4j.base                                                         | 1.4.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.base_1.4.0.jar
  [7] org.ops4j.pax.swissbox.core                                            | 1.7.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.swissbox.core_1.7.0.jar
  [8] org.ops4j.pax.swissbox.extender                                        | 1.7.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.swissbox.extender_1.7.0.jar
  [9] org.ops4j.pax.swissbox.framework                                       | 1.7.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.swissbox.framework_1.7.0.jar
 [10] org.ops4j.pax.swissbox.lifecycle                                       | 1.7.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.swissbox.lifecycle_1.7.0.jar
 [11] org.ops4j.pax.swissbox.tracker                                         | 1.7.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.swissbox.tracker_1.7.0.jar
 [12] org.apache.geronimo.specs.geronimo-atinject_1.0_spec                   | 1.0.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.apache.geronimo.specs.geronimo-atinject_1.0_spec_1.0.jar
 [13] javax.annotation-api                                                   | 1.2.0                | STARTED  | file:/tmp/1399628957760-0/bundles/javax.annotation-api_1.2.jar
 [14] org.ops4j.pax.url.mvn                                                  | 1.3.7                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.url.mvn_1.3.7.jar
 [15] org.ops4j.pax.tipi.junit                                               | 4.11.0.1             | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.tipi.junit_4.11.0.1.jar
 [16] org.ops4j.pax.tipi.hamcrest.core                                       | 1.3.0.1              | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.tipi.hamcrest.core_1.3.0.1.jar
 [17] org.ops4j.pax.exam.invoker.junit                                       | 3.3.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.exam.invoker.junit_3.3.0.jar
 [18] org.glassfish.hk2.api                                                  | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.api_2.3.0.b05.jar
 [19] org.glassfish.hk2.osgi-resource-locator                                | 1.0.1                | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.osgi-resource-locator_1.0.1.jar
 [20] org.glassfish.hk2.locator                                              | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.locator_2.3.0.b05.jar
 [21] org.glassfish.hk2.utils                                                | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.utils_2.3.0.b05.jar
 [22] org.glassfish.hk2.external.javax.inject                                | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.external.javax.inject_2.3.0.b05.jar
 [23] org.glassfish.hk2.external.aopalliance-repackaged                      | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.external.aopalliance-repackaged_2.3.0.b05.jar
 [24] org.objectweb.asm.all.debug                                            | 5.0.2                | STARTED  | file:/tmp/1399628957760-0/bundles/org.objectweb.asm.all.debug_5.0.2.jar
 [25] javassist                                                              | 3.18.1.GA            | STARTED  | file:/tmp/1399628957760-0/bundles/javassist_3.18.1.GA.jar
 [26] javax.ws.rs-api                                                        | 2.0.0                | STARTED  | file:/tmp/1399628957760-0/bundles/javax.ws.rs-api_2.0.jar
 [27] javax.validation.api                                                   | 1.1.0.Final          | STARTED  | file:/tmp/1399628957760-0/bundles/javax.validation.api_1.1.0.Final.jar
 [28] org.glassfish.jersey.core.jersey-common                                | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.core.jersey-common_2.9.0.SNAPSHOT.jar
 [29] org.glassfish.jersey.core.jersey-server                                | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.core.jersey-server_2.9.0.SNAPSHOT.jar
 [30] org.glassfish.jersey.core.jersey-client                                | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.core.jersey-client_2.9.0.SNAPSHOT.jar
 [31] org.glassfish.jersey.containers.jersey-container-servlet-core          | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.containers.jersey-container-servlet-core_2.9.0.SNAPSHOT.jar
 [32] org.glassfish.jersey.bundles.repackaged.jersey-guava                   | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.bundles.repackaged.jersey-guava_2.9.0.SNAPSHOT.jar
 [33] org.ops4j.pax.web.pax-web-jetty-bundle                                 | 0.7.4                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.web.pax-web-jetty-bundle_0.7.4.jar
 [34] org.ops4j.pax.web.pax-web-extender-war                                 | 0.7.4                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.web.pax-web-extender-war_0.7.4.jar
 [35] org.apache.felix.eventadmin                                            | 1.2.2                | STARTED  | file:/tmp/1399628957760-0/bundles/org.apache.felix.eventadmin_1.2.2.jar
 [36] PAXEXAM-PROBE-100e3c56-15b6-433c-941e-035582743f78                     | 0.0.0                | STARTED  | local
 [37] org.glassfish.jersey.examples.osgi-http-service.bundle                 | 2.9.0.SNAPSHOT       | STARTED  | mvn:org.glassfish.jersey.examples.osgi-http-service/bundle/2.9-SNAPSHOT



###  CUTTING



-- Bundle list B -- 
  [0] org.apache.felix.framework                                             | 4.2.1                | STARTED  | System Bundle
    [4] osgi.cmpn                                                              | 4.2.0.200908310645   | STARTED  | file:/tmp/1399628957760-0/bundles/osgi.cmpn_4.2.0.200908310645.jar
   [18] org.glassfish.hk2.api                                                  | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.api_2.3.0.b05.jar 
  [20] org.glassfish.hk2.locator                                              | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.locator_2.3.0.b05.jar
 [21] org.glassfish.hk2.utils                                                | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.utils_2.3.0.b05.jar
 [24] org.objectweb.asm.all.debug                                            | 5.0.2                | STARTED  | file:/tmp/1399628957760-0/bundles/org.objectweb.asm.all.debug_5.0.2.jar
  [27] javax.validation.api                                                   | 1.1.0.Final          | STARTED  | file:/tmp/1399628957760-0/bundles/javax.validation.api_1.1.0.Final.jar
  
 [12] org.apache.geronimo.specs.geronimo-atinject_1.0_spec                   | 1.0.0                | STARTED  | file:/tmp/1399628957760-0/bundles/org.apache.geronimo.specs.geronimo-atinject_1.0_spec_1.0.jar
 [13] javax.annotation-api                                                   | 1.2.0                | STARTED  | file:/tmp/1399628957760-0/bundles/javax.annotation-api_1.2.jar
 
 [19] org.glassfish.hk2.osgi-resource-locator                                | 1.0.1                | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.osgi-resource-locator_1.0.1.jar
 
 
 [22] org.glassfish.hk2.external.javax.inject                                | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.external.javax.inject_2.3.0.b05.jar
 [23] org.glassfish.hk2.external.aopalliance-repackaged                      | 2.3.0.b05            | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.hk2.external.aopalliance-repackaged_2.3.0.b05.jar
 
 [25] javassist                                                              | 3.18.1.GA            | STARTED  | file:/tmp/1399628957760-0/bundles/javassist_3.18.1.GA.jar
 [26] javax.ws.rs-api                                                        | 2.0.0                | STARTED  | file:/tmp/1399628957760-0/bundles/javax.ws.rs-api_2.0.jar
 
 [28] org.glassfish.jersey.core.jersey-common                                | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.core.jersey-common_2.9.0.SNAPSHOT.jar
 [29] org.glassfish.jersey.core.jersey-server                                | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.core.jersey-server_2.9.0.SNAPSHOT.jar
 [30] org.glassfish.jersey.core.jersey-client                                | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.core.jersey-client_2.9.0.SNAPSHOT.jar
 [31] org.glassfish.jersey.containers.jersey-container-servlet-core          | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.containers.jersey-container-servlet-core_2.9.0.SNAPSHOT.jar
 [32] org.glassfish.jersey.bundles.repackaged.jersey-guava                   | 2.9.0.SNAPSHOT       | STARTED  | file:/tmp/1399628957760-0/bundles/org.glassfish.jersey.bundles.repackaged.jersey-guava_2.9.0.SNAPSHOT.jar
 [33] org.ops4j.pax.web.pax-web-jetty-bundle                                 | 0.7.4                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.web.pax-web-jetty-bundle_0.7.4.jar
 [34] org.ops4j.pax.web.pax-web-extender-war                                 | 0.7.4                | STARTED  | file:/tmp/1399628957760-0/bundles/org.ops4j.pax.web.pax-web-extender-war_0.7.4.jar
 [35] org.apache.felix.eventadmin                                            | 1.2.2                | STARTED  | file:/tmp/1399628957760-0/bundles/org.apache.felix.eventadmin_1.2.2.jar
