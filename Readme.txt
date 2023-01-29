Steps to make mybatis work by annotation:
1, Add mybatis starter and mysql dependencies in pom.xml:
    <dependency>
         <groupId>org.mybatis.spring.boot</groupId>
         <artifactId>mybatis-spring-boot-starter</artifactId>
         <version>3.0.0</version>
    </dependency>
    <dependency>
         <groupId>com.mysql</groupId>
         <artifactId>mysql-connector-j</artifactId>
         <scope>runtime</scope>
    </dependency>
2, Configure datasource in application.properties or application.yml file.
       ## MySQL
       spring.datasource.url=jdbc:mysql://localhost:3306/user_db
       spring.datasource.username=root
       spring.datasource.password=root
3, Create mapper interface class by using @Mapper annotation.
   Spring boot framework will scan and create bean for you, and automatically make implementation class work which use
   session factory and statement make database call.
       @Mapper
       public interface UserMapper {
           @Select("select * from users")
           List<User> findUsers();

           @Select("select * from users where id = #{id}")
           User findUserById(Integer id);
       }
4, Create POJO class and inject mapper class to where you use and make function call.
       public class UserController {
           UserMapper userMapper;
           public UserController(UserMapper userMapper){
               this.userMapper = userMapper;
           }
           @RequestMapping("/users")
           public List<User> getAllUsers(){
               return userMapper.findUsers();
           }
       }

       field @AutoWired is not recommended.