# Sample java daemon as windows service using apache commons daemon procrun
Description : http://blog.naver.com/wizardkyn/220842828329

## Service Install
```
CountService.exe //IS//CountService --DisplayName="Count Service"  --Startup=auto ^
--Description="Sample Winodws Service as Java Daemon" ^
--Install="H:\job\procrun\CountService.exe" ^
--Jvm="C:\Program Files\Java\jdk1.8.0_05\jre\bin\server\jvm.dll" --StartMode=jvm --StopMode=jvm ^
--Classpath="H:\job\procrun\dbDump.jar" ^
--StartClass=com.bcg.dbdump.CountService  --StartMethod=start ^
--StopClass=com.bcg.dbdump.CountService  --StopMethod=stop ^
--LogPath="H:\job\procrun\log" --LogLevel=debug"
```

## Service Update
```
CountService.exe //US//CountService --DisplayName="Count Service"  --Startup=auto ^
--Description="Sample Winodws Service as Java Daemon" ^
--Install="H:\job\procrun\CountService.exe" ^
--Jvm="C:\Program Files\Java\jdk1.8.0_05\jre\bin\server\jvm.dll" --StartMode=jvm --StopMode=jvm ^
--Classpath="H:\job\procrun\dbDump.jar" ^
--StartClass=com.bcg.dbdump.CountService  --StartMethod=start ^
--StopClass=com.bcg.dbdump.CountService  --StopMethod=stop ^
--LogPath="H:\job\procrun\log" --LogLevel=debug"
```

## Service Remove
```
CountService.exe //DS//CountService
```
# Fat Jar Maven Pom.xml
Reference : https://www.mkyong.com/maven/create-a-fat-jar-file-maven-assembly-plugin/
```
<build>
    <plugins>
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>2.6</version>
            <configuration>
                <!-- get all project dependencies -->
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
                <!-- MainClass in mainfest make a executable jar -->
                <archive>
                    <manifest>
                        <mainClass>com.bcg.dbdump.CountService</mainClass>
                    </manifest>
                </archive>
            </configuration>
            <executions>
                <execution>
                    <id>make-assembly</id>
                    <!-- bind to the packaging phase -->
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```