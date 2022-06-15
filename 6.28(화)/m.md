# NELO (Naver Error LOgging System
- ### 로그 저장, 실시간 검색, 오류 분석 , 시각화, 알람 제공
- ### 로그 전송을 위한 SDK 제공
- ### 앱 크래시 분석 제공

![image](https://user-images.githubusercontent.com/28849549/173866549-f4639f79-d073-425d-92d9-bc7d65c4c5e3.png)

<br/>

## 그룹과 프로젝트
- ### 프로젝트
	- 로그 관리를 위한 기본 단위
- ### 그룹
	- 여러개 프로젝트를 그룹 단위로 묶어서 관리할 수 있음
- ### 디폴트 그룹
	- 디폴트 그룹 기준으로 대시보드 기능을 제공

<br/>

## 지원 SDK 목록
-   **[NELO Android SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/android/)**
-   **[NELO Android NDK C++](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/cpp-android-ndk/)**
-   **[NELO Linux C++ SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/cpp-linux/)**
-   **[NELO Windows C++ SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/cpp-windows/)**
-   **[NELO iOS/Mac OS X SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/obj-c/)**
-   **[NELO CSharp SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/csharp-windows/)**
-   **[NELO Log4j SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/log4j/)**
-   **[NELO Logback SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/logback/)**
-   **[NELO Log4j2 SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/log4j2/)**
-   **[NELO filebeat SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/filebeat/)**
-   **[NELO Golang SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/golang/)**
-   **[NELO Node.js SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/nodejs/)**
-   **[NELO HTTP SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/http/)**
-   **[NELO Apple C++ SDK](https://pages.oss.navercorp.com/nelo/docs/naver-dev/ko-kr/sdks/cpp-apple/cpp-apple)**

<br/>

## 알람
- ### 조건에 맞는 로그의 수가 일정한 기준을 만족하면, 사용자가 정한 방법으로 알려주는 기능
  
<br/>

## 실습
### 1. PASTA 서비스 생성 (없으신 분만) [#Link](https://pasta-dev.navercorp.com/)
- 서비스키
- 서비스타이틀
- ESM코드
- 관리자

<br/>

### 2. NELO 그룹 생성
- 그룹이름

<br/>

### 3. 로그 수집
- #### 실습자료 [#Link](https://oss.navercorp.com/nelo/samples)
- #### Collector Server 정보
	- URL (dev)
		- http : alpha-col.nelo2.navercorp.com
		- tcp : dev-col-tcp.nelo.navercorp.com
		- udp : dev-col-udp.nelo.navercorp.com
	- Port
		- http : 80
		- https : 443
		- syslog : 514
		- thrift : 10006
		- NPC : 10007

- #### Payload
|FIELD|REQUIRED|TYPE|DESCRIPTION|
|---|:---:|---|---|
|projectName|Y|String|NELO에 등록된 프로젝트의 키. 프로젝트 상세 페이지에서 확인할 수 있습니다.|
|projectVersion|Y|String|프로젝트 버전. `A~Z, a~z, 0~9, -, _` 만 사용할 수 있습니다.|
|body|Y|String|로그 메세지. UTF-8을 사용하고 공백이면 안 됩니다.|
|host|N|String|로그가 어느 서버로부터 왔는지 식별하기 위한 목적으로 사용합니다. 기본 값으로 TCP의 peer-address를 사용합니다.|
|logType|N|String|로그를 식별하기 위해 사용합니다. 기본 값으로 `nelo2-log`를 사용합니다.|

> ! NOTE
> - 필요한 경우 커스텀 필드를 추가할 수 있습니다.
> - 시스템 필드로 사용되는 `logTime` 과 `sendTime` 또한 커스텀 필드로 추가될 수 있습니다.
> - `logTime` 의 경우 최근 3일 이내, 즉 `logTime` > (로그가 NELO Collector에 도착 한 time stamp - 3*24*60*60*1000) 의 경우에만 사용할 수 있습니다.

<br/>

### 3-1) HTTP [#Link](https://oss.navercorp.com/nelo/samples/tree/master/curl)
- #### Endpoint
```
POST /_store
```

- #### cURL Example
```
curl -XPOST COLLECTOR_URL -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{ 
    "projectName": "YOUR_PROJECT_NAME", 
    "projectVersion": "YOUR_PROJECT_VERSION", 
    "body": "This log message come from HTTP client."
}'
```

- COLLECTOR_URL : HTTP Protocol 기반 수집 주소  
	- dev : http://alpha-col.nelo2.navercorp.com/_store  

- YOUR_PROJECT_NAME : Nelo에 등록 된`Txt Token`의 값  
	- PASTA -> NELO -> 프로젝트 -> TXT TOKEN  

- YOUR_PROJECT_VERSION : 프로젝트 버전 (영문, 숫자, -, _, .만 허용되고 영문/숫자/_로 시작하여야 함)

<br/>


### 3-2) logBack [#Link](https://oss.navercorp.com/nelo/samples/tree/master/java_logback)
1. Add the NAVER maven repository on your `pom.xml`
```xml
<repositories>  
    <repository>
		<id>Naver repository</id>  
        <name>Naver repository</name>  
        <url>https://registry.navercorp.com/maven2/</url>  
    </repository>
</repositories>
```


2. Add the NELO logback dependency on your `pom.xml`

```xml
<dependency>
    <groupId>com.naver.nelo2</groupId>
    <artifactId>nelo2-java-sdk-logback</artifactId>
    <version>1.6.6</version>
</dependency>
```

3. Create an appender for sending logs to NELO on your `logback.xml`

- The case of using `ThriftAppender`
```xml
<appender name="NELO-thrift" class="com.naver.nelo2.logback.ThriftAppender">
    <param name="collectorUrl" value="COLLECTOR_URL"/>
    <param name="port" value="COLLECTOR_PORT"/>
    <param name="projectName" value="YOUR_PROJECT_NAME"/>
    <param name="version" value="YOUR_PROJECT_VERSION"/>
    <param name="debug" value="true"/>
</appender>
```

- COLLECTOR_URL : TCP Protocol 기반 수집 주소  
	- dev : dev-col-tcp.nelo.navercorp.com

- COLLECTOR_PORT : TCP port
	- dev : 10006

- YOUR_PROJECT_NAME : Nelo에 등록 된`Txt Token`의 값  
	- PASTA -> NELO -> 프로젝트 -> TXT TOKEN  

- YOUR_PROJECT_VERSION : 프로젝트 버전 (영문, 숫자, -, _, .만 허용되고 영문/숫자/_로 시작하여야 함)

<br/>

- The case of using `HttpAppender`
```xml
<appender name="NELO-http" class="com.naver.nelo2.logback.HttpAppender">
    <param name="collectorUrl" value="COLLECTOR_URL"/>
    <param name="port" value="COLLECTOR_PORT"/>
    <param name="projectName" value="YOUR_PROJECT_NAME"/>
    <param name="version" value="YOUR_PROJECT_VERSION"/>
    <param name="debug" value="true"/>
</appender>
```

4. Add the appender on your `logback.xml`
```xml
<root level="info">
    <appender-ref ref="STDOUT" />
    <appender-ref ref="YOUR_APPENDER_NAME" />
</root>
```

5. You can send logs to run testcase on `src/test/java/SampleTest.java`

<br/>

### 4. 로그 검색
- #### [PASTA](https://pasta-dev.navercorp.com/) 접속하여 NELO 플랫폼 입장
- #### 루씬 쿼리를 통한 로그 검색 및 필드 확인
	- logLevel:ERROR

<br/>

### 5. 알람 설정 및 메일 수신
- #### 알람 등록
- #### 메일 수신

<br/>

### 6. 대시보드 구성
- #### TODO
