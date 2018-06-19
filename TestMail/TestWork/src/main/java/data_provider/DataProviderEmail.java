package data_provider;

import data_sources.DataSource;
import org.testng.annotations.DataProvider;

public class DataProviderEmail {

    @DataProvider(name = "wordsMail")
    public static Object[][] createStrings() {
        return  new DataSource().getDataSource();
        }
    }

