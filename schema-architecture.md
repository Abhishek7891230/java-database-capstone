This Spring Boot application uses both MVC and REST controllers. Thymeleaf templates are used for the Admin and Doctor dashboards, while REST APIs serve all other modules. The application interacts with two databases—MySQL (for patient, doctor, appointment, and admin data) and MongoDB (for prescriptions). All controllers route requests through a common service layer, which in turn delegates to the appropriate repositories. MySQL uses JPA entities while MongoDB uses document models.

1. The user accesses the application via a web browser or API client, navigating to pages such as AdminDashboard or Appointment.
2. The request is routed to the appropriate Thymeleaf controller (for web pages) or REST controller (for API calls) based on the URL mapping.
3. The controller processes incoming data (if any) and calls the relevant service layer method to handle business logic.
4. The service layer coordinates operations, performing validations and invoking repository methods to interact with the database.
5. The repository layer uses Spring Data JPA to execute SQL queries against the MySQL database.
6. The database processes the queries, retrieves or updates the required data, and sends the results back to the repository layer.
7. The service layer formats the results, the controller returns the response, and the front-end (Thymeleaf templates or JSON) displays the final data to the user.
