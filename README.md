# Person Saving Status Tracking
Simple Rest Service developed to showcase how the hazelcast can be used to store the interm progress of long running service and return the progress status for the client.

When client makes Person Save call , think that if Person save takes huge time, user need to wait till the service sends response.

soln:
When user makes call, service sends the requestID. this requestID can be sent back to track the status using status API.

URL://

Swagger API:
http://localhost:61611/swagger-ui.html

JavaMElody API:
http://localhost:61612/actuator/monitoring
