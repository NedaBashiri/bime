# bime
Solve question bime shahram in site https://quera.org/problemset/157782/
this is a simple web application for Insurance that we handle how inheritance and polymorphism. It uses an in-memory database (H2) to store the data.
It is built by maven and spring boot.
There are two insurance in this app: Person and Vehicle.
After creating company name and then you can create insurance.

REST APIs Endpoints

Create a company resource
URL:
"POST /companies/save"

Request: 
content-type: "application/json"
{
  "name": "shahram"
}

Create a insurance resource
URL:
"POST /insurances/save"

Request:
content-type: "application/json"
{
  "type": "PERSON",
  "name": "shakhs",
  "price": 300000,
  "company_id": 1,
  "minAge": 20
}

Find a company

URL:

"POST /companies/get/{id}"

content-type: "application/json"

Find a insurance
URL:

"POST /insurances/get/{id}"
content-type: "application/json"
