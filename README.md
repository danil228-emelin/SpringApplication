# SpringApplication
В приложении реализована логика банковской операции.
С помощью PostMan посылается HTTP запрос на Rest сервер для перевода денег с одного счета на другой.
На стороне сервера  перевод реализован в виде транзакции.
Вдобавок реализованы элементы Аспектно-ориентированного программирования.
Если во время выполнения транзакции возникает ошибки, например недостаточно средства для перевода, их обработку перехватывают аспекты. 
Данные пользователей хранятся в базе данных, взаимодейсвие с которой осуществляется с помощью Spring Data
