// 1. В программе должен быть минимум один класс со следующими свойствами: id игрушки, текстовое название,
//    количество, частота выпадения игрушки (вес в % от 100)
// 2. Метод добавление новых игрушек
// 3. Метод изменения веса (частоты выпадения игрушки)
// 4. Возможность организовать розыгрыш игрушек. Например, следующим образом:
// С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
// Это список призовых игрушек, которые ожидают выдачи. Еще у нас должен быть метод – получения призовой игрушки.
// После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. 
// А эту игрушку записываем в текстовый файл.
// Не забываем уменьшить количество игрушек

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class shop {
    public static void main(String[] args) {
        List<toy> toys = new ArrayList<toy>();
        toy toy1 = new toy("doll", 1, 1, 10);
        toy toy2 = new toy("car", 2, 2, 40);
        toy toy3 = new toy("constructor", 3, 3, 50);
        toy toy4 = new toy("pazzle", 4, 1, 2);
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);
        toy1.frequency = toy1.change(20);

        //Создаем список игрушек в зависимости от их количества
        List <String> toyss = new ArrayList<String>();
        for (int i = 0; i < toys.size(); i++) {
            for (int j = 0; j < toys.get(i).count; j++) {
                toyss.add(toys.get(i).name);
            }
        }
        
        //Генерируем случаное число при розыгрыше, записываем его в список, если оно уже там есть (=игрука
        // разыграна, то ничего не происходит, если его там нет, то по индексунходится выигрышная игрушка,
        //записываем результат в файл)
        List <Integer> numbers = new ArrayList<Integer>();
        while (numbers.size()<toyss.size()) {
            int a = rundomNumber(toyss.size());
            if (numbers.contains(a)){
            }
            else {
                numbers.add(a);
                writeToFile(toyss.get(a));
            }
        }
    }

    //Генератор рандомных чисел
    private static int rundomNumber(int countNumber) {
        int a = (int) (Math.random() * countNumber);
        return a;
    }

    //Задаем формат вывода в файл
    private static void writeToFile(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LoteryResult.txt", true))){
            writer.write("Вы выиграли игрушку  " + name);
            writer.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}