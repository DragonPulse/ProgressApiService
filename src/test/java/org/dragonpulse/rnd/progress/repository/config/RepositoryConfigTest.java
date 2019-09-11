package org.dragonpulse.rnd.progress.repository.config;

import org.dragonpulse.rnd.progress.repository.DefaultStatusRepositoryImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryConfigTest {

    @Mock
    private DefaultStatusRepositoryImpl defaultStatusRepository;

    @Before
    public void setUp() throws Exception {
        defaultStatusRepository = new DefaultStatusRepositoryImpl();
    }

    @Test
    public void defaultStatusRepo() {
        Assert.assertNotNull(defaultStatusRepository);

    }
}