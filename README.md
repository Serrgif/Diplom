## Дипломный проект профессии «Тестировщик»

### Документация

[План автоматизации](https://github.com/Serrgif/Diplom/blob/main/documents/Plan.md)

[Отчет по итогам тестирования](https://github.com/Serrgif/Diplom/blob/main/documents/Report.md)

[Отчет по итогам автоматизации](https://github.com/Serrgif/Diplom/blob/main/documents/Summary.md)

### Порядок запуска приложения

#### Требуемое ПО
1. Программа Docker Desktop
2. Java JDK версии 11 и выше
3. Intelij IDEA (желательно)

#### Алгоритм запуска 
1. Выполнить клонирование проекта с помощью команды <code>git clone https://github.com/Serrgif/Diplom.git</code>
2. Запустить приложение **Docker Desktop**
3. Открыть папку с проектом через **Intelij IDEA** / Открыть командную строку в папке
4. Выполнить запуск docker контейнера с помощью команды <code>docker-compose up </code>
5. Выполнить запуск приложения с помощью команды:
* Через **MySQL**: <code>java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app</code>
* Через **PostgreSQL**: <code>java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app</code>
6. Выполнить запуск тестов:
* Через **MySQL**: <code>.\gradlew clean test -DdbUrl=jdbc:mysql://localhost:3306/app</code>
* Через **PostgreSQL**: <code>.\gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app</code>
7. После завершения тестов ввести команду для формирования отчета **Allure**: <code>.\gradlew allureServe</code>






[![Java CI with Gradle](https://github.com/Serrgif/Diplom/actions/workflows/gradle.yml/badge.svg)](https://github.com/Serrgif/Diplom/actions/workflows/gradle.yml)