# cities-json-query

[![Build Status](https://img.shields.io/travis/radoslawdabrowski/cities-json-query.svg?style=flat-square&logo=travis-ci)](https://travis-ci.org/radoslawdabrowski/cities-json-query)
[![Coverage](https://img.shields.io/codecov/c/github/radoslawdabrowski/cities-json-query.svg?style=flat-square&logo=codecov)](https://codecov.io/gh/radoslawdabrowski/cities-json-query)
[![Codacy](https://img.shields.io/codacy/coverage/40706e76565e4ebca0353ca2d97bcb90.svg?style=flat-square&logo=codacy)](https://app.codacy.com/project/radoslawdabrowski/cities-json-query)



REST Api based on [Spring Boot](http://projects.spring.io/spring-boot/)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `pl.radoslawdabrowski.cities.citiesjsonquery.CitiesJsonQueryApplication ` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application to OpenShift

The easiest way to deploy the sample application to OpenShift is to use the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/radoslawdabrowski/cities-json-query
```

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "cities-json-query"
* A BuildConfig called "cities-json-query"
* DeploymentConfig called "cities-json-query"
* Service called "cities-json-query"

If you want to access the app from outside your OpenShift installation, you have to expose the springboot-sample-app service:

```shell
oc expose cities-json-query --hostname=www.example.com
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
