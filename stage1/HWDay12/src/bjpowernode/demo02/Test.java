package bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        User user = new User();
        user.setUserId("123456789012345678");
        user.setUserName("Jack");
        user.setPassword("123456");
        user.setUserPhone("12345678901");
/*

        String userName = user.getUserName();
        String password = user.getPassword();
        String userId = user.getUserId();
        String userPhone = user.getUserPhone();
*/

        System.out.println(user);
    }
}
