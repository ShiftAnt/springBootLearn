# Spring Boot Learn Project

> Spring.io 페이지 학습

## 4.  Building Java Projects with Gradle   
* gradle 설치
    * `brew install gradle`   
    
* gradle 빌드
    * `gradle build` 
        > build시 프로젝트 메인 클래스는 하나이어야 하며 settings.gradle이 있는 폴더에서 명령어를 실행해야 함.   
        파일은 `[project_path]/build/libs` 경로에 생김


* build.gradle
    * repositories
        > dependencies를 선언하는 곳 주로 `Maven Central repository`를 많이 사용 함   
        ```
        repositories { 
            mavenCentral() 
        }
        ```

    * dependencies
        > 프로젝트의 종속 항목을 관리하는 곳
        ```
        dependencies {
            implementation "joda-time:joda-time:2.2"
            testImplementation "junit:junit:4.12"
        }
        ```
        * implementation
        > 프로젝트 코드를 컴파일하는데 필요한 종속성   
        코드를 실행하는 컨테이너(예: Java Servlet API)에서 런타임에 제공함

        * testImplementation
        > 테스트 컴파일 및 실행에 사용되는 종속성   
        프로젝트를 빌드하거나 실행할 땐 필요하지 않음

    * jar
        > JAR 파일의 이름을 지정함
        ```
        jar {
            archiveBaseName = 'gs-gradle'
            archiveVersion =  '0.1.0'
        }
        ```
        > jar 파일을 생성하면 gs-gradle-0.1.0.jar 파일이 생성됨