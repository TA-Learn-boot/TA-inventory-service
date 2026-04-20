# Requirements for inventory service
### Description
This service is responsible for managing inventorys (buses).
Basic requirements are detailed below

1. [GET] /buses  (*returns all the buses for the logged in user.*)
1. [GET] /bus?bus_id   (*returns 1 bus.*)
1. [POST] /buses (*add a single or multiple buses.*)
1. [DELETE] /bus  (*deletes the bus*)
1. [UPDATE] /bus (*updates the bus*)
1. [GET] [POST] [UPDATE] [DELETE] driver (*create drivers and all crud*)
2. [GET] [POST] [UPDATE] [DELETE] calander (*assigned bus and driver on perticular date to the calander*)


#### mainly there are crud operations on bus. 