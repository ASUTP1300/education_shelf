package ru.bee.arcollection.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@Service
public class TestService {
//    private final ActionBlockRequestService actionBlockService;

//    public TestService(ActionBlockRequestService actionBlockService) {
//        this.actionBlockService = actionBlockService;
//    }

}


interface BeanDemoComponent {
    public Long calc(Long val);
}

@Component
@Slf4j
class BeanDemoComponentImpl implements BeanDemoComponent {
    public BeanDemoComponentImpl() {
        System.out.println("BeanDemoComponentImpl constructor");
    }

    @Override
    public Long calc(Long val) {
        return 1L;
    }
}

@Component
@Primary
@Slf4j
class BeanDemoComponentOtherImpl implements BeanDemoComponent {

    @Autowired
    private BeanDemoComponent beanDemoComponent;

    public BeanDemoComponentOtherImpl() {
        System.out.println("BeanDemoComponentOtherImpl constructor");
    }

    @Override
    public Long calc(Long val) {
        return beanDemoComponent.calc(val) * 2L;
    }

    @PostConstruct
    void test() {
        System.out.println("HH");;
    }
}

@RestController
@RequestMapping("BeanDemoRest")
@Slf4j
class BeanDemoRest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BeanDemoComponent beanDemoComponent;

    public BeanDemoRest() {
        System.out.println("BeanDemoRest constructor");

    }

    @GetMapping("/callBean/{id}")
    public Long callBean(@PathVariable Long id) {
        System.out.println("callBean start");
        var res = beanDemoComponent.calc(id);
        System.out.println("callBean done");
        return res;
    }

    @PostConstruct
    void test() {
        applicationContext.getApplicationName();
    }
}