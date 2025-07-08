Java version: 16.0.2

Maven version: 3.9.6

Проект не использует сторонние библиотеки.  
Вся реализация выполнена с использованием стандартной библиотеки Java (JDK).

Для сборки проекта необходимо:
Открыть терминал в главной директории проекта и запустить команду

mvn clean package

После этого jar файл появится в target/JavaTestTask-1.0-SNAPSHOT.jar

Пример команды для запуска:
java -jar target/JavaTestTask-1.0-SNAPSHOT.jar -a -f -o /output -p sample- in1.txt in2.txt

Примечание:
Файлы с входными данными должны находиться в папке /resources проекта
