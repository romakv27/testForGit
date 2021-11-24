package ru.sfedu.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.library.api.DataProviderCSV;
import ru.sfedu.library.api.IDataProvider;
import ru.sfedu.library.entity.User;

import java.io.IOException;

import static ru.sfedu.library.Constants.*;
import static ru.sfedu.library.entity.enums.Outcomes.OK;
import static ru.sfedu.library.utils.ConfigurationUtil.getConfigurationEntry;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class);

    public static void main(String []args) throws IOException {
        log.debug("Main[0]: starting application.........");
        log.info("info");
        log.error("error");
        log.debug(Constants.CONST);
        log.debug(getConfigurationEntry(SOUR));
        log.info(OK);
    }

    public void logBasicSystemInfo() {
        log.info("Launching the application...");
        log.info("Operating System: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
    }

    /**
     *
     * @param args
     */
    public static void cli(String[] args) {
        try {
            IDataProvider provider = selectDataProvider(args[0]);

            switch (args[1]) {
                case CLI_USER:
                    log.info(user(provider, args));
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + args[1]);
            }
        } catch (Exception exception) {
            log.error(exception);
        }
    }

    public static IDataProvider selectDataProvider(String str) {
        switch (str) {
            case IDP_CSV:
                return new DataProviderCSV();

            default:
                throw new IllegalStateException("Unexpected value: " + str);
        }
    }

    /**
     * @param provider
     * @param s
     * @return
     */
    public static String user(IDataProvider provider, String[] s) {
        switch (s[2]) {
            case USER_CREATE:
                return provider.createUser(new User(Long.parseLong(s[3]), s[4], s[5], Integer.parseInt(s[6]))).name();
            case USER_GET:
                return provider.getUserById(Long.parseLong(s[3])).map(User::toString).orElse("User is not");
            case USER_UPD:
                return provider.updUser(new User(Long.parseLong(s[3]), s[4], s[5], Integer.parseInt(s[6]))).name();
            case USER_DEL:
                return provider.delUserById(Long.parseLong(s[3])).name();
            default:
                throw new IllegalStateException("Unexpected value: " + s[2]);
        }
    }
}
