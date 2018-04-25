# mimicTest - Manual

## Intro
An ongoing educational project in agile development, from a testing perspective.

## Public methods to be tested in Store.java class
* **learnResponse()** metod returnerar inget och tar emot två parametrar av typen String. 
Metoden lägger i responses(Hashtable) en request(Key) och den skapar ett nytt objekt av RequestResponse.
Dvs, metoden ska ta emot en Key och skapa en ny Value av typen RequestResponse och koppla ihop Key och Value till varandra.

* **learnResponseWithNull()** metod returnerar inget och tar emot två parametrar av typen String och RequestResponse.
Metoden lägger i responses(Hashtable) en request(Key) och en reqRes(Value).

* **getResponse()** metod returnerar String och tar emot en parameter av typen String.
Metoden skapar en requestResponse(instans variabel) som inehåller adressen till ett RequestResponse objekt i hashtabel.
Den kontrollerar om requestResponse är null, då ska den returnera null, annars returnerar den en response(Value).

* **unlearnAll()** metod returnerar inget och tar inte emot några parametrar.
Den skapar en ny, tom hashtable som ersätter den befintliga.

## Public methods in RequestResponse.java class
I klassen RequestResponse finns det två privata variabler av typen String som heter request och response.

* **RequestResponse()** är en konstruktor som tar emot två parametrar av typen String och sätter de parametrar ihop med variablerna(ex: this.request=request).

* **getRequest()** metod returnerar en request.
Den ger oss tillgång till den privata variabeln request.

* **setRequest()** metod returnerar inget och tar emot en parameter av typen String. 
Den sätter värde och ger oss tillgång till den privata variabeln request.

* **getResponse()** metod returnerar en response.
Den ger oss tillgång till den privata variabeln response.
	
* **setResponse()**	metod returnerar inget och tar emot en parameter av typen String. 
Den sätter värde och ger oss tillgång till den privata variabeln response.
	
## Dependencies
JUnit 4.12 [Download](https://github.com/junit-team/junit4/wiki/Download-and-Install) 

## SPRINT 2

Mimic ReadMe
------------

Mimic is a learning virtual service. Use Mimic to simulate the behaviour of any http service.


Install and Run
---------------

Simply download and double-click the mimic.jar file. Yo may also start Mimic from the command line:

java -jar mimic.jar

Communicate with mimic using a browser or any http application.

Mimic uses port 8080, by default. Use the command below to start Mimic on port 80:

java -jar mimic.jar -p 80


Commands
--------

Send any http command to Mimic. It will send a response back or ask for a response. For example:

http://localhost:8080/add?value1=10&value2=20

Mimic will respond with a form for filling out the response. Mimic will auto detect the mime type.

Trigger the same request again and Mimic will respond with your previously defined response.


Unlearn the previous request/response using the "unlearn" command:

http://localhost:8080/unlearn


Define a response before triggering a request to prevent the form from appearing:

http://localhost:8080/LearnNextResponse?text=Hello

or by specifying the mime type:

http://localhost:8080/LearnNextResponse?text=<value>1</value>&mime=application/xml


Close Mimic by using the command:

http://localhost:8080/KillMimic


Release Notes:

Version 0.1:
- Learns responses to requests with or without using the form.
- May unlearn a request/response.
- Does not store learned request/responses to file.



