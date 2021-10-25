## BankAPI

### Установка и запуск

    1) git clone https://github.com/SPQsmk/BankAPI
    2) cd BankAPI
    3) mvn clean package
    4) cd target
    5) java -jar BankAPI-1.0-SNAPSHOT.jar

### Использование
    1) Вывод списка карт для клиента по id (GET запрос):
        localhost:8080/clients/{id}/cards
    2) Получение баланса счета по id (GET запрос):
        localhost:8080/accounts/{id}/balance
    3) Обновление баланса счета (PUT запрос):
        localhost:8080/clients/update-balance
            json: 
                {
                    "id": LONG_VALUE, // id счета
                    "deposit": DECIMAL // сумма пополнения
                }
    4) Добавление новой карты по id счета (POST запрос):
        localhost:8080/cards/create
            json: 
                {
                    "accountId": LONG_VALUE, // id счета
                    "number": STRING // номер карты
                }