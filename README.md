# 👩‍🏫 프로젝트 소개

플레이데이터 수강생들에 대한 정보를 관리할 수 있는 프로그램입니다.

# 🙋‍♀️ 기여자
- [서주연](https://github.com/do-oni)
- [임우송](https://github.com/kingdomunder)
- [장혜민](https://github.com/hyemin-jang)


# 📅 기간

2021.08.23 ~ 2021.08.26

# 💻 개발환경

- Eclipse Photon
- JDK 1.8
- Oracle 11


# 🎁 주요 기능
- ✏ 수강생 정보 관리 (Student Entity)    
    - 모든 수강생 조회      
    - 특정 조건으로 수강생 조회       
    - 수강생 추가 - (해당 수강생의 출석정보가 default로 같이 생성)        
    - 수강생 정보 업데이트        
    - 수강생 삭제 - (해당 수강생의 출석정보가 같이 삭제)
      
- ✏ 스터디 정보 관리 (Study Entity)   
    - 모든 스터디 조회 `getAllStudy()`
    - 스터디 ID로 특정 스터디 조회 `getStudyById()`       
    - 스터디 주제 키워드로 특정 스터디 조회 `getStudyByTopic`      
    - 스터디 추가  `addStudy()` 
    - 스터디 정보 업데이트 `updateStudy()`        
    - 스터디 삭제 `deleteStudy()`
       
- ✏ 출석 정보 관리 (Attendance Entity**)**   
    - 출석 체크  `updatePresent()` (지각 체크, 결석 체크 동일) - SLF4J 라이브러리 활용     
    - 출결 모범 수강생 조회 `getPerfectPresent()`      
    - 지각 3회 수강생 조회 `getLateStudent()` (결석 3회 조회 동일)
    - 수강생 한명의 출석 정보 조회 `getOneAttendance()`        
    - 모든 출석 정보 조회 `getAllAttendance()`
       

# Notion 링크
https://little-cushion-1cc.notion.site/8f5a6a6702da4e2b8d82dcb0d158fd25

