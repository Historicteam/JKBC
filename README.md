Примеры использования библиотеки смотрите в тестах исходного кода.
Для добавления зависимости с помощью Maven надо добавить в pom.xml следующий текcт:
```
<repositories>
  <repository>
    <id>JSCP-mvn-repo</id>
    <url>https://raw.github.com//Historicteam/JSCP/mvn-repo/</url>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </repository>
</repositories>
<dependencies>
  <dependency>
    <groupId>by.ostis.mihas</groupId>
    <artifactId>jscp</artifactId>
    <version>0.0.1</version>
  </dependency>
</dependencies>
```
Также можете скачать jar файл с mvn-repo.
