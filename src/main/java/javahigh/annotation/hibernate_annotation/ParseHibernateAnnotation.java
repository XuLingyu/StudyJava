package javahigh.annotation.hibernate_annotation;

import java.lang.reflect.Method;

//hibernate有两种配置方式，分别是*.hbm.xml 配置方式 和注解方式。 虽然方式不一样，但是都是用于解决如下问题：
//1. 当前类是否实体类
//2. 对应的表名称
//3. 主键对应哪个属性， 自增长策略是什么，对应字段名称是什么
//4. 非主键属性对应字段名称是什么
//
//接下来，我会做一套仿hibernate的注解，并且在一个实体类Hero上运用这些注解，并通过反射解析这些注解信息，来解决上述的问题


//参考hibernate的 注解配置方式 ，自定义5个注解，分别对应hibernate中用到的注解：
//hibernate_annotation.MyEntity 对应 javax.persistence.Entity
//hibernate_annotation.MyTable 对应 javax.persistence.Table
//hibernate_annotation.MyId 对应 javax.persistence.Id
//hibernate_annotation.MyGeneratedValue 对应 javax.persistence.GeneratedValue
//hibernate_annotation.MyColumn 对应 javax.persistence.Column

public class ParseHibernateAnnotation {

	public static void main(String[] args) {

		Class<Hero> clazz = Hero.class;
		// 1. 确定是实体类
		// 2. 对应表
		// 3. 自增长id是，id策略是，对应字段是
		// 4. 其他属性对应字段是
		MyEntity myEntity = (MyEntity) clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("Hero类不是实体类");
		} else {
			System.out.println("Hero类是实体类");
			MyTable myTable= (MyTable) clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("其对应的表名是:" + tableName);
			Method[] methods =clazz.getMethods();
			Method primaryKeyMethod = null;
			for (Method m: methods) {
				MyId myId = m.getAnnotation(MyId.class);
				if(null!=myId){
					primaryKeyMethod = m;
					break;
				}
			}
			
			if(null!=primaryKeyMethod){
				System.out.println("找到主键：" + method2attribute( primaryKeyMethod.getName() ));
				MyGeneratedValue myGeneratedValue =
				primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("其自增长策略是：" +myGeneratedValue.strategy());
				MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("对应数据库中的字段是：" +myColumn.value());
			}
			System.out.println("其他非主键属性分别对应的数据库字段如下：");
			for (Method m: methods) {
				if(m==primaryKeyMethod){
					continue;
				}
				MyColumn myColumn = m.getAnnotation(MyColumn.class);
				//那些setter方法上是没有MyColumn注解的
				if(null==myColumn)
					continue;
				System.out.format("属性： %s\t对应的数据库字段是:%s%n",method2attribute(m.getName()),myColumn.value());

			}
			
			
			
		}
		

	}

	private static String method2attribute(String methodName) {
		String result = methodName; ;
		result = result.replaceFirst("get", "");
		result = result.replaceFirst("is", "");
		if(result.length()<=1){
			return result.toLowerCase();
		}
		else{
			return result.substring(0,1).toLowerCase() + result.substring(1,result.length());
		}
		
		
	}
}
