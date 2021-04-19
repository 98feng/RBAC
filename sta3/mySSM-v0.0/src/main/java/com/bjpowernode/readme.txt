     1、ApplicationContext<?> applicationContext = new ApplicationContext<>();
        ApplicationContext.initContextByAnnotation();
        Object servImpl = applicationContext.getBean(ActivityService.class);
        ActivityService as = (ActivityService) ServiceFactory.getService(servImpl);

     2、@Bean
        public class ActivityServiceImpl implements ActivityService {

           public ActivityServiceImpl() {}

           @AutoWrite
           DeptDao dd;
           ...
        }

        @Bean
        public class DeptDaoImpl implements DeptDao {
            public DeptDaoImpl() {}
            ...
        }

     3、public class MyInvocationHandler implements InvocationHandler {

           private Object target;

           private static Connection connection;
        }
        Field field = classManager.getDeclaredField("connection");
        ...
        }

     4、 Integer deptno;
         String dname;
         String loc;
         ...

        1、业务层采用动态代理提交事务，Controller层不要去显示new Service()
        2、提供空参构造器，方便反射newInstance()
        3、不要修改connection变量名字，要改一起改
        4、id暂时为Integer,且需要在第一行。。。
        5、pom文件
        <properties>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
            </properties>

            <dependencies>
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.11</version>
                    <scope>test</scope>
                </dependency>

                <!--用于实例类-->
                <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <version>1.18.8</version>
                    <scope>provided</scope>
                </dependency>


                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>5.1.23</version>
                </dependency>

                <dependency>
                    <groupId>log4j</groupId>
                    <artifactId>log4j</artifactId>
                    <version>1.2.17</version>
                </dependency>

                <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>druid</artifactId>
                    <version>1.2.4</version>
                </dependency>


                <dependency>
                    <groupId>commons-dbutils</groupId>
                    <artifactId>commons-dbutils</artifactId>
                    <version>1.7</version>
                </dependency>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter</artifactId>
                    <version>RELEASE</version>
                    <scope>compile</scope>
                </dependency>

            </dependencies>
            <build>
                <resources>
                    <resource>
                        <directory>src/main/java</directory><!--所在的目录-->
                        <includes><!--包括目录下的.properties,.xml文件都会扫描到-->
                            <include>**/*.*</include>
                        </includes>
                        <filtering>false</filtering>
                    </resource>
                </resources>
            </build>
