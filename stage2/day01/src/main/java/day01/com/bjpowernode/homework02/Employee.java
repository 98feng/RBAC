package day01.com.bjpowernode.homework02;

/**
 * @author feng
 * @date 2020/12/18
 * @Description 员工类, 有姓名,年龄, 工资等属性
 */
public class Employee implements Comparable<Employee> {

    String eName;
    int eAge;
    String eSal;
    String eAddr;

    public Employee(int eAge) {
        this.eAge = eAge;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("eName='").append(eName).append('\'');
        sb.append(", eAge='").append(eAge).append('\'');
        sb.append(", eSal='").append(eSal).append('\'');
        sb.append(", eAddr='").append(eAddr).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Employee( String eName, int eAge, String eSal, String eAddr) {
        this.eName = eName;
        this.eAge = eAge;
        this.eSal = eSal;
        this.eAddr = eAddr;
    }

    public Employee() {
    }

    public Employee(String eName) {
        this.eName = eName;
    }
    @Override
    public int compareTo(Employee e) {
    /*    if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.eName.compareTo(e.eName);
        }
        throw new RuntimeException("数据类型不一致！");
    }*/
            return eAge - e.eAge;
    }
}
