 
# ISBNWebService
The goal of this application is made possible to get data from remote source about books.
In this example data loading is implemented from http://isbndb.com web serice. This remote web service returns an xml
the application convert it to JSON and returns it to client. At the same time saving book in repository, so
that subsequent requests for the same book will be returned from repository. Purpose is to not overhead remote service
and increase the speed of query processing.

In the application were used Repository, Wrapper designt patterns.
Also was implemented simple httpServer.

To use application you need plain Web Browser(Chrome, Mozilla Firefox more preferable).

## Installation

Steps to install application:

1) Fetch project<br/>
2) assembly project: mvn clean compile assembly:single <br/>
3) navigate to the folder: cd target <br/>
4) Start Server: java -jar ISBNWebService-1.0-SNAPSHOT-jar-with-dependencies.jar<br/>
Default port is 8765, you can specify it as parameters.

## Usage

By default application can be accessible on http://localhost:8765/some?book=0312510780
You can replace number by any valid book ISBN(Some books not available)
To test you can use this ISBN: <br/>
0439434408 <br/>
1627790624 <br/>
0805096663(Or ISBN13:  9780805096668)<br/>
0312510780 <br/>
0800788222 <br/>

Note that there is limit 500 requests(http://isbndb.com) per day.
## History

TODO: Write history

## Credits

TODO: Write credits

## License

TODO: Write license
