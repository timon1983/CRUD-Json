                                   CRUD-Json.
1.открыть проект в IntelliJ IDEA.
2.Запустить класс Main .
3.Работать с приложением посредством ввода команд ввиде числовых значений:
   1 - User
   2 - Post
   3 - Region
   4 - Exit
4.Работа с консолью реализована в каласса пакета view , которые реализуют интерфейс View c единственным методом
doChoise(), что позволяет не иметь прямой привязанности к классу клиента.
5.Обработка запросов пользователя производится классами в пекете controllers . Кааждый класс реализует свой интерфейс,
что позволяет не иметь прямой связи с классами пакета view.
6.Работа с файлами организована в пакете repository.
6.1 Логика обработки команд CRUD реализована в классах
  JsonPostRepositoryImpl
  JsonRegionRepositoryImpl
  JsonUserRepositoryImpl
которые реализуют каждый свой интерфейс наследованных от главного интерфейса GenericReposiroty.
6.2 Операции по работе с файлами вынесена в отдельные классы , реализующие главные интерфейсы Reader и Writer.Это позволяет
реализовать принцип единственной ответственности и  далает код наиболее гибким в плане добавления новых реализаций работы
с файлами и обслуживания данной реализации.
7.Работа выполнена в виде Maven проекта , в pom.xml добавлена библиотека gson для работы с файлами json.

