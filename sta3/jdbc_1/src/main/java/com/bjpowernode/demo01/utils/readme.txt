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

           public static Connection connection;
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
        4、id暂时为Integer,且需要在第一行。。。
