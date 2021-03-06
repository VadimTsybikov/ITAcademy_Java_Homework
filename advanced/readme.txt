Симулятор загрузки ПК.

Сценарий

При запуске программы происходит включение воображаемого ПК. Тестируется и 
запускаеся периферийное оборудование в следующем порядке:
1. центральный процессор;
2. проверка контрольной суммы программы ПЗУ;
3. первые 64 байта ОЗУ (для рагрузки резидентных программ);
4. контроллер графического адаптера
5. ОЗУ;
6. БИОС;
7. контроллер COM-портов;
8. контроллер накопителей на жеских магнитных дисках

Если какой-то тест не выполняется - дальнейшая проверка и запуск ОС не
происходит, выводится сообщение от сбойного оборудования и код ошибки.

Если все тесты пройдены - запускается ОС. В ходе загрузки может возникнуть
синий экран смерти с кодом ошибки. Если синего экрана не было - выводится
приветствие.

Технически

Точка входа находится в классе Simulator.
Основной класс - PC. В него входит все остальное оборудование.
Остальное оборудование наследуется от класса PeripherialBase.
В базовом классе генератор случайных чисел и метод самопроверки.
В ходе самопроверки генерируется случайное число: если оно < 8 -
тест считается пройденым. Иначе тест не пройден, выводится сообщение
о сбое и код ошибки.
* Число 8 было выбрано для увеличеняи вероятности успешного итога теста.
В классах-наследниках вызывается метод самопроверки базового класса с
различной текстовой информацией.
Вероятность загрузки ОС определяется способом, аналогичным самотестированию
периферийного оборудования.