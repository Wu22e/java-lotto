# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기

### 기능 요구사항

* 입력된 문자열의 덧셈을 계산해 준다
    * [x] 기본 구분자는 쉼표(,) 또는 콜론(:)이다
    * [x] 쉼표(,),콜론(:)외에 커스텀 구분자를 지정할 수 있다.
        * 커스텀 구분자는 문자열 앞부분에 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    * [x] 빈 문자열 또는 null을 입력 받은 경우 0을 반환한다.
    * 숫자 이외의 값 또는 음수가 들어간 경우 RuntimeException 예외를 전달한다.

## 로또

### 용어

* 로또는 1부터 45사이의 6개의 숫자를 가지고 있다
* 로또는 6개의 숫자는 중복이 없어야 한다.

### 기능 요구사항

* [x] 로또 구입 금액을 입력하면 구입에 해당하는 로또를 발행한다
    * 로또 1장의 가격은 1000원이다.
* [x] 로또를 수동으로 구입하고 싶으면 수량을 입력 해준다.
* [x] 수동으로 구매할 로또 번호를 입력해 준다.
* [x] 구매한 로또 목록(수동 + 자동)을 출력해준다.
* [x] 지난 주 당첨 번호를 입력한다.
* [x] 보너스 번호를 입력받는다.
* [x] 로또의 정의에 부합해야한다.
* [x] 구매한 로또와 당첨 번호를 비교하여 통계를 작성한다.
    * 3개, 4개, 5개, 6개 일치 여부를 출력한다.
* [x] 2등 당첨여부를 판단한다.
    * 2등은 6개의 번호중 5개 일치 보너스 번호가
* [x] 수익률을 계산하여 출력한다.
