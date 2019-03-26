# spring

@configuration   @bean

元注解

默认bean名字首字母小写

这种方法定义内部bean依赖只使用与@Configuration类中的@Bean方法。你不可以在普通的@Component类中定义内部bean依赖。


因为@Configuration是@Component的一个元注解，基于@Configuration类会自动被组件扫描发现


◆@configuration = <beans></beans>
@component =<bean></bean>放在类上
@bean = <bean></bean> 放在方法上
