package org.dragonpulse.rnd.progress.repository.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonSavingStatusTest {

    @Mock
    PersonSavingStatus personSavingStatus;

    @Before
    public void setup() throws Exception{
        personSavingStatus = Mockito.mock(PersonSavingStatus.class);
        when(personSavingStatus.getRequestId()).thenReturn("123456789");
        when(personSavingStatus.getStatus()).thenReturn("10");
    }

    @Test
    public void getRequestId() {
        Assert.assertEquals(personSavingStatus.getRequestId(),"123456789");
    }

    @Test
    public void getStatus() {
        Assert.assertEquals(personSavingStatus.getStatus(),"10");
    }
}