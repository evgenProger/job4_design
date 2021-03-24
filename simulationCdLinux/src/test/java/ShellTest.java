import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShellTest {
    @Test
    public void whenCdBack() throws IOException {
        Shell shell = new Shell();
        shell.cd("/user/..");
        assertThat(shell.pwd(), is("/"));
    }

    @Test
    public void whenCdRoot() throws IOException {
        Shell shell = new Shell();
        shell.cd("/");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() throws IOException {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() throws IOException {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/")
        );
    }
    @Test
    public void whenDotsInMiddle() throws IOException {
        Shell shell = new Shell();
        shell.cd("user/my/../dir");
        assertThat(
                shell.pwd(), is("/dir")
        );
    }

    @Test
    public void whenCdUserLocalMy() throws IOException {
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