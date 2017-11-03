# ElevatorDesign
This project simulates the basic elevator control system .In this project, there are two important classes , 
Elevator resembling the real world elevator and people resembling the people who want to get inside the elevator or waiting 
to exit the elevator.This whole simulation is done based on the producer consumer problem of synchroniation,multithreading where
producer produces the data and consumer consumes the object .Therefore , we need to have use synchronization on
the common object used by both the thread.Here people is the producer producing the queue of people wanting to enter 
the elevator at various floor whereas the elevator is consumer and people's queue is the common object.

##  Dascription :
###     Classes :
 -   **Bututon.java**
 -   **Elevator Button.java**
 -   **FloorButton.java**
 -   **ButtonParam**
 -   **Elevator** 
 -  **MachineRoomElevator** 
  -  **Peole**
  - **ElevatorPeople**
  -  **ElevatorList**
  -  **ElevatorController**
