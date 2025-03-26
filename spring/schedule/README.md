![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=250&section=header&text=Kiosk%20Project&fontSize=80)

## 🤔 개요
- 이 프로젝트는 간단한 키오스크 시스템을 구현한 Java 애플리케이션입니다. 사용자는 메뉴에서 항목을 선택하고 장바구니에 추가한 후 주문을 완료할 수 있습니다. 또한, 사용자 유형에 따라 할인 기능이 제공됩니다.  

##  🌳 개발환경
- ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)
 언어: Java

- ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)
JDK 버전: 17

## ⏱️ 개발기간
- 2025-03-10~ 2025-03-13(4일)

## 🛠 목차  

1. [❓ 클래스 설명](#-클래스-설명)
2. [🙋‍♀️ 실행방법](#%EF%B8%8F-실행방법)
3. [🛠 기능 요약](#-기능-요약)
4. [✅ 디렉토리 구조](#-디렉토리-구조)

   
# ❓ 클래스 설명
## 1. Main.java
- main 메서드를 포함하는 실행 파일입니다.

- Kiosk 클래스의 start() 메서드를 호출하여 프로그램을 실행합니다.

 ## 2. Kiosk.java
- 키오스크 시스템의 핵심 메서드를 담당하는 클래스입니다.

- 메뉴 카테고리를 관리하고, 사용자 입력을 받아 메뉴를 선택 및 장바구니에 추가할 수 있도록 합니다.

- 주문 및 할인 적용 기능을 포함하고 있습니다.

 ## 3. Menu.java
- MenuItem 객체를 관리하는 클래스입니다.

- 특정 카테고리에 속하는 메뉴 항목들을 저장하고, 이를 출력하는 기능을 제공합니다.

 ## 4. MenuItem.java

- 개별 메뉴 항목을 정의하는 클래스입니다.

- 버거 이름, 가격, 설명을 필드로써 포함하고 있습니다.

 ## 5. ShoppingCart.java

- 장바구니 기능을 담당하는 클래스입니다.

- 선택한 MenuItem 객체를 저장하고, 총 주문 금액을 계산할 수 있습니다.

- 특정 항목을 제거하거나 장바구니를 초기화할 수 있습니다.

 ## 6. UserDiscount.java

- 사용자 할인 정보를 관리하는 enum 클래스입니다.

- 국가유공자, 군인, 학생이 이름의 상수에 각각의 할인율을 정의하고 있습니다.

- 할인 금액을 계산하는 메서드를 포함하고 있습니다.


# 🙋‍♀️ 실행방법

1. Main.java 파일을 실행하여 프로그램을 시작합니다.

2. 메뉴에서 원하는 항목을 선택하고 장바구니에 추가합니다.

3. 주문 화면에서 할인 유형을 선택하고 최종 결제를 진행합니다.


# 🛠 기능 요약

- 메뉴 선택: 사용자가 다양한 카테고리에서 항목을 선택 가능

- 장바구니 관리: 선택한 항목을 추가, 제거 가능

- 할인 적용: 사용자 유형에 따라 할인 제공

- 주문 완료: 최종 결제 후 주문 완료 메시지 출력

# ✅ 디렉토리 구조
```java
com/example/kiosk/
│── Main.java           
│── Kiosk.java          
│── Menu.java          
│── MenuItem.java       
│── ShoppingCart.java  
│── UserDiscount.java   
```
