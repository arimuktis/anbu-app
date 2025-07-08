# 📦 Anbu App

> Short summary: A Ktor-based backend API server using MongoDB with coroutine support and Koin for DI.

---

## 📖 Table of Contents

- [What is this repository for?](#what-is-this-repository-for)
- [Setup](#setup)
- [Configuration](#configuration)
- [Dependencies](#dependencies)
- [Database](#database)
- [How to Run](#how-to-run)
- [Testing](#testing)
- [Deployment](#deployment)
- [Contribution Guidelines](#contribution-guidelines)
- [Contact](#contact)

---

## 🤔 What is this repository for?

- Kotlin backend service using [Ktor](https://ktor.io/)
- MongoDB with official coroutine driver
- Koin for dependency injection
- RESTful API for user management and authentication

---

## ⚙️ Setup

### Prerequisites

- JDK 17 or newer
- Gradle 8 or higher
- MongoDB instance (local or [Atlas](https://www.mongodb.com/cloud/atlas))
- Internet for dependency resolution

### Clone the repo

```bash
git clone https://your-repo-url.git
cd your-repo

# For dev
cp .env.dev .env && ./gradlew run

# For staging
cp .env.staging .env && ./gradlew run

# For beta
cp .env.beta .env && ./gradlew run