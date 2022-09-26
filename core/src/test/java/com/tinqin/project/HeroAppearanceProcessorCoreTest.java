package com.tinqin.project;

import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.processor.HeroBiographyProcessorCore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HeroAppearanceProcessorCoreTest {
    @Mock
    private HeroClient heroClient;

    @Mock
    private HeroCrudClient heroCrudClient;

    @InjectMocks
    private HeroBiographyProcessorCore heroBiographyProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess(){
        
    }


}
