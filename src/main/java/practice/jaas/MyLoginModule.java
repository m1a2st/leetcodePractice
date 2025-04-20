package practice.jaas;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

public class MyLoginModule implements LoginModule {
    
    private Subject subject;
    private CallbackHandler callbackHandler;

    private Principal principal;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }
    
    @Override
    public boolean login() {
        try {
            NameCallback nameCallback = new NameCallback("user: ");
            PasswordCallback passwordCallback = new PasswordCallback("password: ", true);
            Callback[] callbacks = new Callback[] { nameCallback, passwordCallback};
            callbackHandler.handle(callbacks);
            String username = nameCallback.getName();
            String password = new String(passwordCallback.getPassword());

            return login(username, password);
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean login(String username, String password) {
        System.out.println("username=" + username + ",password=" + password);
        // 實際應用中，這裡會調用數據庫或其他認證服務來驗證用戶名和密碼
        if ("abc".equals(username) && "123456".equals(password)) {
            principal = new MyPrincipal(username);
            subject.getPrincipals().add(principal);
            return true;
        }
        return false;
    }

    /**
     * 登入成功的操作
     */
    @Override
    public boolean commit() {
        System.out.println("login success, commit");
        return true;
    }
    
    @Override
    public boolean abort() throws LoginException {
        return logout();
    }

    @Override
    public boolean logout() {
        if (subject != null && principal != null) {
            subject.getPrincipals().remove(principal);
        }
        return true;
    }
}
