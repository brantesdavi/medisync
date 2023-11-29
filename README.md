
<a name="readme-top"></a>

[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.svg" alt="Logo" width="200" height="200">
  </a>

  <h3 align="center">Medisyn API</h3>

  <p align="center">
    An awesome API for the Medisync application!
    <!-- <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br /> -->
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Requirements</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project


Medisync is a Spring Boot API designed for managing registrations of doctors, patients, and appointments. It uses the MySQL database and offers basic CRUD (Create, Read, Update, Delete) functionalities for each entity.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Requirements-->
## Requirements

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Dependencies

* Spring Boot
* Spring Data JPA
* Flyway (for databse migration)
* Lombok
* Maven


### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Clone the Repository
   ```sh
   git clone https://github.com/your_username/medisync.git
   ```
2. Configure the Database
   * Create a MySQL database named medisync.
   * Configure the database access credentials in the src/main/resources/application.properties file.
3. Run the Application
   ```sh
    mvn spring-boot:run
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Endpoints

The API provides the following endpoints:

* /doctors: CRUD for doctors.
* /patients: CRUD for patients.
* /appointments: CRUD for appointments.

## Examples

#Retrieving Doctors
```sh
  GET http://localhost:8080/doctors
```

Example Response
```js
  {
    "id": 9,
    "name": "Doctor ex",
    "email": "doctor@sync.med",
    "npi": "123453",
    "specialty": "CARDIOPEDIA"
  }
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Created CRUD for doctors
- [ ] Created CRUD for pacients and appointments

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Davi Brantes  - davi.brantes@gmail.com

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555


<p align="right">(<a href="#readme-top">back to top</a>)</p>



[linkedin-url]: https://www.linkedin.com/in/davi-brantes/
