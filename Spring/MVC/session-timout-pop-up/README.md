Create a maven web-project in terminal
mvn archetype:generate -DgroupId=com.spring.mvc -DartifactId=session-timout-pop-up -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

Modify the contents of the below files
1.web.xml

Add the following files
1./webapp/WEB-INF/spring-mvc-servlet.xml
2./webapp/WEB-INF/views/index.jsp
3./webapp/WEB-INF/views/dashboard.jsp
4.Created
    i.spring controller under(/src/main/java/com/spring/mvc/controller/InitController.java)
    ii.Value Object for Login (/src/main/java/com/spring/mvc/vo/LoginVo.java)

Note :
1. Added and modified contents are available in the respective paths specified

Issues Faced
http://stackoverflow.com/questions/793983/jsp-el-expression-is-not-evaluated#answer-25372735