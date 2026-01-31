Steps to follow while coding in Machine Coding round:
-----------------------------------------------------

# Parking Lot Design & Architecture Notes

## I. Initial Design & Workflow

* 
**1.** Gather all requirements before starting any other process.


* 
**2.** Once requirements are gathered, begin coding models by creating a class for every entry in the class diagram.


* 
**3.** Initially, leave out all attributes for each class.


* 
**4.** Add attributes only after all empty classes from the class diagram have been created.


* 
**5.** Work through requirements one by one.


* 
**6.** Ensure one requirement is completely finished before moving to the next.



## II. Data Modeling & Data Types

* 
**7.** All classes should extend a `baseModel` or `Audit` class containing `id`, `createdAt`, `updatedAt`, and `isDeleted`.


* **8.** **Floating Point Values:**
* 
`float` occupies 4 bytes and ranges from  to .


* It stores approximate values rather than actual values.


* It is not recommended for application use, especially in financial systems.




* 
**9.** **Integer Values:** `int` occupies 4 bytes with a range from  to  ().


* 
**10.** Create objects using default constructors followed by getters/setters to ensure adding new parameters later does not break existing calls.


* 
**11.** Builders are generally only necessary for client-end applications.



## III. Package Structure & Strategy Pattern

* 
**12.** Organize code into different packages or separate repositories so that changing a database only requires rewriting an interface implementation.


* 
**13.** Create packages for **strategies** (e.g., parking algorithms) and **adapters** (e.g., PaymentGateways).


* 
**14.** Define interfaces for these strategies.


* 
**15.** It is acceptable if method parameters for these strategies are not fully known until later in development.



## IV. The Controller-Service-Repository Pattern

* **16. The Interaction Metaphor:**
* 
**Client (Customer)** interacts with the **Controller (Waiter)**.


* 
**Services (Chefs)** handle the core logic.


* 
**Models** represent the data.




* **17. Controller Naming & Responsibilities:**
* Name controllers based on the entity they affect or perform CRUD operations on.


* 
*Example:* Use `UserController` or `AuthController` instead of just `LoginController`.


* Controllers are responsible for Data Validations and Request Validations.


* Controllers pass requests to the service layer where business logic resides.




* **18. DTO (Data Transfer Object) Usage:**
* Use DTOs for communication between the client and the controller.


* Never return internal models directly to the client; use DTOs to send only necessary data.


* **Controller Flow:**
1. Receive a **request DTO**.


2. Extract attributes from the DTO.


3. Call services using those attributes.


4. Receive the return value from the service.


5. Create a **response DTO**.


6. Return the DTO to the client.






* **19. Service Layer Rules:**
* Services should **never** take or return DTOs.


* Services use **Models** or internal business objects because they are generic and can be used by multiple controllers.




* **20. Request Safety:**
* Controller methods should take DTOs as parameters rather than raw values to prevent breaking client integrations when fields are added later.


* The UI should only send essential data (e.g., `VehicleNumber`, `GateID`); internal systems should handle `entryTime` and `operator` data.





## V. Dependency Injection & Logic

* 
**21.** A class should never create its own dependencies; dependent objects must always be **injected**.


* 
**22.** Use `Optional` to help reduce **NullPointerExceptions**.



## VI. In-Memory Mocking & Initialization

* **23. Mocking Databases:**
* Use a `Map<Id, Model>` (e.g., `Map<Long, Gate>`) when simulating a database in memory.


* Simulate indexes using maps of IDs or attributes (e.g., `Map<OperatorId, Gate>`).


* Use `TreeMap` instead of `HashMap` if you need to support range queries.




* **24. The Main Class:**
* The `Main` class should only be used to initialize repositories and controllers.


* Objects are created at runtime via command line or REST endpoints.


* Create objects in a **topological order**: Strategies and Repositories first, then Services, then Controllers.


* Modern frameworks typically handle this topological dependency injection automatically.





---

### External References

* 
**Query Models Example:** [Listmonk queries.go](https://github.com/knadh/listmonk/blob/master/models/queries.go) 


* 
**Google Null Pointer Fix:** [Abseil Tip #123](https://abseil.io/tips/123) 


* 
**Google Java Style Guide:** [Java Guide](https://google.github.io/styleguide/javaguide.html) 



Would you like me to generate a **Mermaid.js sequence diagram** to visualize the request flow between the Controller, Service, and Repository?
