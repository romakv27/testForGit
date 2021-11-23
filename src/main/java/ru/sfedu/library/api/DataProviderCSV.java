package ru.sfedu.library.api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.library.entity.User;
import ru.sfedu.library.entity.enums.Outcomes;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.entity.enums.Outcomes.*;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderCSV implements IDataProvider{

    private static final Logger log = LogManager.getLogger(DataProviderCSV.class);


    /**
     * @param user
     */
    @Override
    public Outcomes createUser(User user) {

        return getUserById(user.getId()).map(exist -> EXISTS).orElseGet(() -> execute(CSV_USER, singletonList(user), true));


    }

    /**
     * @param userId
     */
    @Override
    public Optional<User> getUserById(Long userId) {
        return findAll(CSV_USER, User.class).stream().filter(o -> o.getId().equals(userId)).findFirst();
    }

    /**
     * @param user
     */
    @Override
    public Outcomes updUser(User user) {
        return execute(CSV_USER, findAll(CSV_USER, User.class).stream().map(o -> o.getId().equals(user.getId()) ? user: o).collect(Collectors.toList()), false);
    }

    /**
     * @param userId
     */
    @Override
    public Outcomes delUserById(Long userId) {
        return execute(CSV_USER, findAll(CSV_USER, User.class).stream().filter(o -> !o.getId().equals(userId)).collect(Collectors.toList()), false);
    }

    protected <T> Outcomes execute(String key, List<T> list, boolean append) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(getConfigurationEntry(key), append));
            new StatefulBeanToCsvBuilder<T>(csvWriter).build().write(list);
            csvWriter.close();
            return OK;
        } catch (Exception exception) {
            log.error(exception);
            return ERROR;
        }
    }

    public <T> List<T>
    findAll(String key, Class<T> c) {
        List<T> list = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(getConfigurationEntry(key)));
            list = new CsvToBeanBuilder<T>(csvReader).withType(c).build().parse();
            csvReader.close();
        } catch (Exception exception) {
            log.error(exception);
        }
        return list;
    }
}
