package com.springdrools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Singleton class that wraps
 * the Drools KieSession and is responsible
 * for loading rules and firing rules.
 */
public class RulesService {

    private KieServices ks;
    private KieContainer kContainer;
    private KieSession kieSession;

    @Bean("accountService")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RulesService getRulesService() {
        return new RulesService();
    }

    /**
     * Function to initialize the kieSession.
     * This will be initialized on
     * application startup.
     */
    public void initializeRules() {

        this.ks = KieServices.Factory.get();
        this.kContainer = ks.getKieClasspathContainer();
        this.kieSession =  kContainer.newKieSession();
    }
}
