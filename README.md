# 🌳 Yogi-Josim (여기조심) - `develop` 브랜치

> 우리 동네의 작은 위험 신호를 포착하여 알려주는 서비스, 여기조심의 개발 브랜치입니다.
> 
## 🏛️ 아키텍처 (Architecture)
> 전체 서비스의 흐름도입니다. (이미지 삽입)

## 🛠️ 기술 스택 (Tech Stack)
| 구분         | 기술                                                             |
| ------------ |----------------------------------------------------------------|
| **Backend** | Java 17, Spring Boot 3.5.4, Spring Data JPA, Spring Data Redis |
| **Database** | MySQL                                                          |
| **Infra** | Docker, (향후 AWS EC2, S3 등 추가 예정)                               |
| **Tools** | IntelliJ IDEA, Git, GitHub, Swagger                            |

---
## 📝 실행 가이드 (Getting Started)
### 1. 프로젝트 클론
```bash
  git clone https://github.com/Yogi-Josim/Yogi-Josim-Server.git
```

2. 환경변수 설정
   프로젝트를 실행하기 전, IDE의 실행 설정(Run Configuration)에서 아래 환경변수를 반드시 설정해야 합니다.

```bash
  DB_USERNAME: (본인의 MySQL 사용자 이름)
  DB_PASSWORD: (본인의 MySQL 비밀번호)
```

3. API 문서 확인
   프로젝트 실행 후, 아래 주소에서 API 문서를 확인할 수 있습니다.

```bash
  URL: http://localhost:8080/swagger-ui.html
```
---
## 🗃️ ERD (Entity-Relationship Diagram)

> 데이터베이스의 구조입니다.

![ERD](./docs/images/ERD.png)


## 🤝 Git 컨벤션 (Git Convention)
### 브랜치 전략 (Git Flow)
- main: (**Protected**) 제품으로 출시될 수 있는 브랜치. 배포 시 태그(tag)를 사용하여 버전 기록.
- develop: (**Protected**) 다음 출시 버전을 개발하는 메인 브랜치. 모든 feature 브랜치가 이곳로 merge 됨.
- feature/{기능}: 새로운 기능 개발 및 리팩토링을 위한 브랜치. develop에서 분기하여 develop으로 merge.
- release/{버전}: 새로운 버전 출시를 준비하기 위한 브랜치. develop에서 분기하며, QA 및 버그 수정을 진행. 완료되면 main과 develop에 모두 merge.
- hotfix/{이슈}: main에 배포된 버전의 긴급한 버그를 수정하기 위한 브랜치. main에서 분기하며, 완료되면 main과 develop에 모두 merge.

### 커밋 메시지
- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정 (README 등)
- style: 코드 포맷팅, 세미콜론 누락 등 (코드 변경 없는 경우)
- refactor: 코드 리팩토링
- test: 테스트 코드 추가/수정
- chore: 빌드, 패키지 매니저 설정 등 (프로덕션 코드 변경 없는 경우)


## 📌 주요 링크 (Links) 

| 링크 종류      | URL                                       |
| -------------- | ----------------------------------------- |
| **API 문서** | `http://localhost:8080/swagger-ui.html`   |
| **Notion** | `(팀 노션 페이지 링크)`                       |


## 🧑‍💻 팀원 정보 (Our Team)

|[![fbehddn](https://github.com/fbehddn.png?s=100)](http://github.com/fbehddn)|[![holyPigeon](https://github.com/holyPigeon.png?s=100)](http://github.com/holyPigeon)|[![Gongjjin](https://github.com/Gongjjin.png?s=100)](http://github.com/Gongjjin)|
|:---:|:---:|:---:|
|**🐝 [유동우](http://github.com/fbehddn)**|**🐝 [정재우](http://github.com/holyPigeon)**|**🐝 [홍공진](http://github.com/Gongjjin)**|
|백엔드|백엔드|백엔드|

<br>

