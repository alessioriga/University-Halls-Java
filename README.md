# University Hall Management System - Java

![Java](https://img.shields.io/badge/Java-17+-red)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![OOP](https://img.shields.io/badge/Programming-OOP-green)
![Serialization](https://img.shields.io/badge/Data-Serialization-orange)
![Licence](https://img.shields.io/badge/Licence-MIT-lightgrey)

A **Java-based desktop application** that simulates a university hall management system, allowing users to manage students and employees, assign halls, and store resident data through an interactive graphical interface.

## Overview

This project demonstrates the use of **Object-Oriented Programming (OOP)**, **Java Swing GUI development**, and **file serialization** to create a university hall management system.

The application allows users to:

- Add students and employees
- Assign halls automatically
- Store resident information
- Save and load data from file
- View records through a GUI

The system is designed to be simple, structured, and easy to use.

## Key Features

- **Student Management:** Add students with course, year, diet, and payment details
- **Employee Management:** Add staff members with role and salary
- **Hall Assignment:** Automatic hall allocation based on diet and ground floor requirement
- **Record Navigation:** View residents using next record functionality
- **File Saving:** Save residents using serialisation

## Technology Stack

- **Language:** Java
- **GUI:** Java Swing
- **Programming Style:** Object-Oriented Programming (OOP)
- **Data Storage:** Java Serialization
- **Version Control:** GitHub

## Project Structure

```
University-Hall-Java/
│
├── ucen/
│ └── uk/
│ └── alessiouniversityhall/
│       ├── AlessioUniversityHallApp.java
│       ├── AlessioUniGUI.java
│       ├── Store.java
│       ├── Person.java
│       ├── Student.java
│       ├── Employee.java
│       ├── Hall.java
│       └── Payment.java
│ 
├── residents.txt
└── README.md
```

## Installation
### Prerequisites

- Java JDK 17+
- IntelliJ IDEA or Apache NetBeans
- Git

### Steps

1. **Clone the repository**

```bash
git clone https://github.com/alessioriga/University-Halls-Java
```
2. **Open the project**

- Open IntelliJ IDEA or Apache NetBeans
- Click Open Project
- Select the project folder

3. **Run the application**

Run:
```powershell
MainApp.java
```
The University Hall GUI will open.

## How to Use

1. Select Student or Employee
2. Fill in the form
3. Click Enter Person
4. Click Next Record to view residents
5. Click Save File to save data
6. Click Load File to load data
7. Click Clear to reset the form

## Hall Allocation Logic

| Condition             | Hall               |
|-----------------------|--------------------|
| Ground Floor selected | Ground Hall        |
| Vegan or Vegetarian   | VVG Hall           |
| Halal                 | Halal Hall         |
| Default               | Main Hall          |
| Employee              | Staff Hall         |

## File Storage

Residents are saved in:

```powershell
residents.txt
```
using Java serialisation.

## Future Improvements

- Improve modularity of the code
- Add edit and delete resident functionality

## Licence

This project is licensed under the MIT Licence.
