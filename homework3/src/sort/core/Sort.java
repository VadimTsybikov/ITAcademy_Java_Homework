package sort.core;

import java.util.Arrays;

public class Sort {
    //сортировка выбором
    public static void arraySelectionSort(int[] _array) {
        //сортируемый диапазон массива постепенно сужается с конца
        for (int i = _array.length - 1; i > 0; i--) {
            //инициализитуем текущее значение на итерации сортировки
            int max = _array[0];
            int maxPos = 0;

            //находим максимальное значение в оставшемся диапазоне массива
            for (int j = 1; j <= i; j++) {
                if (max < _array[j]) {
                    max = _array[j];
                    maxPos = j;
                }
            }

            //меняем местами найденное значение с последним элементом текущего диапазона
            int tmp = _array[i];
            _array[i] = _array[maxPos];
            _array[maxPos] = tmp;
        }
    }

    //сортировка с использованием вставок
    public static void arrayInclusionSort(int[] _array) {
        for (int i = 1; i < _array.length; i++) {
            //инициализируем текущее значение на итерации сортировки
            int val = _array[i];
            int valPos = i;

            //смещаем все младщие позиции вверх, пока очередной элемент не будет меньше текущего либо достигнуто начало массива
            while ((valPos > 0) && (_array[valPos - 1] > val)) {
                _array[valPos] = _array[valPos - 1];
                valPos--;
            }

            //переносим текущеее значение в определившуюся позицию
            _array[valPos] = val;
        }
    }

    //сортировка слиянием (метод возвращает результат для использования в порождающих итерациях рекурсии)
    public static int[] arrayMergeSort(int[] _array) {
        int part1Length = _array.length / 2;        //размерность первой сортируемой части

        //копирование первой части в отдельный массив
        int[] part1 = Arrays.copyOfRange(_array, 0, part1Length);
        if (part1.length > 1)
            //сортируем рекурсимно, если в массиве больше 1-го элемента
            part1 = arrayMergeSort(part1);

        //аналогично для второй части
        int[] part2 = Arrays.copyOfRange(_array, part1Length, _array.length);
        if (part2.length > 1)
            part2 = arrayMergeSort(part2);

        int part1Top = 0;   //индекс верхнего элемента в первой части, доступного для сравнивания с аналогичным верхним элементов второй части
        int part2Top = 0;   //индекс верхнего элемента во второй части
        int arrayTop = 0;   //позиция в целом массиве, в которую следует писать очередной минимальный элемент из частей

        //сравнение верхних элементов обеих частей и перенос минимального элемента в целый массив
        //также переключение на следующие позиции во всех массивах
        while ((part1Top < part1.length) && (part2Top < part2.length)) {
            if (part1[part1Top] < part2[part2Top]) {
                _array[arrayTop++] = part1[part1Top++];
            }
            else {
                _array[arrayTop++] = part2[part2Top++];
            }
        }

        //запись остатка первой части, если есть
        while (part1Top < part1.length) {
            _array[arrayTop++] = part1[part1Top++];
        }

        //запись остатка второй части, если есть
        while (part2Top < part2.length) {
            _array[arrayTop++] = part2[part2Top++];
        }

        return _array;
    }

    //сортировка с помощью разделения (работает с оригинальным массивом, индексами указывается сортируемый диапазон)
    public static void arrayQuickSort(int[] _array, int _start, int _end) {
        if (_end - _start > 0) {
            int basePoint = _start + (_end - _start) / 2;   //опорная точка
            int baseVal = _array[basePoint];                //значение опорной точки

            //обработка части с начала до опорной точки
            int i = _start;
            while (i < basePoint) {
                //если текущее значение больше или равно опорному значению - перенести в часть после опорного элемента
                if (_array[i] >= baseVal) {
                    int curVal = _array[i];

                    //смещаем элементы между текущим и опорным вниз
                    for (int j = i; j < basePoint; j++) {
                        _array[j] = _array[j + 1];
                    }

                    //вставляем текущее значение в освободившуюся позицию
                    _array[basePoint] = curVal;

                    //корректируем опорную позицию
                    basePoint--;
                }
                else {
                    i++;
                }
            }

            //обработка части с конца до опорной точки
            i = _end;
            while (i > basePoint) {
                //если текущее значение меньше опорного значения - перенести в часть до опорного элемента
                if (_array[i] < baseVal) {
                    int curVal = _array[i];

                    //смещаем элементы между текущим и опорным вверх
                    for (int j = i; j > basePoint; j--) {
                        _array[j] = _array[j - 1];
                    }

                    //вставляем текущее значение в освободившуюся позицию
                    _array[basePoint] = curVal;

                    //корректируем опорную позицию
                    basePoint++;
                }
                else {
                    i--;
                }
            }

            //рекурсивная обработка частей до ...
            arrayQuickSort(_array, _start, basePoint - 1);
            //... и после опорного элемента
            arrayQuickSort(_array, basePoint + 1, _end);
        }
    }
}
