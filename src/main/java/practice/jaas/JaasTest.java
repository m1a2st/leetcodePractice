package practice.jaas;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Path;
import java.security.PrivilegedAction;

@SuppressWarnings("removal")
public class JaasTest {
    
    public static void main(String[] args) throws LoginException, IOException {
        String jaasConf = Path.of("src/main/java/practice/jaas/JaasTest.java").toAbsolutePath().toString();
        System.setProperty("java.security.auth.login.config", jaasConf);

        MyCallbackHandler myCallbackHandler = new MyCallbackHandler("abc", "123456");
        
        LoginContext loginContext = new LoginContext("MyLogin", myCallbackHandler);
        loginContext.login();

        Subject subject = loginContext.getSubject();
        Subject.doAsPrivileged(subject, (PrivilegedAction<Object>) () -> {
            System.setProperty("demo", "demo value");
            System.out.println(System.getProperty("demo"));
            return null;
        }, null);
        loginContext.logout();
    }
}
