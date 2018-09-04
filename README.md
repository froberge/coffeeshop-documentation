# Database Service

This service handle all the database functionnalities

The code was build to run on an postgreSQL database.

Their is to database option with this service.

1. Insert in a Java List
2. User a PLSQL database

To create the database you can call the endpoint createdb which will load the database using the script found dbscripts/creationScript.sql

This is a maven project so just import in your favorite IDE and it should work.

Should run in a multitude of application server.  Has been tested with:
* Wildfly 10.1 & 12
* Openshift Container Platform ( OCP ) using S2I

#Here how to [contribute](CONTRIBUTING.md)
