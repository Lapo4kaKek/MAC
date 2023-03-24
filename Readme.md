# ДЗ-3 Лазарев Василий и Ефимов Иван
## Условие задачи
```
Тут должно было быть условие, но обойдемся без 30 страниц в readme файле
```
##### Планируемая оценка: ~7-9

## Решение:
### Критерии на оценку 4:
```
Корректная ООП-реализация программы без поддержки параллелизма
в процессах и реализации функционала оценки времени 
ожидания заказов, а также без проверки корректности входных 
данных.
```
В директории 'Restaurant' находятся все модели (классы) к задаче. В src
остается лишь точка входа в программу, класс Main, также главный агент, парсер данных
и класс для вывода результатов. Входные данные, т.e. json'ы, расположены в папке
input. 
### Многопоточность (+1)
Parser.java:
```Java
ExecutorService executor = Executors.newFixedThreadPool(8);
List<Callable<Void>> tasks = new ArrayList<>();
tasks.add(() -> {
    getCookersJson();
    return null;
});
tasks.add(() -> {
    getDishesCardsJson();
    return null;
});
try {
    List<Future<Void>> futures = executor.invokeAll(tasks);
    for (Future<Void> future : futures) {
        future.get();
    }
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
} finally {
    executor.shutdown();
}
```
Для работы с многопоточностью используем ExecutorService и Future.
ExecutorService - это интерфейс, который представляет сервис выполнения потоков. Он предоставляет способ запускать потоки асинхронно и управлять их выполнением.

Future - это интерфейс, который представляет результат асинхронной операции, которая может еще не завершена. Он предоставляет методы для проверки статуса операции и получения результата, когда операция завершится.

В примере выше с парсингом мы можем использовать 
ExecutorService для создания пула потоков, которые будут 
параллельно парсить различные файлы. Мы можем использовать 
метод submit() для отправки каждой задачи на выполнение в пуле 
потоков. Затем мы можем получать объекты Future для каждой 
задачи, чтобы проверять их статус и получать результаты, 
когда они будут готовы.

### Обработка ошибок при обработке входных данных (+1)
```java
Path path = Paths.get("input/equipment.txt");
try {
      EquipmentList equipmentList = new Gson()
      .fromJson(new String(Files.readAllBytes(path)), 
      EquipmentList.class );
      System.out.println(equipmentList);
} catch(IOException e) {
            e.printStackTrace();
}
```
В случае, если что-то идет не так - ловится исключение и выводится ошибка на экран

Например:
![](static/iamgay.png)
### Для МАС используется Jade. Jar файлы Jade, Gson и тд расположены в static (+1 or +2)




