
# ISBNWebService
The goal of this application is made possible to get data from remote source about books.
In this example data loading is implemented from http://isbndb.com web serice. This remote web service returns an xml
the application convert it to JSON and returns it to client. At the same time saving book in repository, so
that subsequent requests for the same book will be returned from repository. Purpose is to not overhead remote service
and increase the speed of query processing.

In the application were used Repository, Wrapper.

To use application you need plain Web Browser.

## Installation

Steps to install application:

1) Fetch project<br/>
2) assembly project: mvn clean compile assembly:single <br/>
3) navigate to the folder: cd target <br/>
4) Start Server: java -jar ISBNWebService-1.0-SNAPSHOT-jar-with-dependencies.jar<br/>

## Usage

By default application can be accessible on http://localhost:8765/some?book=0312510780
You can replace number of any valid book ISBN(Some books not available)
To test you can use this ISBN:
0439434408
1627790624
0805096663(Or ISBN13:  9780805096668)
0312510780
0800788222

## History

TODO: Write history

## Credits

TODO: Write credits

## License

TODO: Write license
