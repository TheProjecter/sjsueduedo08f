package edu.sjsu.edo08f;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import edu.sjsu.edo08f.dao.PersonDao;
import edu.sjsu.edo08f.domain.Person;

/**
 * Created by: Alex Yarmula
 * Date: Nov 10, 2008
 */
public class Main {

    public static void main (String[] args) {
        PersonDao personDao  = (PersonDao) getBeanFactory().getBean("personDao");
        Person person = personDao.getById(1L);
 
    }


    private static BeanFactory getBeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("config/application-config.xml"));

        return factory;
    }

}
