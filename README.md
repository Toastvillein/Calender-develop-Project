# 일정 관리 앱 (숙련)
![header](https://capsule-render.vercel.app/api?type=transparent&color=auto&height=300&section=header&text=Calender%20Project&desc=Develop%20Adept&fontSize=70&fontColor=9C4998)


## 🤔 개요
- 이 앱은 이전에 구현한 CalenderProject의 심화 버전 웹 어플리케이션입니다. 회원가입과 로그인기능, 일정 CRUD, 댓글 CRUD등 여러 기능이 구현되어 있습니다.

## 🌳 개발환경 
언어 : ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)

JDK : ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)

프레임워크 : ![Static Badge](https://img.shields.io/badge/SpringBoot-%23FFFF00?logo=springboot)

DB : ![Static Badge](https://img.shields.io/badge/MySql-%23FFFFFF?style=flat&logo=mysql)

ORM : ![Static Badge](https://img.shields.io/badge/JPA-FFA500?style=flat)



## 🛠 기능 엿보기   

1. [📅 ERD  ](#-ERD)
2. [📘 통합 API 명세서](#-통합-API-명세서)
3. [❓ 패키지 설명](#-패키지-설명)
4. [ 🛠 기능 요약](#-기능-요약)
5. [ ✅ 디렉토리 구조](#-디렉토리-구조)
   


# 📅 ERD

![calender](https://github.com/user-attachments/assets/4f5f2585-80a0-4edb-90fd-5b09a6f95858)


# 📘 통합 API 명세서

| 구분 | 메서드 | URL | 요청 예시 | 응답 예시 | 
|------|--------|-----|------------|------------|
| 🔐 로그인 | POST | `/api/users/login` | `{ "email": "test@example.com", "password": "1234" }` | `200 OK` | 
| 📝 회원가입 | POST | `/api/users/signup` | `{ "username": "test", "email": "test@example.com", "password": "1234" }` | `201 Created`, `{ "id": 1, "username": "...", "email": "..." }` | 
| 👤 유저 조회 | GET | `/api/users/{id}` | - | `200 OK`, `{ "id": ..., "username": "...", "email": "..." }` |
| 👥 유저 전체 조회 | GET | `/api/users` | - | `200 OK`, `[ { "id": ..., "username": "...", ... }, ... ]` | 
| 🛠 유저 수정 | PATCH | `/api/users/{id}` | `{ "email": "...", "password": "..." }` | `200 OK` | 
| ❌ 유저 삭제 | DELETE | `/api/users/{id}` | `{ "password": "..." }` | `200 OK` | 
| 📅 캘린더 생성 | POST | `/api/calenders` | `{ "username": "...", "title": "...", "contents": "..." }` | `201 Created`, `{ "id": ..., "title": "...", ... }` | 
| 📄 캘린더 조회 | GET | `/api/calenders/{id}` | - | `200 OK`, `{ "id": ..., "title": "...", ... }` | 
| 📋 캘린더 목록 조회 | GET | `/api/calenders/pages?page=0&size=10` | - | `200 OK`, `Page<CalenderResponseDto>` | 
| ✏️ 캘린더 수정 | PATCH | `/api/calenders/{id}` | `{ "title": "...", "contents": "..." }` | `200 OK` | 
| 🗑️ 캘린더 삭제 | DELETE | `/api/calenders/{id}` | - | `200 OK` |
| 💭 댓글 생성 | POST | `/api/calenders/comments/{id}` | `{ "comments": "내용" }` | `201 Created`, `{ "comments": "..." }` | 
| 💬 댓글 조회 | GET | `/api/calenders/comments/{id}` | - | `200 OK`, `[ { "comments": "..." }, ... ]` | 
| ✏️ 댓글 수정 | PATCH | `/api/calenders/comments/{userId}` | `{ "id": 댓글ID, "comments": "수정 내용" }` | `200 OK` | 
| ❌ 댓글 삭제 | DELETE | `/api/calenders/comments/{userId}/{id}` | - | `200 OK` |




 # ❓ 패키지 설명
 ## 1. common
-  BCrypt 비밀번호 인코딩을 위해 문자열을 공통상수로 정의하기 위한 패키지

- 내부 Class: Const.Interface

## 2. config
- 비밀번호 암호화를 위한 클래스와 WebFilter를 등록하기 위한 클래스가 있는 패키지

- 내부 Class: WebConfig.Class , PasswordEncoder.Class

## 3. Controller
- 클라이언트의 요청을 처리하기 위한 컨트롤러가 모여있는 패키지
- 회원가입,로그인,유저 정보 변경, 유저 조회, 유저 삭제/ 일정생성, 조회, 수정, 삭제/ 댓글생성, 조회, 수정 ,삭제 등의 기능이 각 용도에 맞게 클래스로 나뉘어 작성되어 있다.

- 내부 Class: CalenderController.Class, CommentController.Class, UserController.Class

## 4. dto
- 클라이언트와 주고 받는 데이터 객체를 모아놓은 패키지

- request와 response로 패키지를 한번 더 나누고 필요에 따라 만든 모든 Dto를 종류별로 분류했다.

## 5. entity
- 일정,댓글,회원을 JPA에 의거하여 각 기능에 따라 클래스를 나누어 필요한 모든 속성을 초기화한 패키지

- 생성일자와 수정일자는 모든 기능에 포함되기에 따로 클래스를 만들어 상속시켰다.

- 내부 Class: BaseEntity.Class, User.Class, Calender.Class, Comment.Class

## 6. exception
- @ControllerAdvice로 모든 예외를 감시하며 이를 대처하기 위한 패키지

- 커스텀예외로 예외처리의 유연성을 높였다.

- 내부 Class: CalExceptionHandler.Class, CustomException.Class

## 7. filter
- config에 등록된 필터가 정의된 패키지. 로그인 없이 이용 가능한 기능 몇개를 제외하고 나머진 모두 로그인을 반드시 하게 만든다.

- 내부 Class: LoginFilter.Class

## 8. repository

- JpaRepository를 상속 받고 있는 DB에 접근하는 메서드가 포함된 클래스를 품고 있는 패키지

- 내부 Class: CalenderRepository.Interface, CommentRepository.Interface, UserRepository.Interface

## 9. service
- 모든 기능의 비지니스 로직이 포함된 클래스를 내포하고 있는 패키지

- 내부 Class: CalenderService,CommentService,UserService

# 🛠 기능 요약
|기능|설명|
|---|---|
|회원가입/로그인|	유저 정보 등록 및 세션 기반 로그인
|캘린더 생성|	제목과 내용을 포함한 캘린더 생성
|캘린더 수정/삭제|	등록된 캘린더 내용 수정 및 삭제
|댓글 등록/조회|	캘린더 별 댓글 작성 및 조회
|댓글 수정/삭제|	작성자 기반 댓글 수정 및 삭제

# ✅ 디렉토리 구조
```java
C:.
│  .gitattributes
│  .gitignore
│  build.gradle
│  Calender-develop 트러블슈팅.txt
│  gradlew
│  gradlew.bat
│  HELP.md
│  README.md
│  settings.gradle
│
├─.gradle
│  │  file-system.probe
│  │
│  ├─8.13
│  │  │  gc.properties
│  │  │
│  │  ├─checksums
│  │  │      checksums.lock
│  │  │      md5-checksums.bin
│  │  │      sha1-checksums.bin
│  │  │
│  │  ├─executionHistory
│  │  │      executionHistory.bin
│  │  │      executionHistory.lock
│  │  │
│  │  ├─expanded
│  │  ├─fileChanges
│  │  │      last-build.bin
│  │  │
│  │  ├─fileHashes
│  │  │      fileHashes.bin
│  │  │      fileHashes.lock
│  │  │      resourceHashesCache.bin
│  │  │
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  │      buildOutputCleanup.lock
│  │      cache.properties
│  │      outputFiles.bin
│  │
│  └─vcs-1
│          gc.properties
│
├─.idea
│  │  .gitignore
│  │  compiler.xml
│  │  dataSources.local.xml
│  │  dataSources.xml
│  │  gradle.xml
│  │  misc.xml
│  │  modules.xml
│  │  vcs.xml
│  │  workspace.xml
│  │
│  ├─dataSources
│  │  │  ee6e61ac-f7c8-4014-8a4f-4aaa139eff82.xml
│  │  │
│  │  └─ee6e61ac-f7c8-4014-8a4f-4aaa139eff82
│  │      └─storage_v2
│  │          └─_src_
│  │              └─schema
│  │                      calender.uvte9Q.meta
│  │                      calenderdev.GzZRGA.meta
│  │                      information_schema.FNRwLQ.meta
│  │                      mysql.osA4Bg.meta
│  │                      performance_schema.kIw0nw.meta
│  │                      sys.zb4BAA.meta
│  │
│  └─modules
│          Calender-develop.main.iml
│
├─build
│  ├─classes
│  │  └─java
│  │      └─main
│  │          └─com
│  │              └─example
│  │                  └─calenderdevelop
│  │                      │  CalenderDevelopApplication.class
│  │                      │
│  │                      ├─common
│  │                      │      Const.class
│  │                      │
│  │                      ├─config
│  │                      │      PasswordEncoder.class
│  │                      │      WebConfig.class
│  │                      │
│  │                      ├─controller
│  │                      │      CalenderController.class
│  │                      │      CommentController.class
│  │                      │      UserController.class
│  │                      │
│  │                      ├─dto
│  │                      │  ├─request
│  │                      │  │      CreateCalenderRequestDto.class
│  │                      │  │      CreateCommentRequestDto.class
│  │                      │  │      CreateUserRequestDto.class
│  │                      │  │      DeleteUserRequestDto.class
│  │                      │  │      LoginRequestDto.class
│  │                      │  │      UpdateCalenderRequestDto.class
│  │                      │  │      UpdateCommentRequestDto.class
│  │                      │  │      UpdateUserRequestDto.class
│  │                      │  │
│  │                      │  └─response
│  │                      │          CalenderResponseDto.class
│  │                      │          CommentResponseDto.class
│  │                      │          LoginResponseDto.class
│  │                      │          UserResponseDto.class
│  │                      │
│  │                      ├─entity
│  │                      │      BaseEntity.class
│  │                      │      Calender.class
│  │                      │      Comment.class
│  │                      │      User.class
│  │                      │
│  │                      ├─exception
│  │                      │      CalExceptionHandler.class
│  │                      │      CustomException.class
│  │                      │
│  │                      ├─filter
│  │                      │      LoginFilter.class
│  │                      │
│  │                      ├─repository
│  │                      │      CalenderRepository.class
│  │                      │      CommentRepository.class
│  │                      │      UserRepository.class
│  │                      │
│  │                      └─service
│  │                              CalenderService.class
│  │                              CalenderServiceImpl.class
│  │                              CommentService.class
│  │                              CommentServiceImpl.class
│  │                              UserService.class
│  │                              UserServiceImpl.class
│  │
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      └─main
│  │      └─headers
│  │          └─java
│  │              └─main
│  ├─resources
│  │  └─main
│  │      │  application.properties
│  │      │
│  │      ├─static
│  │      └─templates
│  │              home.html
│  │
│  └─tmp
│      └─compileJava
│          │  previous-compilation-data.bin
│          │
│          └─compileTransaction
│              ├─backup-dir
│              └─stash-dir
│                      CalenderController.class.uniqueId1
│                      CalenderServiceImpl.class.uniqueId0
│
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─calenderdevelop
    │  │              │  CalenderDevelopApplication.java
    │  │              │
    │  │              ├─common
    │  │              │      Const.java
    │  │              │
    │  │              ├─config
    │  │              │      PasswordEncoder.java
    │  │              │      WebConfig.java
    │  │              │
    │  │              ├─controller
    │  │              │      CalenderController.java
    │  │              │      CommentController.java
    │  │              │      UserController.java
    │  │              │
    │  │              ├─dto
    │  │              │  ├─request
    │  │              │  │      CreateCalenderRequestDto.java
    │  │              │  │      CreateCommentRequestDto.java
    │  │              │  │      CreateUserRequestDto.java
    │  │              │  │      DeleteUserRequestDto.java
    │  │              │  │      LoginRequestDto.java
    │  │              │  │      UpdateCalenderRequestDto.java
    │  │              │  │      UpdateCommentRequestDto.java
    │  │              │  │      UpdateUserRequestDto.java
    │  │              │  │
    │  │              │  └─response
    │  │              │          CalenderResponseDto.java
    │  │              │          CommentResponseDto.java
    │  │              │          LoginResponseDto.java
    │  │              │          UserResponseDto.java
    │  │              │
    │  │              ├─entity
    │  │              │      BaseEntity.java
    │  │              │      Calender.java
    │  │              │      Comment.java
    │  │              │      User.java
    │  │              │
    │  │              ├─exception
    │  │              │      CalExceptionHandler.java
    │  │              │      CustomException.java
    │  │              │
    │  │              ├─filter
    │  │              │      LoginFilter.java
    │  │              │
    │  │              ├─repository
    │  │              │      CalenderRepository.java
    │  │              │      CommentRepository.java
    │  │              │      UserRepository.java
    │  │              │
    │  │              └─service
    │  │                      CalenderService.java
    │  │                      CalenderServiceImpl.java
    │  │                      CommentService.java
    │  │                      CommentServiceImpl.java
    │  │                      UserService.java
    │  │                      UserServiceImpl.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │
    │      ├─static
    │      └─templates
    │              home.html
    │
    └─test
        └─java
            └─com
                └─example
                    └─calenderdevelop
                            CalenderDevelopApplicationTests.java
```
