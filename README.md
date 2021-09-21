<h1 align="center">🌱 디프만 안드로이드팀 토이 프로젝트</h1>

## 👋 프로젝트 개요
IT 연합동아리 디프만 9기 '투니투니'팀의 원활한 개발을 위해서, 

서로의 기술스택을 맞춰보는 방향으로 프로젝트 시작 전 토이 프로젝트를 진행.

아래의 **요구사항**을 토대로 개발을 진행하였고 **코드리뷰**를 통해 프로젝트 개선.

## ✅ 요구사항
 - **언어** : Kotlin
 - **minSdkVersion** : 23
 - **targetSdkVersion** : 30
 
 ### 첫번째 탭 - 연락처
  `Sample_List.json` 을 파싱한 후에 리스트로 출력. 
  
  사람 아이콘은 `ResourceSample.zip` 을 참고.
  
 **Advanced** - 플로팅 액션 버튼을 눌러서, 연락처를 추가할 수 있는 기능.
 
 - **연락처 구성** - Fragment, RecyclerView(LinearLayoutManager)
 - **구분선** - divideritemdecoration 
 - **Json 파싱 라이브러리** - Gson
 - **레이아웃 구성** - ConstraintLayout, FAB

### 두번째탭 - 갤러리
[`https://picsum.photos/v2/list`](https://picsum.photos/v2/list) api를 사용해서 이미지들을 불러온 다음에 리스트로 출력.

**Advanced -** 갤러리 이미지를 클릭했을때, 상세화면으로 이동, `author` `width` `height` 정보 출력, 이미지 회전 기능.

 - **갤러리 구성** - RecyclerView(GridLayoutManager), ViewHolder 
 - **레이아웃 구성** - ConstraintLayout 
 - **이미지 라이브러리** - Glide 
 - **네트워크 통신** - Retrofit, OkHttp 
 - **Json 파싱 라이브러리** - Gson

## 💬 개선사항
### 접근제한자(private)
### 불변성(var, val)
### Fragment 생성방법
### 화면 회전에 대한 처리
### DataBinding
