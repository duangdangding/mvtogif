package com.lsh.app.mvtogif;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 监听Bean数量
 */
@Component("ProgressBeanPostProcessor")
public class ProgressBeanPostProcessor implements BeanPostProcessor, ApplicationListener<ContextRefreshedEvent> {
private Integer beanConut = 10;
    private AtomicInteger count = new AtomicInteger(0);
    private final static Subject<Integer> beans = BehaviorSubject.create();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //最终应该设置的total值
        System.out.println("total:");
        System.out.println(count.get());
        beans.onComplete();

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        返回的是加1后的值
        count.incrementAndGet();
        beans.onNext(count.get()*100/beanConut);
        return bean;
    }

    public static Subject<Integer> observe() {
        return beans;
    }

}
