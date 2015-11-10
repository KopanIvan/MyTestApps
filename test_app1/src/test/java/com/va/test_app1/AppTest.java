package com.va.test_app1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private static Logger log = Logger.getLogger(AppTest.class.getName());
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	
    	// считывание конфигурации логера из файла
    	try {
            LogManager.getLogManager().readConfiguration(
                    AppTest.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
        	System.err.println("Could not setup logger configuration: " + e.toString());
        }

    	App testApp = new App();   	
    	
    	// создаем локали(ru и en) и устанавливаем их переменной currentBundle объекта testApp
    	Locale russianLocale = new Locale("ru", "RU");
    	testApp.currentBundle = ResourceBundle.getBundle("HelloMessageBundle", russianLocale);
    	
    	// проверяем идентичность полученной и исходной строк
    	assertEquals(testApp.prepareMessage(6), "Доброе утро, Мир!");
    	assertEquals(testApp.prepareMessage(7), "Доброе утро, Мир!");
    	assertEquals(testApp.prepareMessage(8), "Доброе утро, Мир!");
    	
    	assertEquals(testApp.prepareMessage(9), "Добрый день, Мир!");
    	assertEquals(testApp.prepareMessage(11), "Добрый день, Мир!");
    	assertEquals(testApp.prepareMessage(18), "Добрый день, Мир!");
    	
    	assertEquals(testApp.prepareMessage(19), "Добрый вечер, Мир!");
    	assertEquals(testApp.prepareMessage(20), "Добрый вечер, Мир!");
    	assertEquals(testApp.prepareMessage(22), "Добрый вечер, Мир!");
    	
    	assertEquals(testApp.prepareMessage(23), "Доброй ночи, мир!");
    	assertEquals(testApp.prepareMessage(1), "Доброй ночи, мир!");
    	assertEquals(testApp.prepareMessage(5), "Доброй ночи, мир!");
    	
    	log.info("протестирована русская локаль");
    	
    	Locale englishLocale = new Locale("en", "US");
    	testApp.currentBundle = ResourceBundle.getBundle("HelloMessageBundle", englishLocale);
    	
    	assertEquals(testApp.prepareMessage(6), "Good morning, World!");
    	assertEquals(testApp.prepareMessage(7), "Good morning, World!");
    	assertEquals(testApp.prepareMessage(8), "Good morning, World!");
    	
    	assertEquals(testApp.prepareMessage(9), "Good day, World!");
    	assertEquals(testApp.prepareMessage(11), "Good day, World!");
    	assertEquals(testApp.prepareMessage(18), "Good day, World!");
    	
    	assertEquals(testApp.prepareMessage(19), "Good evening, World!");
    	assertEquals(testApp.prepareMessage(20), "Good evening, World!");
    	assertEquals(testApp.prepareMessage(22), "Good evening, World!");
    	
    	assertEquals(testApp.prepareMessage(23), "Good night, World!");
    	assertEquals(testApp.prepareMessage(1), "Good night, World!");
    	assertEquals(testApp.prepareMessage(5), "Good night, World!");
    	
    	log.info("протестирована английская локаль");
    	
    }
}
