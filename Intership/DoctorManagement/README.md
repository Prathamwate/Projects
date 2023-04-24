## Suggesting Doctor Based On 💉Symptoms API :-
### Frameworks and Language used:
* Spring
* Spring boot
* Java
### Data Flow
* Controller : 
  * In this Application am used 2 controller
    * DoctorController
    * PatientController
* Service
  * In this Application am used 2Service
    * DoctorSerivce
    * PatientServoce
* Repository
  * In this Application am used 4 Repository
    * IDoctorepository
    * IPatientRepository
    * ISympyomRepository
    * ISpeclityRepository
    * StatusRepository
 * Utils
    * DoctorUtil.java
    * PatientUtil.java
    * Validate.java

* Database
33
  * I used Myslq Database In this Application.

* Summary :
   * Adding a Doctor: We need to create an endpoint that can accept doctor information and save it in the database. We can use Spring Data JPA to handle the database operations. We can also validate the doctor's name, city, email, phone number, and speciality before saving the data.
   * Adding a Patient & its Symptom: We need to create an endpoint that can accept patient information and its symptoms and save them in the database. We can also validate the patient's name, city, email, phone number, and symptom before saving the data.
   * Suggesting a Doctor based on Patient's Symptom: We need to create an endpoint that can accept patient ID and return the list of doctors based on the patient's location and symptom. We can use Spring Data JPA to retrieve the patient information and then use the information to retrieve the list of doctors based on the patient's location and symptom. We can also use Spring's validation framework to validate the input data.
   * Overall, the application aims to provide patients with a user-friendly and efficient way to find the right doctors to treat their medical conditions, ultimately improving their healthcare outcomes.
* OutPut :
   *![image](https://user-images.githubusercontent.com/98683881/234004673-db2016b7-ec4f-4e32-b2e9-aa3116be5cd2.png)
