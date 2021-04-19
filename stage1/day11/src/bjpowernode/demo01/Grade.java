package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 年级
 */
public class Grade {

    /**
     * 班级编号
     */
    String gradeId;
    /**
     * 班级名称
     */
    String gradeName;
    /**
     * 班级地址
     */
    String gradeAddr;

    public Grade() {
    }

    public Grade(String gradeId, String gradeName, String gradeAddr) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeAddr = gradeAddr;
    }

    @Override
    public String toString() {
        return "gradeId='" + gradeId + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", gradeAddr='" + gradeAddr + '\'';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("等待回收.........." + this);
        super.finalize();
    }
}
