# 🕷️ Parallel Web Crawler

A high-performance multithreaded web crawler built in Java using the Fork/Join framework, designed to efficiently crawl web pages, analyze textual content, and profile execution performance.

This project demonstrates advanced backend engineering concepts including:

- Concurrent Programming
- Parallel Processing
- Functional Programming
- Dynamic Proxies
- Reflection
- Dependency Injection
- Performance Profiling
- JSON Processing

---

# 🚀 Overview

The crawler begins from a set of seed URLs, recursively visits linked pages, extracts textual content, computes popular word frequencies, and generates crawl statistics.

The system was engineered to replace a traditional sequential crawler with a scalable parallel implementation optimized for multi-core architectures.

Additionally, the project includes a custom-built runtime profiler capable of measuring method execution times using Java Dynamic Proxies and Reflection APIs.

---

# ✨ Features

## ⚡ Parallel Web Crawling
- Multithreaded crawling using `ForkJoinPool`
- Recursive parallel task execution
- Concurrent URL processing
- Efficient workload distribution across CPU cores

## 📊 Word Frequency Analysis
- Extracts and counts popular words
- Functional programming implementation using Java Streams
- Custom ranking and sorting logic

## 🧠 Configurable Crawl Engine
Supports configurable:
- Crawl depth
- Timeout duration
- Parallelism level
- Ignored URLs
- Ignored words
- Output destinations

## 📈 Performance Profiling
- Custom runtime profiler
- Method execution tracking
- Dynamic proxy interception
- Thread-safe profiling system

## 🗂️ JSON Input / Output
- Jackson-based serialization/deserialization
- Configurable crawl result export
- JSON configuration support

---

# 🏗️ System Architecture

```text
Seed URLs
    │
    ▼
Parallel Crawl Tasks
    │
    ▼
Page Parsing & Link Extraction
    │
    ▼
Concurrent Word Aggregation
    │
    ▼
Result Processing
    │
 ┌──┴───────────────┐
 ▼                  ▼
JSON Output     Performance Profile
```

---

# 🧵 Concurrency Design

The crawler uses:

- `ForkJoinPool`
- Recursive parallel tasks
- Concurrent collections
- Thread-safe synchronization mechanisms

Each task:
1. Downloads and parses a web page
2. Extracts words and hyperlinks
3. Spawns additional crawl subtasks
4. Aggregates results concurrently

This enables significantly improved throughput compared to sequential crawling.

---

# 🧠 Core Concepts Implemented

## Parallel Computing
Implemented recursive multithreaded crawling using Java’s `ForkJoinPool`.

## Functional Programming
Used Java Stream API, lambdas, and collectors for functional-style data processing.

## Dynamic Proxies & Reflection
Built a lightweight profiling framework using:
- Java Reflection
- Dynamic Proxies
- Method Interceptors

## Dependency Injection
Integrated Google Guice for modular and extensible architecture.

---

# 🛠️ Tech Stack

## Language
- Java 17

## Build Tool
- Maven

## Libraries & Frameworks
- Jackson
- Guice
- Jsoup
- JUnit 5

## Concepts
- Multithreading
- Concurrency
- Functional Programming
- Runtime Profiling
- Recursive Algorithms

---

# 📂 Project Structure

```text
parallel-web-crawler/
│
├── src/main/java/com/udacity/webcrawler/
│   ├── json/
│   ├── parser/
│   ├── profiler/
│   ├── main/
│   └── ...
│
├── src/main/config/
├── target/
├── pom.xml
└── README.md
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/yourusername/parallel-web-crawler.git
cd parallel-web-crawler
```

---

## 2️⃣ Build Project

```bash
mvn clean install
```

---

## 3️⃣ Run Tests

```bash
mvn test
```

---

## 4️⃣ Run Sequential Crawler

```bash
java -classpath target/udacity-webcrawler-1.0.jar \
com.udacity.webcrawler.main.WebCrawlerMain \
src/main/config/sample_config_sequential.json
```

---

## 5️⃣ Run Parallel Crawler

```bash
java -classpath target/udacity-webcrawler-1.0.jar \
com.udacity.webcrawler.main.WebCrawlerMain \
src/main/config/sample_config.json
```

---

# 📄 Example Configuration

```json
{
  "startPages": ["http://example.com"],
  "parallelism": 8,
  "maxDepth": 5,
  "timeoutSeconds": 10,
  "popularWordCount": 10,
  "resultPath": "crawlResults.json"
}
```

---

# 📊 Example Output

```json
{
  "wordCounts": {
    "java": 54,
    "crawler": 32,
    "parallel": 27
  },
  "urlsVisited": 120
}
```

---

# 📈 Performance Optimization

The parallel implementation improves crawler throughput by:

- Utilizing multiple CPU cores
- Executing recursive tasks concurrently
- Reducing blocking wait time
- Using efficient concurrent data structures

---

# 🧪 Testing

The project includes:
- Unit tests
- Concurrency validation
- Functional correctness testing
- Profiler testing

Run all tests:

```bash
mvn test
```

---

# 🔐 Engineering Challenges Solved

- Preventing duplicate URL visits in concurrent environments
- Maintaining thread-safe word aggregation
- Efficient recursive parallel execution
- Designing a lightweight runtime profiler
- Synchronization without excessive locking

---

# 📚 Learning Outcomes

This project strengthened understanding of:

- Java concurrency
- Parallel algorithms
- Thread synchronization
- Functional programming
- Runtime method interception
- Scalable backend system design
- Performance analysis

---

# 👨‍💻 Author

## Akhil

Passionate about:
- Concurrent Systems
- Backend Engineering
- Distributed Computing
- Performance Optimization
- Scalable Software Architecture

---

# ⭐ If you like this project

Consider giving it a ⭐ on GitHub!
