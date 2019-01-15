import static org.mockito.Mockito.*;

class LoginCommandTest{
    @Test
    public void iterator_will_return_hello_world() {
        //подготавливаем
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        //выполняем
        String result = i.next() + " " + i.next();
        //сравниваем
        assertEquals("Hello World", result);
    }
}
