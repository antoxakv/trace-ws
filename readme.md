Requirements for launch: Java 11.0.2+ and unused port 8080.

1. Execute command `gradlew build` in terminal.
2. Command for launch project `java -jar ./build/libs/trace-ws-1.0-SNAPSHOT.jar`.
3. Use url <ws://localhost:8080:/subscription> for connect to server.
4. Send any text message to the server and response will contain random number.