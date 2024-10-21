# java-calculator-precourse

## 미션 1주차 - 문자열 덧셈 계산기

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다. 구분자와 숫자로 이루어진 문자열에서 숫자를 추출하여 결과값을 반환하면 된다.

## 학습 목표

- Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해지기
- JAVA를 이용해서 간단한 문제를 해결해보기
- 기능을 작성하기 전에 기능 목록을 만들기
- 기능 단위로 커밋하기
- 요구사항에 반영되지 않은 내용은 스스로 판단하여 구현할 것

## 입출력 요구사항

### 출력

```
결과 : 6
```

### 실행 결과 예시

```angular2html
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 패키지 구조

```angular2html
└─calculator
│  Application.java
│
├─controller
│      CalculatorController.java
│
├─domain
│      Delimiters.java
│      Operands.java
│
├─dto
│      ResultDTO.java
│      UserInputDTO.java
│
├─service
│      CalculateService.java
│      ParsingService.java
│
├─utils
│      Constants.java
│
├─validators
│      InvalidCalculationException.java
│      InvalidInputStringFormatException.java
│      InvalidOperandFormatException.java
│
└─view
InputView.java
OutputView.java
ViewMessages.java
```

## 요구사항 정리(기능 목록)

- 문자열 입력 기능
    - ```camp.nextstep.edu.missionutils```에서 제공하는 ```Console``` API 사용
    - 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용

- 문자열 출력 기능
    - 처음 시작 시작 시 ```덧셈할 문자열을 입력해 주세요.```라는 문구를 출력한다.
    - 덧셈 결과 값을 ```결과 : (덧셈결과)``` 형식으로 반환한다.

- 구분자에 따라 문자를 분리하는 기능
    - 구분자를 추출하는 기능(커스텀 구분자 포함)
        - 여러 글자로 이루어진 커스텀 구분자 지원
    - 구분자에 따라 숫자를 분리하는 기능

- 추출한 숫자를 계산하는 기능
    - 숫자들을 모두 더하는 기능

- 예외 처리
    - 스페이스만 입력된 경우
    - 문자열 처음이 // 또는 숫자가 아닌 다른 기호가 들어왔을 경우
    - 문자열 마지막이 숫자로 끝나지 않는 경우
    - // 뒤에 \n이 안오는 경우
    - //과 \n 사이에 아무것도 입력되지 않은 경우
    - 구분자가 연달아 들어오는 경우
    - 구분자 사이의 값이 정수가 아닌 경우
    - 숫자에 음수가 있는 경우
    - 구분자 사이의 숫자에서 오버플로우가 발생하는 경우
    - 숫자의 합에서 오버플로우가 발생하는 경우