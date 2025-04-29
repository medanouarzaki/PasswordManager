# Password Manager (Java CLI)

This is a basic but functional command-line password manager written in Java.  
You can use it to securely store and manage your login credentials for various services.

## ✨ Features

- Add accounts with service name, username, and password
- Prevent duplicate services (ask to replace)
- Optionally hide passwords when listing accounts
- Delete accounts by service name
- Save/load data from a text file (`accounts.txt`)
- Works entirely from the terminal — fast and lightweight

## 📦 Usage

Passwords are stored in a file named accounts.txt in the project root.

For full password masking (hidden while typing), run the app in a system terminal (not IntelliJ).

📁 Structure
Main.java: the app entry point and CLI menu

PasswordManager.java: handles logic and storage

Account.java: represents a single login account

🚀 Future Ideas
Encrypt stored passwords

Add search functionality

Export to JSON or CSV

GUI version (JavaFX or Swing)

👤 Author
Made by [Your Name] — built as a learning project to practice OOP, file I/O, and clean Java.
