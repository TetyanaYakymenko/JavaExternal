import org.junit.Test;
import org.junit.runner.RunWith;
import ua.com.finalProject.command.LoginCommand;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;

class LoginCommandTest{
    @Test
    public void LoginCommand_Admin_AdminPage_Test() {
        HttpServletRequest request  = mock(HttpServletRequest.class);
        when(request.getParameter("login")).thenReturn("pertov");
        when(request.getParameter("password")).thenReturn("pass2");
        String expect = "path.page.admin";

        String result = new LoginCommand().execute(request);

        assertEquals(expect, result);
    }
    @Test
    public void LoginCommand_NotExistUser_LoginPAge_Test(){
        HttpServletRequest request  = mock(HttpServletRequest.class);
        when(request.getParameter("login")).thenReturn("qweqwe");
        when(request.getParameter("password")).thenReturn("123123");
        String expect = "path.page.login";
        String result = new LoginCommand().execute(request);

        assertEquals(expect, result);
    }
}
