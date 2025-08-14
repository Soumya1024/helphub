# HelpHub – Community Assistance Platform

HelpHub is a full-stack platform that allows users to create, search, filter, and bookmark community help requests.  
Built with **Java Spring Boot** (backend) and **React.js** (frontend), with **MySQL** for database management.

---

## 🚀 Features
- **User Authentication** – Secure JWT-based authentication.
- **Post Management** – Create, update, delete, search, and filter posts.
- **Bookmarking** – Save posts for later viewing.
- **Search & Filter** – Search by title, category, and date range with pagination & sorting.
- **Scalable Architecture** – Spring Boot layered architecture with DTOs, mappers, and services.

---

## 🛠 Tech Stack
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Frontend:** React.js
- **Database:** MySQL
- **Tools:** Git, Postman, IntelliJ IDEA

---

## 📂 Project Structure
helphub-backend/
├── src/main/java/...        # Java source code
├── src/main/resources/      # Config files & static resources
├── pom.xml                   # Maven dependencies
└── README.md                 # Documentation

---

## ⚙️ How to Run the Backend
1. Clone the repository:
   git clone https://github.com/Soumya1024/helphub.git
   cd helphub-backend

2. Copy the example properties file:
   cp src/main/resources/application-example.properties src/main/resources/application.properties

3. Update application.properties with your MySQL username/password.

4. Start the backend:
   mvn spring-boot:run

---

## 📄 Example Configuration (application-example.properties)
spring.datasource.url=jdbc:mysql://localhost:3306/helphub
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
jwt.secret=YOUR_SECRET_KEY
jwt.expiration=86400000

---

## 📌 Author
Soumya Ranjan Pradhan  
📧 pradhansoumya2003@gmail.com | 🌐 LinkedIn: https://www.linkedin.com/in/soumya-ranjan-pradhan-04275330a

---

### 📢 What this README does:
- Shows recruiters the **project purpose** and **tech stack** at a glance.
- Gives **clear steps** to run the backend locally.
- Protects your real DB credentials by using `application-example.properties`.
