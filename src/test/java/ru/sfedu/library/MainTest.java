package ru.sfedu.library;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() throws IOException {
        String[] args=null;
        Main.main(args);
    }

    @Test
    void logBasicSystemInfo() {
        Main info = new Main();
        info.logBasicSystemInfo();
    }
}