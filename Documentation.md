## Documentation 

The project consists of 3 modules: 

1. Client (Spring Boot server)
2. Server (Spring Boot server)
3. Models (Basic Maven module)

### Client module
 The client module is responsible for calling the server and fetching the data through an HTTP GET call. The content, contained in the response body, is an XML file (as the task requires).

### Server module
 The server is reponsible for handling calls to its `/xml` endpoint. The handling itself is simply parsing the content of an XML file and adding it to the response body. The parsing is done through the Jackson library, which has many convenient for the problem methods. The one used is `.readValue()`, which takes a `File` object(the content to be read) and, in this case, `TypeReference` which is an object used when parsing more complex files. Instead of `TypeReference`, we could create a DTO class in the `Models` module and pass it here.

### Models module
 This module holds the XML file mentioned above, and is also extensible to hold DTO's or other model-related classes if such are required (i.e data class for the content in the XML file).