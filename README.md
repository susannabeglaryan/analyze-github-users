# Analyze GitHub Users

"Analyze GitHub Users" is an application for collecting users data from GitHub for
further analyzing processes.  For data collecting GitHub public APIs have been used. 

On application run  it grabs the users from GitHub, applies filter which is specified
in advance, and in case of matching data it save on database. All these processes are done
reactively using WebFlux.

## Getting Started with docker
* Generate GitHub token https://github.com/settings/tokens
* Set environment variables on .env file
(e.g. `GITHUB_USERNAME`=_yourgithubusername_, `GITHUB_TOKEN`=_yourgeneratedtoken_)
* run `docker-compose --env-file .env  up`

## Features
* Grab and save GitHub users data
* API for getting all user with option of pagination settings, filtering by
  login, company and location
* API for getting grouped users by company
* API for getting grouped users by location

For detailed API information check swagger documentation.

## Tech
* Java 11
* Spring Boot
* WebFlux
* Hibernate, Liquibase
* Postgres
* Docker