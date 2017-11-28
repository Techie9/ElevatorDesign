# ElevatorDesign
This project simulates the basic elevator control system .In this project, there are two important classes , 
Elevator resembling the real world elevator and people resembling the people who want to get inside the elevator or waiting 
to exit the elevator.This whole simulation is done based on the producer consumer problem of synchroniation,multithreading where
producer produces the data and consumer consumes the data .Therefore , we need to use synchronization on
the common object used by both the thread.Here people is the producer producing the queue of people wanting to enter 
the elevator at various floor whereas the elevator is consumer and people's queue is the common object.

##  Description :
###     Classes :
 -  **Button.java**
     - _indicatorON_  : Checks which button is on elevator or floor
     - _isMovingDown_ : Checks whether the elevator is moving down 
     - _isMovingUP_   : Checks whether the elevator is moving up 
     - _param_        : Object of the button param class
     - buttonON()     : Check which button is on and sets the nextFLoor of the elevator based on which floor button is on
 -  **ButtonParam**
     - _ArrayList<ElevatorList>_ _elevatorList_
     - _ArrayList<EleavtorPeople>_ _people_ 
 -   **FloorButton.java**
     - This is the subclass of Button
 -  **Elevator Button.java**
     - This is the subclass of Button
     - _checkDirection()_ : Checks the direction of the elevator whether its moving up or down 
 -  **Elevator** 
     - _currentFloor_ : keeps track of the cuurent floor of the elevator 
     - _totalFloor_   : Total number of floor eleavtor can traverse 
     - _isEnter()_      : Checks whether any one entered the elevator at particular floor
     - _isExist()_      : Checks whether any one existed the elevator at particular floor
     - _floorButton_    : Object of the Floorbutton class
     - _elevatorButton_ : Object of the Elevatorbutton class
     - _param_          :  Object of the Buttonparam class
     - _startElevator_  : Starts the elevator 
     - _addToElevator_  : Adds people which are waiting at particular floor to the elevator ,when elevator reaches that floor 
     - _removeFromElevator_ : Removes people from the elevator when elevator reaches that floor which matches with the                                       people's destination 
 -  **MachineRoomElevator** 
     - _elevatorList_   :Representing the people who have currently boarded the elevator
     - _floor()_        :Sets the next floor of elevator based on the which indicator is on floorButton or elevatorButton
     - _totalWeight()_  :Helper function to calculate the total weight of people who are boarding the elevator 
 -  **ElevatorList**
    - _destination_ :Person's destination floor 
    - _weight_      :Person's weight who have boarded the elevator 
    - _floor_       :Floor at which the person boarded the elevator
 -  **People**
    - _source_      :Floor at which the person will boarded the elevator  
    - _destination_ :Floor at which the person will exit the elevator
    - _weight_      :Person's weight who will board the elevator 
    - _addPeopleToQueue()_ :Add people to the queue who are waiting for the elevator
 -  **ElevatorPeople**
    - Subclass of People
 -  **ElevatorController**
    - This is the main class which creates and manages both the threads 
    - _people_      :Object of the People class
    - _elevator_    :Object of the Elevator class
 
 ## Run:
 -   As ElevatorController is the main class ,after downlaoding you just need to run ElevatorController.
