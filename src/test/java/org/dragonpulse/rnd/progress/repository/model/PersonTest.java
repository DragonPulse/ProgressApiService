package org.dragonpulse.rnd.progress.repository.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest {

    @Mock
    Person person;

    @Before
    public void setUp() throws Exception {
        person = Mockito.mock(Person.class);
        when(person.getName()).thenReturn("personName");
        when(person.getAge()).thenReturn("12");
        when(person.getPhoneNumber()).thenReturn("4567891234");
        when(person.getRequestId()).thenReturn("123456789");
    }

    @Test
    public void getName() {
        Assert.assertNotNull(person.getName());
    }

    @Test
    public void getAge() {
        Assert.assertNotNull(person.getAge());
    }

    @Test
    public void getPhoneNumber() {
        Assert.assertNotNull(person.getPhoneNumber());
    }

    @Test
    public void getRequestId() {
        Assert.assertNotNull(person.getRequestId());
    }


}