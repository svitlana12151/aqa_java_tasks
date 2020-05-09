package lesson2;

public class User {
    private int age;
    private String name;
    public String nameGroup;

    /*public User(int age, String name, String nameGroup) {  //constructor1
        this.age = age;
        this.name = name;
        this.nameGroup = nameGroup;
    }*/

    public User(){  //constructor2
    }

    public void setAge(int age) {                 //сеттер для age
        if (age >= 0 && age <= 100) {             // age не може бути менше 0 та максимальне значення = 100
            this.age = age;
        } else {
            System.out.println("Age is incorrect");
        }
    }

    private int getAge() {                       //геттер для age
        return this.age;
    }

    public void setName(String name) {                          //сеттер для name
        if (name.length() >= 3 && name.length() <= 50) {         //значение name не может быть короче чем 3 символа и длиннее чем 50 символов
            this.name = name;
        } else if (name.length() < 3) {
            System.out.println("Name is too short");
        }
        if (name.trim().length() > 0) {                                  //name не может состоять из одних только пробелов
            this.name = name;
        } else {
            this.name = "invalid";
            System.out.println("Name can't includes spaces only");
        }
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1); //не зависимо от того ввел пользователь имя с большой или с маленькой буквы, оно должно быть записано в переменную name с большой буквы
    }

    public String getName() {         //геттер для name

        return name;
    }

       public String getNameGroup() {                       //геттер для nameGroup
        if (age >= 0 && age < 15) {
            return nameGroup = "child";                   //ageGroup должен устанавливаться автоматически при установке возраста
        } else if (age >= 15 && age <= 25) {
            return nameGroup = "student";
        } else if (age >= 26 && age <= 65) {
             return nameGroup = "worker";
        } else {
            return nameGroup = "pensioner";
        }
    }

    public void getUserInfo() {
        System.out.println("User1 age is: " + getAge() + ", name is: " + getName() + ", group is: " + getNameGroup());
    }
}
