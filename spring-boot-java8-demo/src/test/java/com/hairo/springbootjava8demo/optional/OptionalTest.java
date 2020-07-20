package com.hairo.springbootjava8demo.optional;

import com.google.common.collect.Lists;
import com.hairo.springbootjava8demo.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Hairo
 * @date 2020/7/17 9:09
 */
public class OptionalTest {

    @Test
    public void optionalTest(){
//        String str = "8888";
//        //使用  of() 和 ofNullable() 方法创建包含值的 Optional。两个方法的不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException
//        Optional<String> s = Optional.ofNullable(str);
//        System.out.println(s);
//        //从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法,这个方法会在值为 null 的时候抛出异常
//        System.out.println(s.get());
//        Assert.assertEquals("8888",s.get());
//        Assert.assertTrue(s.isPresent());
//        //检查是否有值的另一个选择是 ifPresent() 方法。该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式
//        s.ifPresent(s1-> System.out.println(s1+"---"));
//        String s1 = Optional.ofNullable(str).orElse("默认值");
//        System.out.println(s1);
//        str  = null;
//        // orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果
//        s1 = Optional.ofNullable(str).orElseGet(() -> s.get());
//        System.out.println(s1);



        User user = User.builder().userName("----").build();
        String strNull = null;
        String t = Optional.ofNullable(user).map(u -> u.getUserName()).orElse("默认");
        System.out.println(t +"<-");
        //转换值 map() 和 flatMap()
        String userNam = Optional.ofNullable(user).map(u->u.getUserName()).orElse("默认");
        System.out.println(userNam);
        userNam = Optional.ofNullable(user).flatMap(u -> Optional.ofNullable(u.getUserName())).orElse("默认");
        System.out.println(userNam);

        //filter() 过滤值
        List<User> userList = new ArrayList<>(3);
        userList.add(User.builder().userName("Hairo-1").build());
        userList.add(User.builder().userName("Hairo-2").build());
        userList.add(User.builder().userName("Hairo-3").build());
        userList.add(User.builder().build());
        userList.add(User.builder().userName("Hairo-4").build());
        List<User> users = Optional.ofNullable(userList).filter(u -> Objects.isNull(user.getUserName())).orElse(Lists.newArrayList());
//        Optional.ofNullable(users).ifPresent(uList -> uList.forEach(u-> System.out.println(u.getUserName())));
//        System.out.println();

        System.out.println(this.t(userList));

    }

    private Boolean t (List<User> userList){
        Optional.ofNullable(userList).ifPresent(userArray -> {
            userArray.forEach(u -> System.out.println(u.getUserName()));
            return; 
        });
        return true;
    }
}
