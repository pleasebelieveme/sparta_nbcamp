![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=250&section=header&text=일정관리%20Project&fontSize=80)

## 🤔 개요
- 이 프로젝트는 스프링으로 CRUD를 구현한 Java 애플리케이션입니다. 

##  🌳 개발환경
- ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)
 언어: Java

- ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)
JDK 버전: 17

- ![Static Badge](https://img.shields.io/badge/SpringBoot-green?style=flat-square)
프레임워크: Spring Boot 3.4.4

- ![Static Badge](https://img.shields.io/badge/MySQL-blue?style=flat-square)
DB: MySQL 8

## ⏱️ 개발기간
- 2025-03-23 ~ 2025-03-26(4일)


## 🔠 목차  

## 🔠 목차  

1. [📄 API 명세서](#-api-명세서)
2. [💿 ERD](#-erd)
3. [🌊 3leyerd-architecture-및-데이터-흐름](#-3leyerd-architecture-및-데이터-흐름)
4. [❓ 패키지 설명](#-패키지-설명)
5. [▶️ 실행방법](#️-실행방법)
6. [🛠 기능 요약](#-기능-요약)
7. [📂 디렉토리 구조](#-디렉토리-구조)



# 📄 API 명세서
<img width="737" alt="스크린샷 2025-03-26 오후 4 36 05" src="https://github.com/user-attachments/assets/cf9cad1c-edce-4f2f-a474-7b36e2f1fb24" />

# 💿 ERD
<img width="592" alt="스크린샷 2025-03-25 오후 8 23 42" src="https://github.com/user-attachments/assets/f3f75a6f-c7cd-4b7c-87e0-0aaaad1b33a4" />

# 🌊 3Leyerd Architecture 및 데이터 흐름
<img width="686" alt="스크린샷 2025-03-26 오후 1 09 57" src="https://github.com/user-attachments/assets/652d5c76-bf1b-4fc8-87ad-e27bf615d0c0" />


# ❓ 패키지 설명
## 1. Entity(Schedule.java, Member.java)
- DB와 동일한 환경을 구성한 Entity 클래스입니다.

 ## 2. Dto
- Entity를 기반으로 실제 데이터가 이동될때 사용되는 클래스입니다.
- Request와 Response로 나뉩니다.
  
 ## 3. Controller
- 사용자에게 요청을 받고 결과값을 넘겨주는 역할을 하는 클래스입니다.
- 요청받은 데이터를 Service에 넘겨주고 데이터를 전달받습니다.
  
 ## 4. Service
- DB에 조회하기 전과 후에 비즈니스 로직을 작성하는 클래스입니다.
- 요청을 가공하여 Repository에 넘겨주고 전달받습니다.

 ## 5. Repository

- SQL문을 작성하여 DB에 조회하는 클래스입니다.
- JdbcTemplate를 사용하여 MySQL에 조회하고 데이터를 전달받습니다.

# ▶️ 실행방법

1. src.main.java.org.example.schedule.ScheduleApplication.java 파일을 열어 Spring Boot를 실행시킵니다.
2. start된 걸 확인한 후 Postman을 통해 검증합니다.

# 🛠 기능 요약

- 일정 생성: 일정을 생성합니다.

- 일정 전체 조회: DB에 저장된 일정을 모두 출력합니다.

- 일정 단일 조회: 사용자의 id를 통해 일정을 1개 출력합니다.

- 일정 수정: 사용자의 id를 통해 일정을 수정합니다.

- 일정 삭제: 사용자의 id를 통해 일정을 삭제합니다.

# 📂 디렉토리 구조  
```java
└── src
    └── main
        └── java
            └── org
                └── example
                    └── schedule
                        ├── ScheduleApplication.java
                        ├── controller
                        │   └── ScheduleController.java
                        ├── dto
                        │   ├── MemberRequestDto.java
                        │   ├── MemberResponseDto.java
                        │   ├── ScheduleRequestDto.java
                        │   └── ScheduleResponseDto.java
                        ├── entity
                        │   ├── Member.java
                        │   └── Schedule.java
                        ├── repository
                        │   ├── JdbcTemplateScheduleRepository.java
                        │   └── ScheduleRepository.java
                        └── service
                            ├── ScheduleService.java
                            └── ScheduleServiceImpl.java
```
