# vuejs-java-starter

> Vue.js spring boot starter project

## Features:
* Spring Boot
* Vue.js
* Hot module replacement (from webpack dev server and from java)
* vue-router for routing (working well with spring router)
* vue-resources for data fetching
* development and production profiles
* fully automated maven workflow
* semantic-ui integration
* and will be more...

## Changelog

## 0.0.4 (2016-01-11)

* fixed 404 status code in routing
* fixed hot reload issues with images and fonts
* Added jquery and semantic-ui
* Added file loader for fonts

[show full changelog](CHANGELOG.md):

## Run in production mode

``` bash
# compile and start in production mode
 mvn spring-boot:run
```

server will start on [http://localhost:8080/](http://localhost:8080/)

## Run in development mode

``` bash
# compile and start in development mode
 mvn spring-boot:run -Dspring.profiles.active=dev

# start webpack development server for HMR
 npm run dev
```

java server will start on [http://localhost:8080/](http://localhost:8080/)
webpack server will start on [http://localhost:3000/](http://localhost:3000/)

Hot module replacement will be available from both servers

##Running tests

``` bash
# run karma tests
 npm run tests
 
# run java and karma
 mvn test
```

## Directory structure

```
.
├ build                   # webpack build configuration
├ .mvn                    # maven wrapper directory
├ node                    # maven will install node here
├ node_modules            # node modules
├ target                  # compiled java sources
├ src                     # sources
│  ├ main                 
│  │  ├ java                           # java sources
│  │  ├ vuejs                          # javascript sources
│  │  └ resources                      # resources
│  │     ├ static                      # static resources
│  │     │   ├ css                          # styles
│  │     │   ├ images                       # images
│  │     │   ├ dist                         # generated javascript goes here
│  │     │   └ index.html                   # development index.html
│  │     └ application.properties      # spring boot configuration properties
│  └ test                       # test sources
│      ├ java                   # java tests
│      └ vuejs                  # vue.js tests
├ .babelrc                 # babel configuration
├ .eslintrc                # eslint configuration
├ .gitignore               # gitignore
├ package.json             # node configuration
├ pom.xml                  # maven configuration 
├ mvnw                     # maven linux wrapper
├ mvnw.cmd                 # maven windows wrapper
├ npm                      # local npm linux wrapper
├ npm.cmd                  # local npm windows wrapper
└ README.md                # this file
```
