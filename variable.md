```java
public class IdentifyRequest {
    String name;
    Integer birth;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth() {
        return birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }
}
```
- 使用generate get and set