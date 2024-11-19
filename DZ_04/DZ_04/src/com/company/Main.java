package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        String[] str1 = {"Hello World!", "Test"};
        Collections.addAll(list1, str1);
        System.out.println(list1);

        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);

        List<String> list3 = new ArrayList<>(Arrays.asList("4321", "123"));
        System.out.println(list3);

        int middle = list2.size() / 2;
        list2.addAll(middle, list3);
        System.out.println(list2);

        Collections.reverse(list2);
        System.out.println(list2);

        ListIterator<String>iterator = list2.listIterator();
        boolean flag = false;
        while (iterator.hasNext()){
            iterator.next();
            if(flag){
                iterator.remove();
            }
            flag = !flag;
        }
        System.out.println(list2);

        System.out.println("_".repeat(20) + "HASH" + "_".repeat(20));

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, "Test", "Abc", "hello","|");

        set.addAll(list1);
        set.addAll(list2);
        System.out.println(set1);
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set.addAll(list2);
        set.addAll(list3);
        System.out.println(set);

        System.out.println("_".repeat(20) + "MAP" + "_".repeat(20));

        LinkedHashMap<Integer,String> map1 = new LinkedHashMap<>();
        map1.put(1,"Январь");
        map1.put(2,"Февраль");
        map1.put(3,"Март");
        map1.put(4,"Апрель");
        map1.put(5,"Май");
        map1.put(6,"Июнь");
        map1.put(7,"Июль");
        map1.put(8,"Август");
        map1.put(9,"Сентябрь");
        map1.put(10,"Октябрь");
        map1.put(11,"Ноябрь");
        map1.put(12,"Декабрь");

        System.out.println("Первый : " + map1.get(1));
        System.out.println("Последний : " + map1.get(12));

        map1.put(6,"ОТПУСК");
        System.out.println("6 месяц : " + map1.get(6));

        HashMap<Integer,String> map2 = new HashMap<>();
        map2.putAll(map1);

        printMap(map1);
        printMap(map2);

        LinkedHashMap<String,Set<String>> map3 = new LinkedHashMap<>();
        map3.put("Ivan Ivanov",new HashSet<>(Arrays.asList("ivan@gmail.com","+38098096123")));
        map3.put("Petr Petrov",new HashSet<>(Arrays.asList("petr@gmail.com","+38583902124")));

        System.out.println("Students : ");
        for (Map.Entry<String,Set<String>> entry : map3.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("_".repeat(20) + "User" + "_".repeat(20));

        HashSet<User> userSet = new HashSet<>();
        User user1 = new User("Ivan",32,"+380284201");
        User user2 = new User("Ivan",32,"+380284201");
        User user3 = new User("Ivan",52,"+380284201");
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        System.out.println("Users : ");
        for (User user : userSet){
            user.print();
        }
        System.out.println("HashCode override : ");
        for (User user : userSet){
            user.print();
        }
    }

    public static void printMap(Map<Integer,String> map){
        System.out.println("Map : ");
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static class User{
        private String Name;
        private int Old;
        private String Phone;

        public User(String name,int old,String phone){
            this.Name = name;
            this.Old = old;
            this.Phone = phone;
        }

        @Override
        public int hashCode() {
            return Name != null ? Name.hashCode() : 0;
        }

        public void print(){
            System.out.println("[" + this.Name + "," + this.Old + "," + this.Phone + "]");
        }

        public String getName() {
            return Name;
        }

        public int getOld() {
            return Old;
        }

        public String getPhone() {
            return Phone;
        }
    }
}
