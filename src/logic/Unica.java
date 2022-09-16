package logic;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Unica extends Alarma implements Serializable{
    public Unica(String mensaje, Date momento) {
        super(mensaje, momento);
    }
}
