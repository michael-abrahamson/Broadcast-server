# Broadcast-Server (Java)

This is an introductory project from the roadmap.sh Backend Developer Roadmap focused on practicing core Java fundamentals.

The goal of this project was to reinforce:

- Public classes and class structure
- Constructors
- Server/client interactions
- Socket coding -> java.net

---

## How to clone

    git clone https://github.com/michael-abrahamson/Broadcast-server

## How to Run

If you are using the included Makefile, you will need at least three terminals open

Once you launch all terminals, read below for the available commands and follow the Command Line prompts

Server Terminal:

    make server

Client Terminal1:

    make client

Client terminal2:

    make client:

### Server Commands:

    CLOSE:
        - Closes all client, server sockets and safely kills the session

    USERS:
        - Prints all users currently connected to the server

    TEST
        - This method sends a broadcast to all users. This method was purely to speed up testing

### Client Commands

    EXIT
        - closes client socket and gracefully shuts down session

---

## Project Links

GitHub Repository:
[https://github.com/michael-abrahamson/expenseTracker](https://github.com/michael-abrahamson/Broadcast-server)

Project Specification (roadmap.sh):
https://roadmap.sh/projects/broadcast-server

---