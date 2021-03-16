# JavaBookingService
RESTful API сервис, позволяющий управлять резервиврованием ресурсов.

Java приложение разработано с использованием Spring Boot.
## Хранение данных
Данные в сервисе размещаются и хранятся в базе данных PostgreSQL в трёх таблицах: reservationusers, resources и reservations. Таблица reservations связана с таблицами resources и reservationusers через foreign key: Resources_fkey и Reservationusers_fkey. 

Таблица reservations содержит поля:
1.	id - целочисленный уникальный идентификатор записи;
2.	resource - целочисленный уникальный идентификатор резервируемого ресурса;
3.	reservationuser - целочисленный уникальный идентификатор пользователя, резервирующего ресурс;
4.  date - дата резервации, тип - дата;
5.	duration - продолжительность резервации ресурса, тип - время;

Таблица resources содержит поля:
1.  id - целочисленный уникальный идентификатор ресурса;
2.	resource - наименование ресурса, строка до 100 символов;

Таблица reservationusers содержит поля:
1.  id - целочисленный уникальный идентификатор пользователя;
2.	reservationuser - ФИО пользователя, строка до 100 символов;

Для получения последовательных уникальных значений id для таблиц созданы последовательности(sequence) reservations_sequence, resources_sequence и reservationusers_sequence.

Реализована валидация входящих значений полей:
1.  На уровне базы данных через ограничения(сonstraints);
2.  В приложении, для информирования пользователя о причинах ошибок валидации;

## Структура приложения
В приложении таблицы мапятся в классы Reservation, Resource и ReservationUser. Для взаимодействия с БД реализованы JPA-репозитории: ReservationRepository, ResourceRepository и ReservationUserRepository. 

Для обработки веб-запросов, связанных с зарезервированными ресурсами, создан контроллер ReservationController, реализующий обработку следующих HTTP-запросов:
1.  GET /api/reservations - список всех зарезервированных ресурсов;
2.  GET /api/reservations/:id - информация о зарезервированном ресурсе с указанным id;
3.  POST /api/reservations - добавление новой записи о зарезервированном ресурсе;
4.  PATCH /api/reservations/:id - изменение информации о зарезервированном ресурсе с указанным id;
5.  DELETE /api/reservations/:id - удаление записи о зарезервированном ресурсе с указанным id;


Для обработки веб-запросов, связанных с ресурсами, создан контроллер ResourceController, реализующий обработку следующих HTTP-запросов:
1.  GET /api/resources - список всех ресурсов;
2.  GET /api/resources/:id - информация о ресурсе с указанным id;
3.  POST /api/resources - добавление нового ресурса;
4.  PATCH /api/resources/:id - изменение информации о ресурсе с указанным id;
5.  DELETE /api/resources/:id - удаление записи о ресурсе с указанным id;

Для обработки веб-запросов, связанных с пользователями, создан контроллер ReservationUserController, реализующий обработку следующих HTTP-запросов:
1.  GET /api/reservationusers - список всех пользователей;
2.  GET /api/reservationusers/:id - информация о пользователе с указанным id;
3.  POST /api/reservationusers - добавление нового пользователя;
4.  PATCH /api/reservationusers/:id - изменение информации о пользователе с указанным id;
5.  DELETE /api/reservationusers/:id - удаление записи о пользователе с указанным id;

## Запуск приложения
Для запуска из IntelliJ IDEA необходимо создать конфигурацию для запуска типа Spring Boot, в поле Main class указать: com.vlter.bookingsource.BookingsourceApplication.

## Тестирование
Для тестирования в качестве HTTP-клиента использовал Postman.