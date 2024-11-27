
# **Multithreaded Web Server**

## **Introduction**
This project implements a multithreaded web server capable of handling multiple concurrent client requests efficiently. It leverages thread pools to manage resources effectively and demonstrates key concepts such as client-server communication, TCP sockets, and multithreading.

---

## **Features**
- **Multithreaded Server**: Handles multiple client requests simultaneously.
- **Thread Pool Implementation**: Optimizes server performance by reusing threads.
- **TCP Communication**: Ensures reliable data transfer between the client and server.
- **Scalable Design**: Supports concurrent connections with controlled resource usage.
- **Client Simulation**: Generates multiple client requests to test server performance.

---

## **Concepts Covered**

### **1. Client-Server Architecture**
- The server listens on a specified port and handles incoming requests from multiple clients.
- The client establishes a connection to the server, sends a request, and receives a response.

### **2. TCP Communication**
- Uses **TCP** for reliable, ordered, and error-checked communication.
- Demonstrates the TCP three-way handshake for establishing a connection.

### **3. HTTP Simulation**
- Implements basic server responses similar to HTTP protocols.
- Simulates the behavior of HTTP 1.0 (non-persistent) and HTTP 1.1 (persistent) connections.

### **4. Sockets**
- Utilizes Java's `Socket` and `ServerSocket` classes for network communication.
- Demonstrates socket operations: opening, listening, accepting, reading, and writing.

### **5. Multithreaded Design**
- Processes each client request in a separate thread.
- Uses `ExecutorService` to manage threads efficiently via a thread pool.

---

## **Code Structure**

### **Server**
The server code:
- Listens for incoming connections on a specified port (default: `8010`).
- Uses a thread pool to process each client request concurrently.
- Responds to each client with a greeting message.

### **Client**
The client code:
- Simulates multiple clients using a thread pool.
- Each thread represents a client connecting to the server, sending a request, and receiving a response.

---

## **Usage**

### **1. Prerequisites**
- Java Development Kit (JDK) installed (version 8 or higher).
- Basic understanding of Java and networking concepts.

### **2. Running the Server**
1. Compile the `Server.java` file:
   ```bash
   javac Server.java
   ```
2. Run the server:
   ```bash
   java Server
   ```
3. The server will start listening for connections on port `8010`.

### **3. Running the Client**
1. Compile the `Client.java` file:
   ```bash
   javac Client.java
   ```
2. Run the client:
   ```bash
   java Client
   ```
3. The client will simulate multiple requests to the server.

---

## **How It Works**

### **Server Workflow**
1. Listens on a specified port for incoming client connections.
2. Accepts client connections and assigns each to a thread from the thread pool.
3. Processes the client request and sends a response.
4. Closes the client connection after communication.

### **Client Workflow**
1. Establishes a connection to the server.
2. Sends a request to the server.
3. Waits for and processes the server's response.
4. Closes the connection.

---

## **Advantages of Multithreaded Servers**
- **Concurrency**: Handles multiple clients simultaneously without blocking.
- **Efficiency**: Reuses threads from a thread pool, reducing overhead.
- **Scalability**: Supports a large number of concurrent connections.

---

## **Performance Testing**
You can test the server's performance by adjusting the following:
- Number of client threads in the `Client` class.
- Size of the thread pool in the `Server` class.

Example:
- Increase `numberOfClients` in the client to simulate a higher load.
- Change `poolSize` in the server to observe resource management under varying loads.

---


## **Conclusion**
This project demonstrates a scalable and efficient multithreaded web server design. It provides hands-on experience with networking, sockets, and multithreading in Java. Thread pools ensure optimal resource utilization, making this implementation suitable for real-world applications.

