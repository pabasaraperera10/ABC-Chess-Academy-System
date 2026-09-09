# ABC Chess Academy System

A menu-driven, console-based Java application for managing chess academy players and tournaments, with admin login and file-based data storage.

## About the Project

ABC Chess Academy System is a console application that allows an academy administrator to log in and manage player registrations and tournaments through a simple text-menu interface. Player and tournament records are stored in local text files (`data.txt` and `tournaments.txt`).

## Features

- Admin login screen with username/password authentication
- Add new player (registration number, name, date of birth, rating)
- Display all registered players
- Search for a player by registration number
- Add new tournament (name, date, location)
- Display all tournaments
- Search for a tournament by name
- Built-in help menu describing each option
- Logout with confirmation prompt
- Date of birth and tournament date validated in DD/MM/YYYY format
- Player and tournament data persisted to text files

## Tech Stack

- **Language:** Java
- **Storage:** Plain text files (`data.txt`, `tournaments.txt`)
- **IDE:** NetBeans

## How It Works

1. On launch, the user is shown a login screen (username/password).
2. After a successful login, the admin menu appears with options to manage players and tournaments.
3. Player records are appended to `data.txt` as comma-separated values: `RegNo,FirstName,LastName,DOB,Rating`.
4. Tournament records are appended to `tournaments.txt` as comma-separated values: `Name,Date,Location`.
5. Search options scan the relevant file line by line for a match.
6. Logging out returns to the login screen; exiting closes the program.

## Getting Started

```bash
Clone the repository
git clone https://github.com/pabasaraperera10/abc-chess-academy-system.git

Navigate to the project directory
cd abc-chess-academy-system

Open the project in NetBeans (or compile manually)
javac com/mycompany/chessacademy_system/ChessAcademy_System.java

Run the application
java com.mycompany.chessacademy_system.ChessAcademy_System
```

## Status

Developed as a menu-driven Java console application project for academic coursework.

## Author

**Pabasara Sewwandi**
GitHub: [@pabasaraperera10](https://github.com/pabasaraperera10)
