#Учебный проект магазина автомобилей

##Техническое задание (ТЗ)

Написать приложение "магазин автомобилей", выполняющее следующие функции.
  При выборе каждой функции пользователь может ввести данные для работы каждой функции и ввернуться в 
  основное меню.
 
   1. Принять машину на склад
   2. Оформить новый тип машин
   3. Оформить нового покупателя
   4. Оформить нового продавца
   5. Уволить продавца
   6. Начислить зарплату продавцу на основании ежемесячной ставки.
   7. Продать машину
   8. Вывести отчет о продажах за период (дата, покупатель, продавец, машина).
   9. Вывести отчет о зарплатах продавцам за период (дата, продавец, сумма).
   
 Первая основная задача этого задания - создание такой архитектуры базы данных, чтобы она позволяла выполнять все заложенные функции приложения. При построении архитектуры можно опираться на тот пример, который разбирался на занятии а так же пример создания схемы HR. Архитектура БД должна соответствовать 2-й нормальной форме, желательно 3-ей.
 Результатом создания архитектуры должен быть файл скрипт SQL, в котором будет размещено создание архитектуры в виде последовательности SQL запросов. Файл необходимо поместить в каталог ddl внутри проекта.
 В задаче, действия с базой данных должны выполняться по средствам JDBC Dao используя подход ORM. Для удобства работы с ORM рекомендую для каждого класса сущности создать класс DataMapper, который будет преобразовывать запись из ResultSet в объект и наоборот (для JDBC).

#### Дополнительно:
Для ТЗ создать второй вариант слоя работы с БД. Заменить подход работы с базой данных, вместо JDBC Dao использовать Hibernate Dao. Для решения этой задачи рекомендую использовать стандартную документацию, расположенную в каталоге дистрибутива Hibernate/documentation/manual/en-US/html_single. Так же для работы с сессиями использовать класс HibernateUtil, рекомендованный в документации.

Для задачи "магазин автомобилей" добавить конфигурацию приложения на основании properties файла. Конфигурация должна позволять настраивать тип используемого Dao, либо JDBC, либо Hibernate. При запуске приложения, на основании конфигурации приложение переключается на использование того или иного Dao.

### Мной были реализованы следующие части ТЗ:

* ####Сделано основное окно с кнопками выбора согласно ТЗ. От себя я добавил кнопку "Настройки", а так же работу с основным меню параллельно с открытым(и) окнами. 
![Image alt](https://cloud.githubusercontent.com/assets/22368404/23029664/5f5392b6-f47c-11e6-8ed7-b65649736e3f.png)

* ####Разработан функционал приёма машины на склад (кнопка - 1) 

Графический интерфейс собирался в JavaFX.
Доступ к БД осуществлялся через JDBC-драйвер.
![Image alt](https://cloud.githubusercontent.com/assets/22368404/23029555/024e360c-f47c-11e6-9809-3e1a69dbcbed.png)

###Остальное дорабатывается по мере наличия свободного времени.