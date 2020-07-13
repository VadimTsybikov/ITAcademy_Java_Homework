package core;

public class Animal {
    private byte age;
    private String nick;

    public Animal(byte age, String nick) {
        this.age = age;
        this.nick = nick;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}