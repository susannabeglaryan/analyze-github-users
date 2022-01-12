# Analyze GitHub Users

"Analyze GitHub Users" is an application for collecting users data from GitHub for
further analyzing processes.  For data collecting GitHub public APIs have been used. 

On application run  it grabs the users from GitHub, applies filter which is specified
in advance, and in case of matching data it save on database. All these processes are done
reactively using WebFlux.

## Getting Started with docker
* Generate GitHub token https://github.com/settings/tokens
* Create .env file and set `GITHUB_USERNAME` and `GITHUB_TOKEN` environment variables 
(e.g. `GITHUB_USERNAME`=_yourgithubusername_   `GITHUB_TOKEN`=_yourgeneratedtoken_)
* run `docker-compose --env-file .env  up`

Here you can find how to install docker and docker compose if
you don't have it on your machine: https://docs.docker.com/compose/install/

## Features
* Grab and save GitHub users data
* API for getting all user with option of pagination settings, filtering by
  login, company and location
* API for getting grouped users by company
* API for getting grouped users by location

For detailed API information check swagger documentation. http://localhost:8080/webjars/swagger-ui/index.html

## Tech
* Java 11
* Spring Boot
* WebFlux
* Hibernate, Liquibase
* Postgres
* Docker