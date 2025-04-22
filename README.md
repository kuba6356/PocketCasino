A Java-based casino simulator featuring Blackjack, Roulette, and Crash with a comprehensive test suite.

Limitations
Due to the use of java.util.Scanner while playing remember to:
-only type what's on the screen 
-never press Enter key before typing anything while playing Crash
-Always use "," instead of "." when typing in a decimal amount
otherwise it can and probably will result in a crash

🎮 Features

✅ Three Casino Games:

    Blackjack (Hit/Stand, Dealer AI, Payouts)

    Roulette (Number/Color Betting, 36:1 & 2:1 Payouts)

    Crash (Multiplier Game with Cashout Timing)

✅ Player Economy:

    Start with $500 balance

    Betting system with balance tracking

✅ Leaderboard:

    Tracks top 10 players

    Persistent storage using JSON

✅ Multi-threading:

    Smooth real-time multiplier updates in Crash

✅ Comprehensive Testing:

    Unit tests for all major components

    Input validation testing

    Game logic verification

🧪 Testing Strategy
Test Coverage

The application includes JUnit 5 tests for:

    Game Logic (Blackjack, Roulette, Crash)

    Money Management

    Leaderboard Functionality

    User Input Handling

    Multi-threading Operations

    🕹️ How to Play

    Launch the game (Run App.java)

    Place bets (Minimum bet: $0.01)

    Play any game:

        Blackjack: Beat the dealer without busting

        Roulette: Bet on numbers or colors

        Crash: Cash out before the game crashes!

    Quit to save your score to the leaderboard

⚙️ Installation
Prerequisites:

    Java 17+

    Maven

Steps:
bash

git clone https://github.com/yourusername/casino-games-simulator.git
cd casino-games-simulator
mvn package
java -jar target/casino-games.jar

🛠️ Technologies Used

    Java 17

    JUnit 5 (Testing)

    JSON (Leaderboard Storage)

    Maven (Build Tool)

    Multi-threading (Crash Game)

📂 Project Structure

src/
├── main/java/org/example/
│   ├── coreLogic/       # Money system
│   ├── games/           # Game implementations
│   ├── menu/            # UI & Leaderboard
│   └── App.java         # Entry point
├── test/java/org/example/
│   ├── games/           # Game tests
│   ├── menu/            # Leaderboard tests
│   └── coreLogic/       # Money tests
└── pom.xml              # Maven config

📌 TODO
-Add a frontend
-Swapout scanners for gui
-add a DB storage
