package com.bjpowernode.day08.homework;

import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/25
 * @Description
 */
public class HomeWork01 {
    /**
     * @param
     * @return
     * @Description 1 已知数组存放一批QQ号码，QQ号码最长为11位，
     * 最短为5位String[] strs = {"12345","67891","12347809933",
     * "98765432102", "67891", "12347809933"}。将该数组里面的所有qq号都存放在List中，
     * 将list中重复元素删除，将list中所有元素分别用迭代器和增强for循环打印出来。
     * @date 2020/12/25
     */
    @Test
    public void test() {
        String[] strs = {"12345", "67891", "12347809933", "98765432102", "67891", "12347809933"};

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (!list.contains(strs[i])) {
                list.add(strs[i]);
            }
        }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
        }

    }

    /**
     * @param
     * @return
     * @Description 2 双色球投注区分为红色球号码区和蓝色球号码区，
     * 红色球号码区由1-33共三十三个号码组成，蓝色球号码区由1-16共十六个号码组成。
     * 投注时选择6个红色球号码和1个蓝色球号码组成一注进行单式投注. 请随机生成一注双色球号码。（要求同色号码不重复）
     * @date 2020/12/25
     */
    @Test
    public void test01() {

        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();

        /*生成两个不重复随机数分别加入对应的红蓝集合*/
        Random random = new Random();
        for (int j = 0; j < 33; j++) {
            int randNum1 = (random.nextInt(33) + 1);
            int randNum2 = (random.nextInt(16) + 1);

            if (blue.size() < 17 && !blue.contains(randNum2)) {
                blue.add(randNum2);
            }
            if (!red.contains(randNum1)) {
                red.add(randNum1);
            }
        }
        /*看一下红色和蓝色是哪个*/
        /*StringBuilder sb = new StringBuilder();
        sb.append("red:").append(red.subList(0, 6)).append("blue:").append(blue.get(0));
        System.out.println(sb);*/

        /*将两种随机球放入新的集合随后乱序*/
        List<Integer> towColor = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            towColor.add(red.get(i));
        }
        towColor.add(blue.get(0));

        Collections.shuffle(towColor);

        System.out.println(towColor);
    }

    /**
     * @param
     * @return
     * @Description 3定义Student类, 有学号, 班级, 成绩三个字段
     * 创建Set集合, 保存20个Student对象, 每个对象的属性随机生成, 要求集合中Student对象的学号中唯一的
     * 遍历集合, 找出最高分,最低分同学的信息
     * @date 2020/12/25
     */
    @Test
    public void test03() {
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore().equals(o2.getScore())) {
                    return o1.getNo().compareTo(o2.getNo());
                }
                return -o1.getScore().compareTo(o2.getScore());
            }
        });
        /*为20个对象成员变量随机赋值*/
        for (int i = 0; i < 20; i++) {
            treeSet.add(CommonUtil.initClassInfo(Student.class));
        }

        //定义两个集合分别存放最高分和最低分的学生
        List<Student> maxList = new ArrayList<>();
        List<Student> minList = new ArrayList<>();

        Student first = treeSet.first();
        Student last = treeSet.last();

        //找出和最高分相等的学生
        for (Student student : treeSet) {
            if (student.getScore().equals(first.getScore())) {
                maxList.add(student);
            } else {
                break;
            }
        }
        //逆序遍历找出和最低分并列的学生
        Iterator<Student> studentIterator = treeSet.descendingIterator();
        while (studentIterator.hasNext()) {
            Student next = studentIterator.next();
            if (next.getScore().equals(last.getScore())) {
                minList.add(next);
            } else {
                break;
            }
        }

        System.out.println("maxScore:" + maxList);
        System.out.println("minScore:" + minList);
        System.out.println("=======================");
        for (Student next : treeSet) {
            System.out.println(next);
        }
    }

    /**
     * 4 有字符串”adfajklfjlksfjakljfajfaadsfasfjadlkfsjlsfjslkjflfsjlfj”
     * 统计每个字符在字符串中出现的次数, 把结果保存到Map集合中, 打印结果
     */
    @Test
    public void test04() {

        String str = "adfajklfjlksfjakljfajfaadsfasfjadlkfsjlsfjslkjflfsjlfj";
        /*不需要转换为数组*/
//        char[] cc = str.toCharArray();
        HashMap<Character, Integer> amp = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            /*if(!amp.containsKey(cc)){
                amp.put(cc,1);
            }else{
                Integer count = amp.get(cc);
                amp.replace(cc,count + 1);
            }*/
            amp.put(cc, !amp.containsKey(cc) ? 1 : amp.get(cc) + 1);
        }

        for (Character key : amp.keySet()) {
            System.out.println(key + "出现的次数：" + amp.get(key));
        }

        /*for (Map.Entry<Character, Integer> entry : amp.entrySet()) {
            System.out.println(entry.getKey() + "出现的次数：" + entry.getValue());
        }*/
    }

    /***
     * 3 定义Map保存<课程名称,任课教师姓名>
     * 	添加若干数据
     * 	使用foreach循环遍历所有课程及任课老师
     * 	判断是否开设了劳动课
     * 	判断feifei老师是否有任课
     * 	查看体育课老师是谁
     * 	把语文课老师替换为 杨老师
     * 	删除英语课
     * 	查看所有的课程
     */
    @Test
    public void test05() {
        HashMap<String, String> map = new HashMap<>();
        map.put("yuwen", "zhangsan");
        map.put("laodong", "feifei");
        map.put("tiyu", "lisi");
        map.put("yingyu", "laoyang");
        map.put("java", "laoyang");

        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry);
        }

        System.out.println(map.containsKey("laodong"));
        System.out.println(map.containsValue("feifei"));

        System.out.println(map.get("tiyu"));

        map.put("yuwen", "laoyang");
        map.remove("yingyu");

        System.out.println(map.keySet());
    }


}
