package springcloud.ceQualifier;

/**
 * Created by 10326 on 2020/1/11.
 */
public class User {

    private String name;

    public User(){}
    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
