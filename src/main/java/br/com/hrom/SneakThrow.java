package br.com.hrom;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class SneakThrow {

    @SuppressWarnings("unchecked")
    public static <E extends Throwable, T> T sneakyThrow(Throwable ex) throws E {
        throw (E) ex;
    }
}
