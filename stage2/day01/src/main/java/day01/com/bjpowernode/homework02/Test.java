package day01.com.bjpowernode.homework02;

/**
 * @author feng
 * @date 2020/12/18
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        Company<Employee> emp = new Company<>();
        for (int i = 0; i < data.length; i++) {
            emp.add(new Employee(data[i]));
        }
        System.out.println(emp);




    }


}
