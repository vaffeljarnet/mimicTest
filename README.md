# mimicTest - Manual

## Intro
An ongoing educational project in agile development, from a testing perspective

## Public methods to be tested in Store.java class
* **learnResponse()** metod returnerar inget och tar emot tv� parametrar av typen String. 
Metoden l�gger i responses(Hashtable) en request(Key) och den skapar ett nytt objekt av RequestResponse.
Dvs, metoden ska ta emot en Key och skapa en ny Value av typen RequestResponse och koppla ihop Key och Value till varandra.

* **learnResponseWithNull()** metod returnerar inget och tar emot tv� parametrar av typen String och RequestResponse.
Metoden l�gger i responses(Hashtable) en request(Key) och en reqRes(Value).

* **getResponse()** metod returnerar String och tar emot en parameter av typen String.
Metoden skapar en requestResponse(instans variabel) som ineh�ller adressen till ett RequestResponse objekt i hashtabel.
Den kontrollerar om requestResponse �r null, d� ska den returnera null, annars returnerar den en response(Value).

* **unlearnAll()** metod returnerar inget och tar inte emot n�gra parametrar.
Den skapar en ny, tom hashtable.

## Public methods in RequestResponse.java class
I klassen RequestResponse finns det tv� privata variabler av typen String som heter request och response.

* **RequestResponse()** �r en konstruktor som tar emot tv� parametrar av typen String och s�tter de parametrar ihop med variablerna(ex: this.request=request).

* **getRequest()** metod returnerar en request.
Den ger oss tillg�ng till den privata variabeln request.

* **setRequest()** metod returnerar inget och tar emot en parameter av typen String. 
Den s�tter v�rde och ger oss tillg�ng till den privata variabeln request.

* **getResponse()** metod returnerar en response.
Den ger oss tillg�ng till den privata variabeln response.
	
* **setResponse()**	metod returnerar inget och tar emot en parameter av typen String. 
Den s�tter v�rde och ger oss tillg�ng till den privata variabeln response.
	
## Dependencies
JUnit 4.12 [Download](https://github.com/junit-team/junit4/wiki/Download-and-Install) 


