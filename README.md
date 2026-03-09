# Algorithm Study

알고리즘 문제 풀이 스터디용 레포지토리입니다.  
브랜치를 나눠서 문제를 올리고, Pull Request로 서로 리뷰하는 방식으로 진행합니다.

---

## Members

- 강현민
- 김창오

---

## Study Goal

- 꾸준한 알고리즘 풀이
- 코드 리뷰 습관 만들기
- Git / GitHub 협업 익숙해지기
- PR 기반 피드백 문화 만들기

---

## Directory Structure

```text
algorithm-study
├─ .github
│  └─ pull_request_template.md
├─ changoh
│  └─ week01
│     └─ BOJ_0000.java
├─ HyeonMin
│  └─ week01
│     └─ BOJ_0000.java
├─ docs
│  └─ study_rules.md
├─ .gitignore
├─ PROBLEM_LIST.md
└─ README.md
```

---

## Branch Rule

- `main` : 최종 반영 브랜치
- `changoh` : changoh 작업 브랜치
- `HyeonMin` : HyeonMin 작업 브랜치

직접 `main` 에 push 하지 않고, 반드시 브랜치에서 작업 후 Pull Request를 올립니다.

---

## Upload Flow

1. 각자 자기 브랜치에서 문제 풀이
2. commit
3. push
4. Pull Request 생성(풀이 과정은 description 템플릿 활용)
5. 상대방이 코드 리뷰
6. 수정 반영
7. merge

---

## Commit Message Example

```bash
BOJ 1759 암호 만들기
BOJ 9663 N-Queen
BOJ 14888 연산자 끼워넣기
```

---

## File Naming Rule

```text
BOJ_문제번호.java
PGM_문제이름.java
SWEA_문제번호.java
```

예시

```text
BOJ_1759.java
BOJ_9663.java
SWEA_2819.java
```

---

## Quick Start

### 1. 레포 clone

```bash
git clone <레포주소>
cd algorithm-study-template
```

### 2. 본인 브랜치 이동 또는 생성

```bash
git checkout -b changoh
```

또는

```bash
git checkout -b friend
```

### 3. 문제 풀이 후 commit / push

```bash
git add .
git commit -m "BOJ 1759 암호 만들기"
git push origin changoh
```

### 4. GitHub에서 Pull Request 생성

- base: `main`
- compare: 본인 브랜치
- description: 템플릿을 활용하여 풀이법 작성

---

## Review Focus

리뷰할 때 아래를 중심으로 보면 좋습니다.

- 변수명 / 메서드명
- 시간복잡도
- 자료구조 선택 이유
- 중복 코드
- 예외 처리 / 경계값
- 더 단순한 풀이 가능 여부

---

## Recommended Study Routine

- 주간 단위로 진행
- 주 초반(~화요일까지) 주간 풀 문제 PROBLEM_LIST.md에 등록하기
- PR 설명에 문제 링크 / 접근 방법 / 막힌 점 작성
- merge 전 상대방 리뷰 최소 1회 확인
