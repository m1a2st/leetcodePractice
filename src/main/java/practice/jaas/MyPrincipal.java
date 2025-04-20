package practice.jaas;

import java.security.Principal;
import java.util.Objects;

public class MyPrincipal implements Principal {
    private String name;

    public MyPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        MyPrincipal that = (MyPrincipal) obj;
        return Objects.equals(name, that.getName());
    }

    @Override
    public String toString() {
        return "MyPrincipal{" + "name='" + name + '\'' + '}';
    }
}
