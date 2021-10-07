import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShellTest {
    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        shell.cd("/user/..");
        assertThat(shell.pwd(), is("/"));
    }

    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        shell.cd("/");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/")
        );
    }
    @Test
    public void whenDotsInMiddle() {
        Shell shell = new Shell();
        shell.cd("user/my/../dir");
        assertThat(
                shell.pwd(), is("/user/dir")
        );
    }

    @Test
    public void whenCdUserLocalMy() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        shell.cd("my");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }
}