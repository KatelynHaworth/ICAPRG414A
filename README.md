ICAPRG414A - Jobs List Appllication
==========================

The java application was written by Liam Haworth <liam.haworth@hivemedia.net.au> for a Certificate IV assessment task (ICAPRG414A).

The purpose of the application is to allow users to have a application with a graphical user interface that allows them to add, edit and delete "Jobs". The application isn't required to have save/load functionality but it might added at a later date.

A job is made up of the follow attributes

| Attribute             | Type             | Description                                                |
|:----------------------|:-----------------|:-----------------------------------------------------------|
| ID                    | Integer          | Unique ID number representing a Job object                 |
| Name                  | String           | The first name of the client for the Job                   |
| Surename              | String           | the surname of the client for the Job                      |
| Address               | String           | The address at which the Job is to be conducted at         |
| Suburb                | String           | The suburb at which the Job is to be conducted at          |
| Postcode              | Integer          | The postcode of the location for the Job                   |
| Date                  | Date             | The date on which the Job is to be completed               |
| HoursWorked           | Integer          | The ammount of man hours spent on the Job                  |
| JobDetails            | String           | Information about the Job that the worker needs to know    |
| Completed             | Boolean          | Defines if the Job has been completed                      |
| Price                 | Integer          | The total cost of the Job to be charged to the client      |
| Paid                  | Boolean          | Defines if the client has paid for the Job (Once completed)|


A new Job object is made by and stored in the `JobRegistry` which sorts Jobs by ID and provides methods to edit and delete Jobs.


Version
=======

`1.0.0-SNAPSHOT`

Making this project
===================

```
mvn clean install
java -jar ./target/ICAPRG414A-1.0.0-SNAPSHOT.jar
```

Contributing
============

This project was designed for an assessment task only and shall not receive updates nor accept pull requests

Authors and Licenses
====================

|                 |                                              |
|:----------------|:---------------------------------------------|
| **Author**      | Liam Haworth <liam.haworth@hivemedia.net.au> |
|                 |                                              |
| **Copyright**   | Copyright (c) Liam Haworth, 2015             |

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
