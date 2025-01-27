# Movies

![State](https://img.shields.io/badge/kotlin-v1.9.20-blueviolet)
![State](https://img.shields.io/badge/gradle-v8.1.0-blue)
![State](https://img.shields.io/badge/Detekt-passing-brightgreen)
![State](https://img.shields.io/badge/UnitTest-incomplete-red)

## 🚧 👷🏗️  Under Modifications  🔨👷 🚧

# Table of Contents

1. [Description](#description)
   1. [Screenshots](#screenshots)
   2. [Flowchart](#flowchart)
   3. [Skills you may find](#skills-you-may-find)
   4. [Design Patterns implemented](#design-patterns-implemented)
   5. [Domain model](#domain-model)
   6. [Architecture](#architecture)
2. [Resources](#resources)
3. [Community](#community)
4. [Additional Android Samples](#additional-android-samples)

# Description

This is a sample project with the main objective of integrating [Jetpack components](https://developer.android.com/jetpack) 
as much as possible in a single app.  
Additionally, the project try to implement ideas from Domain-Drive Design, Design Patterns, and 
Clean Architecture mainly focused on the Dependency Inversion principle.  


The app topic is Movies and you may find functionalities such as: 
* search movies by name. 
* see the movie extra details. 


## Jetpack components map
Legend:  
🟩 Implemented in the app.  
🟨 Implementing (WIP).  
⬜ Not yet implemented.

![Default Screen](diagrams/jetpack-mindmap.png)

## Screenshots

![Default Screen](screenshots/default.png "Default Screen")
![Search Screen](screenshots/searching.png "Search Screen")
![Detail Screen](screenshots/detail.png "Detail Screen")
![Menu Screen](screenshots/menu.png "Menu Screen")


## Flowchart

```mermaid
graph LR
A[Navigation Drawer] --> B[Find Movie Screen]
A --> G
B -- input search --> C{Any Result?}
C -- Yes --> D[Listing Movies Screen]
C -- No --> E[Empty Screen]
D -- select --> F[Detail Screen]
F -- add to favorites --> F
G[Favorite Screen]
```

## Skills you may find

| Jetpack       | Kotlin & Quality    | Dependency Management | Others        | Testing           |
|---------------|---------------------|-----------------------|---------------|-------------------|
| `Compose`     | `Coroutines`        | `Version Catalogs`    | `Landscapist` | `MockK`           |
| `WorkManager` | `Asynchronous Flow` | `TOML`                | `Material 3`  | `ComposeTestRule` |
| `Hilt`        | `Detekt`            | `Gradle Kotlin DSL`   | `Retrofit`    |                   |
| `Room`        | `Ktlint`            |                       | `OkHttp`      |                   |
| `Paging`      |                     |                       | `Timber`      |                   |
| `Navigation`  |                     |                       | `Lottie`      |                   |

## Design Patterns implemented

| Creational | Structural | Behavioral              |
|------------|------------|-------------------------|
| Singleton  | Facade     | Command                 |
|            |            | Chain of Responsibility |
|            |            | State                   |

## Domain Model
The Domain Model pattern is shown here in a very simple way.   
This project is trying to follow the ideas explained in [Domain-Driven Design book of Eric Evans](https://a.co/d/hnmkp9y).  

