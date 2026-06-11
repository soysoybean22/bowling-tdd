# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 프로젝트 개요

볼링 게임 점수 계산기를 TDD(테스트 주도 개발) 방식으로 구현하는 Java 프로젝트입니다.

## 빌드 및 실행 명령어

```bash
# 애플리케이션 실행
./gradlew run

# 전체 테스트 실행
./gradlew test

# 특정 테스트 클래스 실행
./gradlew test --tests "org.example.MainTest"

# 특정 테스트 메서드 실행
./gradlew test --tests "org.example.MainTest.addition"

# 빌드
./gradlew build

# 테스트 결과 리포트 위치
build/reports/tests/test/index.html
```

Windows에서는 `./gradlew` 대신 `.\gradlew.bat`을 사용합니다.

## 기술 스택

- Java (JDK 필요 — JAVA_HOME 환경변수 설정 필수)
- Gradle (Kotlin DSL, `build.gradle.kts`)
- JUnit 5 (`junit-bom:6.0.0`, `junit-jupiter`)

## 코드 구조

- `src/main/java/org/example/` — 프로덕션 코드
- `src/test/java/org/example/` — 테스트 코드
- 메인 클래스: `org.example.Main`

## TDD 개발 방식

이 프로젝트는 TDD 사이클(Red → Green → Refactor)로 개발합니다. 새 기능을 추가할 때는 반드시 테스트를 먼저 작성하고 이후 구현합니다.

## 볼링 점수 계산 (The Bowling Game Kata)

### 문제 설명

미국식 텐핀 볼링(American Ten-Pin Bowling) 한 게임의 유효한 투구 순서가 주어졌을 때, 해당 게임의 최종 총점을 계산하는 프로그램을 작성합니다. 이 Kata에서는 아래 사항들을 고려하지 않습니다.

- 투구 유효성 검사
- 투구 횟수 및 프레임 수 정확성 검사
- 중간 프레임 점수 제공

### 볼링 점수 규칙

볼링 게임은 총 10개 프레임으로 구성됩니다. 각 프레임에서 플레이어는 10개의 핀을 쓰러뜨리기 위해 최대 두 번 투구합니다.

- **스페어**: 두 번의 투구로 10개 핀을 모두 쓰러뜨린 경우. 보너스는 다음 투구(1회)에서 쓰러뜨린 핀 수.
- **스트라이크**: 첫 번째 투구에서 10개 핀을 모두 쓰러뜨린 경우. 해당 프레임은 1구로 종료. 보너스는 이후 두 번의 투구에서 쓰러뜨린 핀 수의 합.
- **10번 프레임**: 스페어 또는 스트라이크 시 추가 투구 가능. 최대 3회 투구.

### 요구사항

`Game` 클래스에 다음 두 메서드를 구현합니다.

```java
void roll(int pins)  // 투구 시마다 호출. pins = 쓰러뜨린 핀 수
int score()          // 게임의 최종 총점 반환
```
