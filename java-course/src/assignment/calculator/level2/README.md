시스템 환경
- IDE : Intelli J
- language : Java 17


요구사항
    1.  결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
    2. Main메서드에 Calculator 클래스가 활용될 수 있도록 수정
    3. Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    4. 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현




역할별 클래스
   Main	      - 프로그램 실행 & 객체 조립 (진행 흐름만 담당)
   Display	  - 화면 출력 (메뉴, 결과 등)
   Calculator - getter, setter
   Menu	      - 메뉴 선택 & 사용자 입력 처리
   Operator	  - 계산 기능


calculator
├── level2
│   ├── Calculator.java
│   ├── Main.java
│   ├── Menu.java
│   └── Operator.java
└── ui
└── Display.java






기능
   메뉴 1: 2개의 숫자와 사칙연산을 입력하면 계산하여 출력해준다.
   메뉴 2: 조회했던 결과값을 출력해준다.
   메뉴 3: 조회했던 결과값을 모두 삭제한다.
   메뉴 4 : 프로그램 종료

