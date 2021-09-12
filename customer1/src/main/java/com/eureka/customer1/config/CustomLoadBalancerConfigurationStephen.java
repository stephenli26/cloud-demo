package com.eureka.customer1.config;

//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
//import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;

//这里 不需要 @configuration注解  不需要 不需要
public class CustomLoadBalancerConfigurationStephen {

//    @Bean
//    ReactorLoadBalancer<ServiceInstance> randomLoadBalancerStephen(Environment environment,
//            LoadBalancerClientFactory loadBalancerClientFactory) {
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//
//        return new RandomLoadBalancer(loadBalancerClientFactory
//                .getLazyProvider(name, ServiceInstanceListSupplier.class),
//                name);
//    }
}