package domain;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    private Integer age;

    public Customer(String id, String name, String email, String mobileNumber, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
    }
}
