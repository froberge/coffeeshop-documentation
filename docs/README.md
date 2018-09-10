# Client Service

This service handle all the interaction with the client.
The code was made using a POSTGRESQL Database
The script to create the database can be found in the folder dbscripts
This is a maven project so just import in your favorite IDE and it should work.

#Here how to [contribute](CONTRIBUTING.md)

Should run in a multitude of application server.  Has been tested with:
* Wildfly 10.1 +
* Openshift Container Platform ( OCP ) using S2I

---

The REST API consists of the following methods:

Method  |  URL  |  Action
--------|-------|--------------
POST | /clients/select  | Select a user input:JSON object
POST | /clients/create| Add a new user into the database input:JSON
GET | /createSchema | Create or recreate the product Schema

---
##### The service can be tested using Postman using a JSON object using this information
